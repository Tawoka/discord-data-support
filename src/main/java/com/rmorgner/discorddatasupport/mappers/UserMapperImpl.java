package com.rmorgner.discorddatasupport.mappers;

import com.rmorgner.discorddatasupport.domain.User;
import com.rmorgner.discorddatasupport.model.UserDTO;
import org.springframework.stereotype.*;

@Component
public class UserMapperImpl implements UserMapper {

  @Override
  public UserDTO userToUserDto(User user) {
    return new UserDTO(user.getId(), user.getName(), user.getDisplayName());
  }

  @Override
  public User userDtoToUser(UserDTO userDTO) {
    return new User(userDTO.getId(), userDTO.getName(), userDTO.getDisplayName());
  }

}
