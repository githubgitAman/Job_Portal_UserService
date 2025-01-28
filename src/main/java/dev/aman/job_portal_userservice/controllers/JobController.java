package dev.aman.job_portal_userservice.controllers;

import dev.aman.job_portal_userservice.dtos.JobDTOs;
import dev.aman.job_portal_userservice.services.JobService;
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
    public String postJob(@RequestBody JobDTOs jobDTOs){
        jobService.createJob(jobDTOs);
        return "Job created successfully";
    }
    @GetMapping("/getAllJob")
    public ResponseEntity<List<JobDTOs>> getAllJob(){
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }
    @GetMapping("/getJob/{id}")
    public ResponseEntity<JobDTOs> getJob(@PathVariable Long id){
        return new ResponseEntity<>(jobService.getJob(id), HttpStatus.OK);
    }
}
