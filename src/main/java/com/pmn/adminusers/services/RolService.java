package com.pmn.adminusers.services;

import com.pmn.adminusers.domain.entities.Rol;

import java.util.List;

public interface RolService {
    List<Rol> listRoles();
    Rol save(Rol rol);
}
