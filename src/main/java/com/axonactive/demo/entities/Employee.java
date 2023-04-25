package com.axonactive.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "employee")
public class Employee {
    @Id
    private String employeeId;
    @Column
    private LocalDate dateOfBirth;
    @Column
    private String firstName;
    @Column
    private String gender;
    @Column
    private String lastName;
    @Column
    private String middleName;
    @Column
    private int salary;
    @ManyToOne
    @JoinColumn (name = "deptId")
    private Department departmentId;
}
