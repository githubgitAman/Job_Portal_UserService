package dev.aman.job_portal_userservice.services;

import dev.aman.job_portal_userservice.dtos.JobDTOs;
import dev.aman.job_portal_userservice.models.Job;
import dev.aman.job_portal_userservice.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("employeeJobService")
public class EmployeeJobService implements JobService {
    JobRepository jobRepository;
    public EmployeeJobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public void createJob(JobDTOs jobDTOs) {
        jobDTOs.setPostTime(LocalDateTime.now());
        Job job = jobDTOs.jobDTOsToJob();
        jobRepository.save(job);
    }

    @Override
    public List<JobDTOs> getAllJobs() {
        return jobRepository.findAll().stream().map((x) -> x.jobToJobDTOs()).toList();
    }

    @Override
    public JobDTOs getJob(Long Id) {
        Optional<Job> job = jobRepository.findById(Id);
        if(!job.isPresent()) {
            throw new RuntimeException("No job available for given id");
        }
        JobDTOs jobDTOs = job.get().jobToJobDTOs();
        return jobDTOs;
    }
}
