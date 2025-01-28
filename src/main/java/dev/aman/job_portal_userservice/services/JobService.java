package dev.aman.job_portal_userservice.services;

import dev.aman.job_portal_userservice.dtos.ApplicantsDTOs;
import dev.aman.job_portal_userservice.dtos.ApplicationsDTOs;
import dev.aman.job_portal_userservice.dtos.JobDTOs;

import java.util.List;

public interface JobService {
    public void createJob(JobDTOs jobDTOs);
    public List<JobDTOs> getAllJobs();
    public JobDTOs getJob(Long Id);
    public void applyJob(Long id, ApplicantsDTOs applicantsDTOs);
    public List<JobDTOs> postedBy(Long id);
}
