package com.pmn.adminusers.services;

import com.pmn.adminusers.dto.RolDTO;
import com.pmn.adminusers.dto.UserDTO;
import com.pmn.adminusers.dto.UserViewDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserViewDTO> listUsers();
    List<UserViewDTO> listUsersDetailed();
    Optional<UserViewDTO> getUserById(Long id);
    UserDTO save(UserDTO userDTO);
    void delete(Long id);
}
