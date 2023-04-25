package com.axonactive.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
