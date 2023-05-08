package com.example.BodyWatchBackend.model;

import com.example.BodyWatchBackend.dto.ThresholdType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Entity
@Service
@Getter
public class MeasurementWarning {

    @ManyToOne
    private User warningRepcipient;

    @ManyToOne
    private Person person;

    @Column
    private String measurementId;

    @Column
    private ThresholdType threshold;

    @Column
    private String durationInMillis;
}
