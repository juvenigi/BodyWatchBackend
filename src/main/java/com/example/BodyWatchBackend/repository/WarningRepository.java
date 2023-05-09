package com.example.BodyWatchBackend.repository;

import com.example.BodyWatchBackend.model.MeasurementWarning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarningRepository extends JpaRepository<MeasurementWarning, Long> {

}
