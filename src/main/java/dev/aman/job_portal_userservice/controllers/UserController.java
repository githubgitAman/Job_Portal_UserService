package dev.aman.job_portal_userservice.controllers;

import dev.aman.job_portal_userservice.dtos.LoginDTOs;
import dev.aman.job_portal_userservice.dtos.OTPDTOs;
import dev.aman.job_portal_userservice.dtos.UserDTOs;
import dev.aman.job_portal_userservice.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    UserService userService;
    public UserController(@Qualifier("ApplicantsUser") UserService userService) {

        this.userService = userService;
    }

    @PostMapping("/register")
    //@RequestBody allows you to automatically map the data from the HTTP request body (such as JSON or XML) into a Java object.
    public ResponseEntity<UserDTOs> registerUser(@RequestBody @Valid UserDTOs userDTOs) {
        return new ResponseEntity<>(userService.registerUser(userDTOs), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public void loginUser(@RequestBody LoginDTOs loginDTOs) {

        userService.loginUser(loginDTOs);
    }
    @PostMapping("/sendOtp/{email}")
    public ResponseEntity<OTPDTOs> otpLogin(@PathVariable String email) throws Exception {
        userService.generateOTP(email);
        OTPDTOs otpDTOs = new OTPDTOs();
        otpDTOs.setMessage("OTP generated successfully");
        return new ResponseEntity<>(otpDTOs, HttpStatus.OK);
    }
    @GetMapping("/verifyOTP/{email}/{otp}")
    public ResponseEntity<OTPDTOs> verifyOtp(@PathVariable String email, @PathVariable String otp) throws Exception {
        userService.verifyOTP(email, otp);
        OTPDTOs otpDTOs = new OTPDTOs();
        otpDTOs.setMessage("OTP verified successfully");
        return new ResponseEntity<>(otpDTOs, HttpStatus.OK);
    }

}
