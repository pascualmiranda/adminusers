package com.pmn.adminusers.repositories.jdbc.implement;

import com.pmn.adminusers.dto.UserViewDTO;
import com.pmn.adminusers.repositories.jdbc.RolUserJdbcRepository;
import com.pmn.adminusers.repositories.jdbc.implement.row.mapper.RolUserRowMapper;
import org.springframework.jdbc.SQLWarningException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.net.URISyntaxException;
import java.util.List;

@Repository
public class RolUserJdbcRepositoryImpl implements RolUserJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public RolUserJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserViewDTO> listUsersByRolId(Integer rolId) throws SQLWarningException {
        List<UserViewDTO> listUsers=null;
        var sql = """
                SELECT u.id,u.username,u.email,u.created_at,ud.first_name,ud.last_name,ud.age,ud.birth_day 
                FROM "user" u 
                INNER JOIN user_rol ur on (ur.user_id=u.id) 
                LEFT JOIN user_detail ud on (u.id=ud.user_id) 
                WHERE ur.rol_id=? ORDER BY u.username;
                """;
        listUsers=jdbcTemplate.query(sql, new RolUserRowMapper(), rolId);
        return listUsers;
    }
}
