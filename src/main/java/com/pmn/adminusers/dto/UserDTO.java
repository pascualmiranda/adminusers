package com.pmn.adminusers.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    @NotBlank(message = "El nombre de usuario es requerido")
    private String username;
    @NotBlank(message = "La contraseña de usuario es requerido")
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthDay;
    private Set<Integer> roles;
}
