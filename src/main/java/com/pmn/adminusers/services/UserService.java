package com.pmn.adminusers.services;

import com.pmn.adminusers.dto.UserDTO;
import com.pmn.adminusers.dto.UserViewDTO;

import java.util.List;

public interface UserService {
    List<UserViewDTO> listUsers();
    List<UserViewDTO> listUsersDetailed();
    UserDTO save(UserDTO userDTO);
    void delete(Long id);
}
