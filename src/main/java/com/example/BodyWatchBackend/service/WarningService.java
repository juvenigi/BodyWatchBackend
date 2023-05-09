package com.example.BodyWatchBackend.service;

import com.example.BodyWatchBackend.dto.ThresholdType;
import com.example.BodyWatchBackend.dto.ValueSpan;
import com.example.BodyWatchBackend.dto.WarningReportDto;
import com.example.BodyWatchBackend.model.MeasurementWarning;
import com.example.BodyWatchBackend.model.PersonMeasurement;
import com.example.BodyWatchBackend.repository.MeasurementRepository;
import com.example.BodyWatchBackend.repository.PersonRepository;
import com.example.BodyWatchBackend.repository.UserRepository;
import com.example.BodyWatchBackend.repository.WarningRepository;
import com.github.f4b6a3.ulid.UlidFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.Objects.isNull;

@Service
public class WarningService {

    private Map<Integer, List<MeasurementWarning>> personWarnings;
    private Map<Integer, List<PersonMeasurement>> collectedWarningMeasurements; // stands for warningId
    private Map<Integer, WarningReportDto> reportDtoMap;
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

    public void checkMeasurement(PersonMeasurement measurement, String personId) {
        List<MeasurementWarning> relevantWarnings = this.personWarnings.get(personId);
        List<MeasurementWarning> matchedWarnings = relevantWarnings.stream()
                .filter((warning) -> this.doesMatchWarning(measurement, warning.getMeasurement(), warning.getThreshold())).toList();
        //.forEach((warning) -> {});
    }

    void updateWarningEntry(MeasurementWarning warning, PersonMeasurement measurement) {
        List<PersonMeasurement> collected = this.collectedWarningMeasurements.get(warning.getId());
        if (isNull(collected)) {
            this.collectedWarningMeasurements
                    .put(warning.getId(), new ArrayList<>(Collections.singletonList(measurement)));
        } else {
            collected.add(measurement);
            this.collectedWarningMeasurements.put(warning.getId(), collected);
        }
    }

    Double getSpanMean(ValueSpan old, ValueSpan pushed) {
        long subtract = Math.max(old.getTimeEnd() - pushed.getTimeBegin(),0);
        long correctedOld = (old.getTimeEnd()-old.getTimeBegin() - subtract);
        long correctedNew =  pushed.getTimeEnd() - Math.min(pushed.getTimeBegin(),old.getTimeEnd());
        long totalTime = correctedNew + correctedOld;

        double weightedOld = old.getValue() *  ( (double) correctedOld / totalTime); // NOTE: be careful with this
        double weightedNew = pushed.getValue() *  ( (double) correctedNew / totalTime);

        return weightedOld + weightedNew;

    }

    MeasurementWarning retrieveWarning(Long warningId) {
        return this.warningRepository.getReferenceById(warningId);
    }

    public Boolean doesMatchWarning(PersonMeasurement measurement, PersonMeasurement threshold, ThresholdType type) {
        boolean flipOperator = type != ThresholdType.MAX;

        List<Double> measured = new ArrayList<>();
        List<Double> thresholdArray = new ArrayList<>();
        BeanUtils.copyProperties(measurement.getMeasurementValues(), measured);
        BeanUtils.copyProperties(threshold.getMeasurementValues(), thresholdArray);
        return !IntStream.range(0, thresholdArray.size()) // need inverse to check if a single violation of the criteria occurs
                .filter((index) -> !isNull(measured.get(index)) || !isNull(thresholdArray.get(index)))
                .mapToObj((index) -> measured.get(index) < thresholdArray.get(index))
                .filter((value) -> value)
                .findFirst().orElse(false);
    }

    public WarningReportDto getReportsforPerson(Long personid) {
        return new WarningReportDto(); //FIXME
    }
}
