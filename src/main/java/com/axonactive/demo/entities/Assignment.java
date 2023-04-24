package com.axonactive.demo.entities;

import javax.persistence.*;

@Entity
@Table (name = "assignment")
public class Assignment {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private int numberOfHour;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @Column
    private Long projectId;
}
