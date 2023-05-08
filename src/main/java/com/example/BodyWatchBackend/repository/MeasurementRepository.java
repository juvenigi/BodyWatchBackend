package com.example.BodyWatchBackend.repository;

import com.example.BodyWatchBackend.model.PersonMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<PersonMeasurement, String> {
    public PersonMeasurement getPersonMeasurementsByPersonId(String personId);

    public PersonMeasurement getPersonMeasurementsById(String measurementId);

    public void deleteById(String id);

}
