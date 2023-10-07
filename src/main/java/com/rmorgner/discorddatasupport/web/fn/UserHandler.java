package com.rmorgner.discorddatasupport.web.fn;

import com.rmorgner.discorddatasupport.constants.UserRestConstants;
import com.rmorgner.discorddatasupport.model.UserDTO;
import com.rmorgner.discorddatasupport.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.*;
import org.springframework.validation.*;
import org.springframework.web.reactive.function.server.*;
import org.springframework.web.server.*;
import org.springframework.web.util.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserHandler {

  private final UserService userService;
  private final Validator validator;

  private void validate(UserDTO userDTO) {
    Errors errors = new BeanPropertyBindingResult(userDTO, "userDTO");
    validator.validate(userDTO, errors);

    if (errors.hasErrors()) {
      throw new ServerWebInputException(errors.toString());
    }
  }

  public Mono<ServerResponse> getAllUserIds(ServerRequest request){
    Flux<String> flux;

    flux = userService.getAllUserIds();

    return ServerResponse.ok().body(flux, String.class);
  }

  public Mono<ServerResponse> saveUser(ServerRequest request){
    return userService.saveUser(
        request.bodyToMono(UserDTO.class)
            .doOnNext(this::validate)
    ).flatMap(userDTO -> ServerResponse.created(
        UriComponentsBuilder.fromPath(UserRestConstants.PATH_WITH_ID.getValue())
            .build(userDTO.getId())
    ).build());
  }

}
