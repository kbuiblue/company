package com.axonactive.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "department_location")
public class DepartmentLocation {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String location;
    @Column
    private Long deptId;

}
