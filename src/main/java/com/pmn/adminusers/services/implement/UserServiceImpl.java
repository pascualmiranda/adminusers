package com.pmn.adminusers.services.implement;

import com.pmn.adminusers.domain.entities.User;
import com.pmn.adminusers.repositories.UserRepository;
import com.pmn.adminusers.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
