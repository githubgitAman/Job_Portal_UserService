package dev.aman.job_portal_userservice.dtos;

import dev.aman.job_portal_userservice.models.Applicants;
import dev.aman.job_portal_userservice.models.Job;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

public class JobDTOs {
    @NotBlank(message = "job title not provided")
    private String jobTitle;
    @NotBlank(message = "company name not provided")
    private String company;
    private List<Applicants> applicants;
    private String about;
    @NotBlank(message = "job experience needed not provided")
    private String experience;
    @NotBlank(message = "job type not provided")
    private String jobType;
    @NotBlank(message = "job location not provided")
    private String location;
    private Long packageOffered;
    private LocalDateTime postTime;
    @NotBlank(message = "job description not provided")
    private String description;
    @NotBlank(message = "job required skills not provided")
    private List<String> skillsRequired;
    private JobStatus jobStatus;


    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Applicants> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Applicants> applicants) {
        this.applicants = applicants;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getPackageOffered() {
        return packageOffered;
    }

    public void setPackageOffered(Long packageOffered) {
        this.packageOffered = packageOffered;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(List<String> skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }
    public Job jobDTOsToJob(){
        Job job = new Job();
        job.setJobTitle(this.jobTitle);
        job.setCompany(this.company);
        job.setApplicants(this.applicants);
        job.setAbout(this.about);
        job.setExperience(this.experience);
        job.setJobType(this.jobType);
        job.setLocation(this.location);
        job.setPackageOffered(this.packageOffered);
        job.setPostTime(this.postTime);
        job.setDescription(this.description);
        job.setSkillsRequired(this.skillsRequired);
        job.setJobStatus(this.jobStatus);
        return job;
    }
}
