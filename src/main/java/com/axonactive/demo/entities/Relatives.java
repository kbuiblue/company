package com.axonactive.demo.entities;

import javax.persistence.*;

@Entity
@Table (name = "relatives")
public class Relatives {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String fullName;
    @Column
    private int gender;
    @Column
    private String phoneNumber;
    @Column
    private String relationship;
    @Column
    private String employeeId;
}
