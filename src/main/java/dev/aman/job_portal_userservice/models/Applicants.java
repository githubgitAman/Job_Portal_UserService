package dev.aman.job_portal_userservice.models;

import dev.aman.job_portal_userservice.dtos.ApplicantStatusDTOs;
import dev.aman.job_portal_userservice.dtos.ApplicantsDTOs;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Applicants extends BaseModel {
    @ManyToOne
    private Job job;
    private String name;
    private String email;
    private Long phone;
    private String website;
    private String resume;
    private String coverLetter;
    private LocalDateTime timeStamp;
    private ApplicantStatusDTOs applicantStatus;
    private LocalDateTime interviewTime;

    public LocalDateTime getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(LocalDateTime interviewTime) {
        this.interviewTime = interviewTime;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
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

    public ApplicantsDTOs applicantsDTOsToApplicants(){
        ApplicantsDTOs applicantsDTOs = new ApplicantsDTOs();
//        applicantsDTOs.setJob(this.job);
        applicantsDTOs.setName(this.name);
        applicantsDTOs.setTimeStamp(this.timeStamp);
        applicantsDTOs.setApplicantStatus(this.applicantStatus);
        applicantsDTOs.setEmail(this.email);
        applicantsDTOs.setPhone(this.phone);
        applicantsDTOs.setWebsite(this.website);
        applicantsDTOs.setResume(this.resume);
        applicantsDTOs.setCoverLetter(this.coverLetter);
        applicantsDTOs.setInterviewTime(this.interviewTime);
        applicantsDTOs.setInterviewTime(this.interviewTime);
        return applicantsDTOs;
    }
}
