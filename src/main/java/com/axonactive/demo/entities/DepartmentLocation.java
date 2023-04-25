package com.axonactive.demo.entities;

import org.hibernate.mapping.Join;

import javax.persistence.*;

@Entity
@Table(name = "department_location")
public class DepartmentLocation {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String location;
    @ManyToOne
    @JoinColumn (name = "deptId")
    private Department departmentId;
}
