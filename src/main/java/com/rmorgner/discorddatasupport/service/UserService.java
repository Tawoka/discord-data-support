package com.rmorgner.discorddatasupport.service;

import com.rmorgner.discorddatasupport.model.UserDTO;
import org.springframework.stereotype.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface UserService {

  Flux<String> getAllUserIds();

  Mono<UserDTO> saveUser(Mono<UserDTO> userDTO);

}
