package com.pmn.adminusers.services.mapper;

import com.pmn.adminusers.domain.entities.User;
import com.pmn.adminusers.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements CustomMapper<UserDTO, User> {

    @Override
    public UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword("******");
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public UserDTO toDtoDetailed(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword("******");
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getUserDetail().getFirstName());
        userDTO.setLastName(user.getUserDetail().getLastName());
        userDTO.setAge(user.getUserDetail().getAge());
        userDTO.setBirthDay(user.getUserDetail().getBirthDay());
        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        User user=new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
