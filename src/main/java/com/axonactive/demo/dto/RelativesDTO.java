package com.axonactive.demo.dto;

import com.axonactive.demo.entities.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelativesDTO {
    private String fullName;
    private Gender gender;
    private String phoneNumber;
    private String relationship;
}
