package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdatePayload {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
