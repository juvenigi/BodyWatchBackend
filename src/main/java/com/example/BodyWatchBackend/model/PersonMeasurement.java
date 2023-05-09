package com.example.BodyWatchBackend.model;

import com.github.f4b6a3.ulid.Ulid;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.Columns;

@Setter
@Getter
@Entity
public class PersonMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Ulid id;


    @ManyToOne
    private Person person;

    @Column
    private Long timeBeginInMillis;

    @Column
    private Long timeEndInMillis;

    @Embedded
    private MeasurementValues measurementValues;
}
