package com.pmn.adminusers.services.mapper;

import com.pmn.adminusers.domain.entities.User;
import com.pmn.adminusers.dto.UserDTO;
import com.pmn.adminusers.dto.UserViewDTO;
import org.springframework.stereotype.Component;

@Component
public class UserViewMapper implements CustomMapper<UserViewDTO, User> {
    @Override
    public UserViewDTO toDto(User user) {
        UserViewDTO userDTO = new UserViewDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setCreatedAt(user.getCreatedAt());
        return userDTO;
    }

    @Override
    public User toEntity(UserViewDTO userViewDTO) {
        return null;
    }
}
