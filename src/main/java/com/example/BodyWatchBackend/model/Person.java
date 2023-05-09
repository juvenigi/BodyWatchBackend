package com.example.BodyWatchBackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

//    @OneToMany
//    private List<PersonMeasurement> measurement;
}
