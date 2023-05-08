package com.example.BodyWatchBackend.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

public interface IMeasurement {
    public double getWeightInKg();
    public double getHeightInCm();
}