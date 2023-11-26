package com.pmn.adminusers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    private String firstName;
    private String lastName;
    private Integer age;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDay;
}
