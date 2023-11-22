package com.pmn.adminusers.services.implement;

import com.pmn.adminusers.domain.entities.UserRol;
import com.pmn.adminusers.repositories.UserRolRepository;
import com.pmn.adminusers.services.UserRolService;
import org.springframework.stereotype.Service;

@Service
public class UserRolServiceImpl implements UserRolService {
    private final UserRolRepository userRolRepository;

    public UserRolServiceImpl(UserRolRepository userRolRepository) {
        this.userRolRepository = userRolRepository;
    }

    @Override
    public boolean inActive(Integer id) {
        if(userRolRepository.existsById(id)) {
            UserRol userRol1=userRolRepository.findById(id).get();
            userRol1.setActive(false);
            userRolRepository.save(userRol1);
            return true;
        }
        else {
            return false;
        }
    }
}
