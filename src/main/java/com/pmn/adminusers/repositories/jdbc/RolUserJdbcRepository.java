package com.pmn.adminusers.repositories.jdbc;

import com.pmn.adminusers.dto.UserViewDTO;

import java.util.List;

public interface RolUserJdbcRepository {
    List<UserViewDTO> listUsersByRolId(Integer rolId);
}
