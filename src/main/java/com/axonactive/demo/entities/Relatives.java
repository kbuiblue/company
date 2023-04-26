package com.axonactive.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "relatives")
public class Relatives {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String fullName;
    @Column
    private int gender;
    @Column
    private String phoneNumber;
    @Column
    private String relationship;
    @ManyToOne
    @JoinColumn (name = "employeeId")
    private Employee employeeId;
}
