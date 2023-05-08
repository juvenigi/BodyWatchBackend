package com.example.BodyWatchBackend.dto;

import com.example.BodyWatchBackend.model.PersonMeasurement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarningDto {

    private String userId;

    private String personId;

    private String measurementId;

    private ThresholdType threshold;

    private String durationInMillis;


}
