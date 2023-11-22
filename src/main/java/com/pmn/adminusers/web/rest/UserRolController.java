package com.pmn.adminusers.web.rest;

import com.pmn.adminusers.services.UserRolService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/userRoles")
public class UserRolController {
    private final UserRolService userRolService;

    public UserRolController(UserRolService userRolService) {
        this.userRolService = userRolService;
    }
    @PatchMapping("/{id}")
    public boolean inActive(@PathVariable final Integer id){
        return userRolService.inActive(id);
    }

}
