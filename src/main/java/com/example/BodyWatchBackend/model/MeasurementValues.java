package com.example.BodyWatchBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class MeasurementValues {

    private double heartRateBpm;

    private double bloodPressureHgMm;

    private double temperatureInC;

    private double weightInKg;

    private double heightInCm;
}
