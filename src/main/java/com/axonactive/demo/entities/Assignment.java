package com.axonactive.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "assignment")
public class Assignment {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private int numberOfHour;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employeeId;
    @ManyToOne
    @JoinColumn (name = "projectId")
    private Project projectId;
}
