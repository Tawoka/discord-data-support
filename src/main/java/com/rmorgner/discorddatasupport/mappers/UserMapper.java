package com.rmorgner.discorddatasupport.mappers;

import com.rmorgner.discorddatasupport.domain.User;
import com.rmorgner.discorddatasupport.model.UserDTO;
import reactor.core.publisher.Mono;

public interface UserMapper {

  UserDTO userToUserDto(User user);

  User userDtoToUser(UserDTO userDTO);

}
