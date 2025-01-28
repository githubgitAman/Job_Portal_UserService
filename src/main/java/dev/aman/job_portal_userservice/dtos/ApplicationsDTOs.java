package dev.aman.job_portal_userservice.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplicationsDTOs {
    public String email;
    public LocalDateTime interviewTime;
    public ApplicantStatusDTOs applicantStatus;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(LocalDateTime interviewTime) {
        this.interviewTime = interviewTime;
    }

    public ApplicantStatusDTOs getApplicantStatus() {
        return applicantStatus;
    }

    public void setApplicantStatus(ApplicantStatusDTOs applicantStatus) {
        this.applicantStatus = applicantStatus;
    }
}
