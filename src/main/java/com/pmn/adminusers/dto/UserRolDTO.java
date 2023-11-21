package com.pmn.adminusers.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRolDTO {
    private Integer id;
    private boolean active;
    private LocalDateTime createdAt;
}
