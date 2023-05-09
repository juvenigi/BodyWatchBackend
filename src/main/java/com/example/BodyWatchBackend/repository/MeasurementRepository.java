package com.example.BodyWatchBackend.repository;

import com.example.BodyWatchBackend.model.PersonMeasurement;
import com.github.f4b6a3.ulid.Ulid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<PersonMeasurement, Ulid> {
    public PersonMeasurement getPersonMeasurementsByPersonId(Long personId);

    public PersonMeasurement getPersonMeasurementsById(Ulid measurementId);

    public void deleteById(Ulid id);

}
