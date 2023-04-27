package com.axonactive.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "project")
public class Project {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column
    private String area;

    @Column
    private String projectName;

    @ManyToOne
    @JoinColumn(name = "managedDepartment")
    private Department department;
}
