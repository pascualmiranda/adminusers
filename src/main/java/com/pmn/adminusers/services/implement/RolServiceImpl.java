package com.pmn.adminusers.services.implement;

import com.pmn.adminusers.domain.entities.Rol;
import com.pmn.adminusers.repositories.RolRepository;
import com.pmn.adminusers.services.RolService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {
    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Rol> listRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }
}
