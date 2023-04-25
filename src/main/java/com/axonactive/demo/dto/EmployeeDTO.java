package com.axonactive.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private LocalDate dateOfBirth;

    private String firstName;

    private String lastName;

    private String middleName;

    private String gender;

    private int salary;
}
