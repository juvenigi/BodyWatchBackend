package com.example.BodyWatchBackend.dto;

import com.example.BodyWatchBackend.model.PersonMeasurement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarningReportDto {

    @JsonIgnore
    private Long recipientId;

    private String firstName;

    private String lastName;

    private ThresholdType threshold;

    private PersonMeasurement anomalyDescription;

    private Long anomalyBegin;

    private Long anomalyEnd;

}
