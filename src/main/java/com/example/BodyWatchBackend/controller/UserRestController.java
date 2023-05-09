package com.example.BodyWatchBackend.controller;

import com.example.BodyWatchBackend.model.User;
import com.example.BodyWatchBackend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private final UserRepository userRepository;

    UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public void pushUser(@RequestBody User user) {
        Optional<User> found = this.userRepository.findById(user.getId());
        if (found.isPresent()) return;

        this.userRepository.saveAndFlush(user);
    }

    @GetMapping("/{userid}")
    public User getUser(@PathVariable Long userid) {
        return this.userRepository.getReferenceById(userid);
    }
}
