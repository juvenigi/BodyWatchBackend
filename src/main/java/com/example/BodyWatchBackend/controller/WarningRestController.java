package com.example.BodyWatchBackend.controller;

import com.example.BodyWatchBackend.dto.WarningReportDto;
import com.example.BodyWatchBackend.service.WarningService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warnings")
public class WarningRestController {

    private final WarningService warningService;

    WarningRestController(WarningService warningService) {
        this.warningService = warningService;
    }
    @GetMapping("/{personid}")
    WarningReportDto getWarningsForPerson(@PathVariable Long personid) {
        return this.warningService.getReportsforPerson(personid);
    }
}
