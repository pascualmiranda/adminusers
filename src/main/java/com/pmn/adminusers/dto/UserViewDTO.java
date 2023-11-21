package com.pmn.adminusers.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserViewDTO {
    private Long id;
    private String username;
    private String email;
    private LocalDateTime createdAt;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthDay;
}
