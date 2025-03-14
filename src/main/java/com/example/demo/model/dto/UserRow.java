package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRow {

    private Long id;
    private String firstName;
    private String lastName;
    private Boolean isAdult;

}
