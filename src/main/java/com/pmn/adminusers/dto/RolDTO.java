package com.pmn.adminusers.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RolDTO {
    private  Integer id;
    @NotBlank(message = "El nombre de rol es requerido")
    private String name;

}
