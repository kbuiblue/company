package com.axonactive.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "department")
public class Department {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long departmentId;
    @Column
    private String departmentName;
    @Column
    private LocalDate startDate;
}
