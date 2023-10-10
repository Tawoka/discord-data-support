package com.rmorgner.discorddatasupport.web.fn;

import com.rmorgner.discorddatasupport.constants.UserRestConstants;
import com.rmorgner.discorddatasupport.model.ChannelDTO;
import com.rmorgner.discorddatasupport.model.UserDTO;
import com.rmorgner.discorddatasupport.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.*;
import org.springframework.validation.*;
import org.springframework.web.reactive.function.server.*;
import org.springframework.web.server.*;
import org.springframework.web.util.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChannelHandler {

  private final ChannelService channelService;
  private final Validator validator;

  private void validate(ChannelDTO channelDTO) {
    Errors errors = new BeanPropertyBindingResult(channelDTO, "channelDTO");
    validator.validate(channelDTO, errors);

    if (errors.hasErrors()) {
      throw new ServerWebInputException(errors.toString());
    }
  }

  public Mono<ServerResponse> getAllChannelIds(ServerRequest request){
    Flux<String> flux;
    flux = channelService.getAllChannelIds();
    Mono<List<String>> data = flux.collectList();
    return ServerResponse.ok().body(data, List.class);
  }

  public Mono<ServerResponse> saveChannel(ServerRequest request){
    return channelService.saveChannel(
        request.bodyToMono(ChannelDTO.class)
            .doOnNext(this::validate)
    ).flatMap(channelDTO -> ServerResponse.created(
        UriComponentsBuilder.fromPath(UserRestConstants.PATH_WITH_ID.getValue())
            .build(channelDTO.getId())
    ).build());
  }

}
