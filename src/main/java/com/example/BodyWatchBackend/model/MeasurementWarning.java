package com.example.BodyWatchBackend.model;

import com.example.BodyWatchBackend.dto.ThresholdType;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Entity
@Service
@Getter
public class MeasurementWarning {

    @Id
    private Integer id;

    @ManyToOne
    private User warningRecipient;

    @OneToOne
    private PersonMeasurement measurement;

    @Column
    private ThresholdType threshold;

    @Column
    private String description;
}
