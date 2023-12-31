package com.pmn.adminusers.services.implement;

import com.pmn.adminusers.domain.entities.Rol;
import com.pmn.adminusers.dto.RolDTO;
import com.pmn.adminusers.dto.UserViewDTO;
import com.pmn.adminusers.repositories.RolRepository;
import com.pmn.adminusers.repositories.jdbc.RolUserJdbcRepository;
import com.pmn.adminusers.services.RolService;
import com.pmn.adminusers.services.mapper.RolMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements RolService {
    private final RolRepository rolRepository;
    private final RolMapper rolMapper;
    private final RolUserJdbcRepository rolUserJdbcRepository;
    public RolServiceImpl(RolRepository rolRepository, RolMapper rolMapper, RolUserJdbcRepository rolUserJdbcRepository) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
        this.rolUserJdbcRepository = rolUserJdbcRepository;
    }

    @Override
    public List<RolDTO> listRoles() {
        return rolRepository.findAll()
                .stream()
                .map(rolMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UserViewDTO> listUsersByRolId(Integer rolId) {
        return rolUserJdbcRepository.listUsersByRolId(rolId);
    }

    @Override
    public Optional<RolDTO> getRolById(Integer id) {
        return rolRepository.findById(id).map(rolMapper::toDto);
    }

    @Override
    public void delete(Integer id) {
        rolRepository.deleteById(id);
    }

    @Override
    public RolDTO save(RolDTO dto) {
        Rol rol=rolRepository.save(rolMapper.toEntity(dto));
        return rolMapper.toDto(rol);
    }
}
