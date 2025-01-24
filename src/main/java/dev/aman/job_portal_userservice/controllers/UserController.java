package dev.aman.job_portal_userservice.controllers;

import dev.aman.job_portal_userservice.dtos.UserDTOs;
import dev.aman.job_portal_userservice.models.User;
import dev.aman.job_portal_userservice.services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;
    public UserController(@Qualifier("Applicants") UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    //@RequestBody allows you to automatically map the data from the HTTP request body (such as JSON or XML) into a Java object.
    public ResponseEntity<UserDTOs> registerUser(@RequestBody UserDTOs userDTOs) {
        return new ResponseEntity<>(userService.registerUser(userDTOs), HttpStatus.CREATED);
    }
}
