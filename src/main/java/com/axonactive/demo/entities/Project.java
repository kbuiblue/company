package com.axonactive.demo.entities;

import javax.persistence.*;

@Entity
@Table (name = "project")
public class Project {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long projectId;
    @Column
    private String area;
    @Column
    private String projectName;
    @ManyToOne
    @JoinColumn(name = "managedDepartment")
    private Department department;
}
