package com.axonactive.demo.dto;

import com.axonactive.demo.entities.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagedProjectDTO {
    private Long deptId;
    private Project managedProject;
}
