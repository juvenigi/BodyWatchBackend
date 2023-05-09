package com.example.BodyWatchBackend.service;

import com.example.BodyWatchBackend.model.PersonMeasurement;
import com.example.BodyWatchBackend.repository.MeasurementRepository;
import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import org.springframework.stereotype.Service;

@Service
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public void pushMeasurement(PersonMeasurement measurement, String personId) {
        Ulid ulid = UlidCreator.getUlid(measurement.getTimeEndInMillis());
        measurement.setId(ulid);
        measurementRepository.saveAndFlush(measurement);

    }

    public void deleteMeasurement(Ulid measurementId) {
        if (measurementRepository.existsById(measurementId)) {
            measurementRepository.deleteById(measurementId);
        }
    }
}
