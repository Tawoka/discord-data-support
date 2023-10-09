package com.rmorgner.discorddatasupport.service;

import com.rmorgner.discorddatasupport.domain.User;
import com.rmorgner.discorddatasupport.mappers.UserMapper;
import com.rmorgner.discorddatasupport.model.UserDTO;
import com.rmorgner.discorddatasupport.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public Flux<String> getAllUserIds() {
    return userRepository.findAll().map(User::getId);
  }

  @Override
  public Mono<UserDTO> saveUser(Mono<UserDTO> userDTO) {
    return userDTO.map(userMapper::userDtoToUser)
        .flatMap(userRepository::save)
        .map(userMapper::userToUserDto);
  }

}
