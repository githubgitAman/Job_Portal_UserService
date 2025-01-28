package dev.aman.job_portal_userservice.controllers;

import dev.aman.job_portal_userservice.dtos.ProfileDTOs;
import dev.aman.job_portal_userservice.services.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    ProfileService profileService;
    public ProfileController(@Qualifier("ApplicantProfile") ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<ProfileDTOs> getProfile(@PathVariable @Valid String email){
        ProfileDTOs profileDTOs = profileService.getProfile(email);
        return new ResponseEntity<>(profileDTOs, HttpStatus.OK);
    }
    @PatchMapping("/update")
    public ResponseEntity<ProfileDTOs> updateProfile(@RequestBody ProfileDTOs profileDTOs){
        ProfileDTOs profileDTOs1 = profileService.updateProfile(profileDTOs);
        return new ResponseEntity<>(profileDTOs1, HttpStatus.OK);
    }

}
