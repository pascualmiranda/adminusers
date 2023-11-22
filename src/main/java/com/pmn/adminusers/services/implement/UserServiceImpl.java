package com.pmn.adminusers.services.implement;

import com.pmn.adminusers.domain.entities.Rol;
import com.pmn.adminusers.domain.entities.User;
import com.pmn.adminusers.domain.entities.UserDetail;
import com.pmn.adminusers.domain.entities.UserRol;
import com.pmn.adminusers.dto.UserDTO;
import com.pmn.adminusers.dto.UserViewDTO;
import com.pmn.adminusers.repositories.RolRepository;
import com.pmn.adminusers.repositories.UserDetailRepository;
import com.pmn.adminusers.repositories.UserRepository;
import com.pmn.adminusers.repositories.UserRolRepository;
import com.pmn.adminusers.services.RolService;
import com.pmn.adminusers.services.UserService;
import com.pmn.adminusers.services.mapper.UserMapper;
import com.pmn.adminusers.services.mapper.UserViewMapper;
import org.antlr.v4.runtime.misc.Array2DHashSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserDetailRepository userDetailRepository;
    private final UserMapper userMapper;
    private final UserViewMapper userViewMapper;
    private final UserRolRepository userRolRepository;
    private final RolRepository rolRepository;

    public UserServiceImpl(UserRepository userRepository, UserDetailRepository userDetailRepository, UserMapper userMapper, UserViewMapper userViewMapper, UserRolRepository userRolRepository, RolRepository rolRepository, RolService rolService, RolRepository rolRepository1) {
        this.userRepository = userRepository;
        this.userDetailRepository = userDetailRepository;
        this.userMapper = userMapper;
        this.userViewMapper = userViewMapper;
        this.userRolRepository = userRolRepository;
        this.rolRepository = rolRepository1;
    }

    @Override
    public List<UserViewDTO> listUsers() {

        return userRepository.findAll()
                .stream()
                .map(userViewMapper::toDto).collect(Collectors.toList());
    }
    public List<UserViewDTO> listUsersDetailed() {

        return userRepository.findAll()
                .stream()
                .map(userViewMapper::toDtoDetailed).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDTO save(UserDTO userDTO) {
        User user=userRepository.save(userMapper.toEntity(userDTO));
        if (userDTO.getFirstName()!=null){
            UserDetail userDetail=new UserDetail(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getAge(), userDTO.getBirthDay(),user);
            userDetailRepository.save(userDetail);
        }
        if(userDTO.getRoles()!=null) {
            Set<UserRol> userRoles= new HashSet<>();
            for (Integer idUserRol: userDTO.getRoles()) {
                if(rolRepository.existsById(idUserRol)){

                    userRoles.add(new UserRol(true, user,rolRepository.findById(idUserRol).get()));
                }
            }
            userRolRepository.saveAll(userRoles);
        }
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
