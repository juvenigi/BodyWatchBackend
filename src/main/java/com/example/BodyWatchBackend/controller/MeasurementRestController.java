package com.example.BodyWatchBackend.controller;

import com.example.BodyWatchBackend.model.Person;
import com.example.BodyWatchBackend.model.PersonMeasurement;
import com.example.BodyWatchBackend.service.MeasurementService;
import com.example.BodyWatchBackend.service.WarningService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/measurements")
public class MeasurementRestController {

    MeasurementService measurementService;

    WarningService warningService;

    MeasurementRestController(MeasurementService measurementService, WarningService warningService) {
        this.measurementService = measurementService;
        this.warningService = warningService;
    }
    @GetMapping("{personId}")
    String getMeasurement(@PathVariable() String personId) {
        return personId;
    }

    @PostMapping("{personId}")
    void pushMeasurement(@PathVariable() String personId, @RequestBody PersonMeasurement measurement) {
        this.measurementService.pushMeasurement(measurement, personId);
        this.warningService.checkMeasurement(measurement, personId);
    }

//    @PutMapping("{personId}")

}

