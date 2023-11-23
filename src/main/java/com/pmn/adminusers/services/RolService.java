package com.pmn.adminusers.services;

import com.pmn.adminusers.domain.entities.Rol;
import com.pmn.adminusers.dto.RolDTO;
import com.pmn.adminusers.dto.UserViewDTO;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<RolDTO> listRoles();
    List<UserViewDTO> listUsersByRolId(Integer rolId);
    RolDTO save(RolDTO rolDTO);
    Optional<RolDTO> getRolById(Integer id);
    void delete(Integer id);
}
