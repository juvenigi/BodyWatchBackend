package com.example.BodyWatchBackend.repository;

import com.example.BodyWatchBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
