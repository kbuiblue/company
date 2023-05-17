package com.axonactive.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "assignment")
public class Assignment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
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
