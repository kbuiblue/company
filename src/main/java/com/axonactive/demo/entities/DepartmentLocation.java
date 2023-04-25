package com.axonactive.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
