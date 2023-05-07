package com.example.BodyWatchBackend.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/measurement")
public class MeasurementRestController {

    @GetMapping("{personId}")
    String getMeasurement(@PathVariable() String personId) {
        return personId;
    }

}

