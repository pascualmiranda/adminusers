package com.pmn.adminusers.services;

import com.pmn.adminusers.domain.entities.Rol;
import com.pmn.adminusers.dto.RolDTO;

import java.util.List;

public interface RolService {
    List<RolDTO> listRoles();
    RolDTO save(RolDTO rolDTO);
}
