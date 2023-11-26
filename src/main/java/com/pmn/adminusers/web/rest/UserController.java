package com.pmn.adminusers.web.rest;

import com.pmn.adminusers.dto.RolDTO;
import com.pmn.adminusers.dto.UserDTO;
import com.pmn.adminusers.dto.UserViewDTO;
import com.pmn.adminusers.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

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
    @GetMapping("/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable final Long id){
        return ResponseEntity
                .ok()
                .body(userService.getUserById(id).orElseThrow(() -> new IllegalArgumentException("Excepción. recurso no encontrado para id: " + id)));
    }
    @PostMapping
    public ResponseEntity<UserDTO> create(@Valid @RequestBody final UserDTO userDTO) throws URISyntaxException {
        /*if(user.getId()!=null){
            throw new IllegalArgumentException("El nuevo estudiante no puede tener un id.");
        }*/
        UserDTO userDB=userService.save(userDTO);
        return ResponseEntity.created(new URI("v1/users"+userDB.getId())).body(userDB);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> editUser(@Valid @RequestBody final UserDTO userDTO, @PathVariable final Long id) throws URISyntaxException {
        if(userDTO.getId()==null){
            throw new IllegalArgumentException("Para esta operación Se requiere un id.");
        }
        if (!Objects.equals(userDTO.getId(), id)) {
            throw new IllegalArgumentException("Id no valido");
        }
        userDTO.setId(id);
        UserDTO userDB=userService.save(userDTO);
        return ResponseEntity.created(new URI("v1/users"+userDB.getId())).body(userDB);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
