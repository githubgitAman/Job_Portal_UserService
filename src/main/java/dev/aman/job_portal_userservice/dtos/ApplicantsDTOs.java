package dev.aman.job_portal_userservice.dtos;

import dev.aman.job_portal_userservice.models.Applicants;
import dev.aman.job_portal_userservice.models.BaseModel;
import dev.aman.job_portal_userservice.models.Job;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplicantsDTOs  {
//    private Job job;
    @NotBlank(message = "name cannot be empty")
    private String name;
    @NotBlank(message = "email cannot be empty")
    private String email;
    @NotBlank(message = "phone number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number, it must be exactly 10 digits")
    private Long phone;
    private String website;
    private String resume;
    private String coverLetter;
    private LocalDateTime timeStamp;
    private ApplicantStatusDTOs applicantStatus;
    private LocalDateTime interviewTime;

//    public Job getJob() {
//        return job;
//    }
//
//    public void setJob(Job job) {
//        this.job = job;
//    }

    public LocalDateTime getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(LocalDateTime interviewTime) {
        this.interviewTime = interviewTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public ApplicantStatusDTOs getApplicantStatus() {
        return applicantStatus;
    }

    public void setApplicantStatus(ApplicantStatusDTOs applicantStatus) {
        this.applicantStatus = applicantStatus;
    }

    public Applicants applicantsToApplicantsDTOs() {
        Applicants applicants = new Applicants();
//        applicants.setJob(this.job);
        applicants.setName(this.name);
        applicants.setEmail(this.email);
        applicants.setPhone(this.phone);
        applicants.setWebsite(this.website);
        applicants.setResume(this.resume);
        applicants.setCoverLetter(this.coverLetter);
        applicants.setTimeStamp(this.timeStamp);
        applicants.setApplicantStatus(this.applicantStatus);
        return applicants;
    }
}
