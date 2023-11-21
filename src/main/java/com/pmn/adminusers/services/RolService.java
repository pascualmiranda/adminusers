package com.pmn.adminusers.services;

import com.pmn.adminusers.domain.entities.Rol;
import com.pmn.adminusers.dto.RolDTO;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<RolDTO> listRoles();
    RolDTO save(RolDTO rolDTO);
    Optional<RolDTO> getRolById(Integer id);
    void delete(Integer id);
}
