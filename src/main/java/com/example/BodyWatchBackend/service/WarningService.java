package com.example.BodyWatchBackend.service;

import com.example.BodyWatchBackend.dto.ThresholdType;
import com.example.BodyWatchBackend.model.MeasurementWarning;
import com.example.BodyWatchBackend.model.PersonMeasurement;
import com.example.BodyWatchBackend.repository.MeasurementRepository;
import com.example.BodyWatchBackend.repository.PersonRepository;
import com.example.BodyWatchBackend.repository.UserRepository;
import com.example.BodyWatchBackend.repository.WarningRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.Objects.isNull;

@Service
public class WarningService {

    private Map<String, List<MeasurementWarning>> personWarnings;
    private Map<String, List<PersonMeasurement>> collectedWarningMeasurements;

    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final WarningRepository warningRepository;
    private final MeasurementRepository measurementRepository;

    public WarningService(
            UserRepository userRepository,
            PersonRepository personRepository,
            WarningRepository warningRepository,
            MeasurementRepository measurementRepository
    ) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
        this.warningRepository = warningRepository;
        this.measurementRepository = measurementRepository;
    }

    void checkMeasurement(PersonMeasurement measurement, String personId) {
        List<MeasurementWarning> warnings = this.personWarnings.get(personId);

        List<MeasurementWarning> relevantWarnings = this.personWarnings.get(personId);
        relevantWarnings.stream().filter((warning))
    }

    boolean isWarning(PersonMeasurement measurement, MeasurementWarning warning) {

    }

    public Boolean doesMatchWarning(PersonMeasurement measurement, PersonMeasurement threshold, ThresholdType type) {
        boolean flipOperator;
        if (type == ThresholdType.MAX) {
            flipOperator = false;
        } else {
            flipOperator = true;
        }
        double[] measured = new double[];
        double[] thresholdArray = new double[];
        BeanUtils.copyProperties(measurement, measured);
        BeanUtils.copyProperties(threshold, thresholdArray);
        return IntStream.range(0, thresholdArray.length)
                .filter((index) -> !isNull(measured[index]) || !isNull(thresholdArray[index]))
                .mapToObj((index) -> measured[index] > thresholdArray[index])
                .filter((value) -> value)
                .findFirst().orElse(false);

    }
