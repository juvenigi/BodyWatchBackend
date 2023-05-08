package com.example.BodyWatchBackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String birthDate;

    @ManyToOne
    @JoinColumn(name = "PersonMeasurement_id")
    private PersonMeasurement[] measurement;
}
