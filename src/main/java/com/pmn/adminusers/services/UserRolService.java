package com.pmn.adminusers.services;

import com.pmn.adminusers.domain.entities.UserRol;
import com.pmn.adminusers.dto.UserDTO;

public interface UserRolService {
    boolean inActive(Integer id);
}
