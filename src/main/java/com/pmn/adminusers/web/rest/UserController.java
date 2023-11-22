package com.pmn.adminusers.web.rest;

import com.pmn.adminusers.dto.UserDTO;
import com.pmn.adminusers.dto.UserViewDTO;
import com.pmn.adminusers.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<List<UserViewDTO>> listUsers(@RequestParam(required = false, defaultValue = "false") boolean detailed){
        if (detailed) {
            return ResponseEntity.ok().body(userService.listUsersDetailed());
        }
        else {
            return ResponseEntity.ok().body(userService.listUsers());
        }

    }
    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody final UserDTO userDTO) throws URISyntaxException {
        /*if(user.getId()!=null){
            throw new IllegalArgumentException("El nuevo estudiante no puede tener un id.");
        }*/
        UserDTO userDB=userService.save(userDTO);
        return ResponseEntity.created(new URI("v1/users"+userDB.getId())).body(userDB);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
