package com.damini.evoting.controller;

import com.damini.evoting.entity.User;
import com.damini.evoting.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {

        try {

            User registeredUser = userService.registerUser(user);

            registeredUser.setPassword(null);

            return ResponseEntity.ok(registeredUser);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(
            @RequestBody LoginRequest loginRequest) {

        try {

            User user = userService.loginUser(
                    loginRequest.getEmail(),
                    loginRequest.getPassword()
            );

            user.setPassword(null);

            return ResponseEntity.ok(user);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}