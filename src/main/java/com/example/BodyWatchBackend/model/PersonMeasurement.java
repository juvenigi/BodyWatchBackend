package com.example.BodyWatchBackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@Entity
public class PersonMeasurement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private String id;

    //Foreign key
    @Column
    private String personId;

    @Column
    private String timeBegin;

    @Column
    private String timeEnd;

    @Column
    private double heartRateBpm;

    @Column
    private double bloodPressureHgMm;

    @Column
    private double temperatureInC;

    @Column
    private double weightInKg;

    @Column
    private double heightInCm;

}
