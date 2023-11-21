package com.pmn.adminusers.web.rest;

import com.pmn.adminusers.domain.entities.User;
import com.pmn.adminusers.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<List<User>> listUsers(){

        return ResponseEntity.ok().body(userService.listUsers());
    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody final User user) throws URISyntaxException {
        if(user.getId()!=null){
            throw new IllegalArgumentException("El nuevo estudiante no puede tener un id.");
        }
        //user.setCreatedAt(LocalDateTime.now());
        User userDB=userService.save(user);
        return ResponseEntity.created(new URI("v1/users"+userDB.getId())).body(userDB);
    }
}
