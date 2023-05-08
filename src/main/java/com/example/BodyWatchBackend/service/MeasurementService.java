package com.example.BodyWatchBackend.service;

import com.example.BodyWatchBackend.model.PersonMeasurement;
import com.example.BodyWatchBackend.repository.MeasurementRepository;
import org.springframework.stereotype.Service;

@Service
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public void pushMeasurement(PersonMeasurement measurement, String personId) {
        measurementRepository.saveAndFlush(measurement);

    }

    public void deleteMeasurement(String measurementId) {
        if (measurementRepository.existsById(measurementId)) {
            measurementRepository.deleteById(measurementId);
        }
    }
}
