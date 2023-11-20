package com.pmn.adminusers.services;

import com.pmn.adminusers.domain.entities.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    User save(User user);
}
