package com.axonactive.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelativesDTO {
    private String fullName;
    private int gender;
    private String phoneNumber;
    private String relationship;
}
