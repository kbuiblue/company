package com.axonactive.demo.dto;

import com.axonactive.demo.entities.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCustomDTO {

    private String employeeId;

    private LocalDate dateOfBirth;

    private String firstName;

    private String lastName;

    private String middleName;

    private Gender gender;

    private int salary;

    private List<RelativesDTO> relativesList;
}
