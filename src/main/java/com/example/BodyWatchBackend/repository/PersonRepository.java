package com.example.BodyWatchBackend.repository;

import com.example.BodyWatchBackend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}
