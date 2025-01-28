package dev.aman.job_portal_userservice.controllers;

import dev.aman.job_portal_userservice.dtos.ApplicantsDTOs;
import dev.aman.job_portal_userservice.dtos.ApplicationsDTOs;
import dev.aman.job_portal_userservice.dtos.JobDTOs;
import dev.aman.job_portal_userservice.models.Applicants;
import dev.aman.job_portal_userservice.services.JobService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jobs")
public class JobController {
    JobService jobService;
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/postJob")
    public ResponseEntity<String> postJob(@RequestBody JobDTOs jobDTOs){
        jobService.createJob(jobDTOs);
        return ResponseEntity.ok("Job created successfully");
    }
    @GetMapping("/getAllJob")
    public ResponseEntity<List<JobDTOs>> getAllJob(){
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }
    @GetMapping("/getJob/{id}")
    public ResponseEntity<JobDTOs> getJob(@PathVariable Long id){
        return new ResponseEntity<>(jobService.getJob(id), HttpStatus.OK);
    }
    @PostMapping("/apply/{id}")
    public ResponseEntity<String> applyJob(@PathVariable Long id, @RequestBody ApplicantsDTOs applicantsDTOs){
        jobService.applyJob(id, applicantsDTOs);
        return ResponseEntity.ok("Applicants applied successfully");
    }
    @GetMapping("/postedBy/{id}")
    public ResponseEntity<List<JobDTOs>> postedBy(@PathVariable Long id){
        return new ResponseEntity<>(jobService.postedBy(id), HttpStatus.OK);
    }
}
