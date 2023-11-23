package com.pmn.adminusers.repositories.jdbc.implement.row.mapper;

import com.pmn.adminusers.dto.UserViewDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RolUserRowMapper implements RowMapper<UserViewDTO> {
    @Override
    public UserViewDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserViewDTO(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getTimestamp("created_at").toLocalDateTime(),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getInt("age"),
                rs.getTimestamp("birth_day").toLocalDateTime().toLocalDate()
        );
    }
}
