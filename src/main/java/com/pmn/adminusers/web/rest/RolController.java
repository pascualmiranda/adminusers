package com.pmn.adminusers.web.rest;

import com.pmn.adminusers.domain.entities.Rol;
import com.pmn.adminusers.domain.entities.User;
import com.pmn.adminusers.dto.RolDTO;
import com.pmn.adminusers.services.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("v1/roles")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }
    @GetMapping
    public ResponseEntity<List<RolDTO>> listRoles(){

        return ResponseEntity.ok().body(rolService.listRoles());
    }
    @PostMapping
    public ResponseEntity<RolDTO> create(@RequestBody final RolDTO rol) throws URISyntaxException {
        if(rol.getId()!=null){
            throw new IllegalArgumentException("El nuevo estudiante no puede tener un id.");
        }
        RolDTO rolDB=rolService.save(rol);
        return ResponseEntity.created(new URI("v1/roles"+rolDB.getId())).body(rolDB);
    }
}
