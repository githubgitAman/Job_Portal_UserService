package dev.aman.job_portal_userservice.models;

import dev.aman.job_portal_userservice.dtos.ApplicantStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Applicants extends BaseModel {
    @ManyToOne
    private Job job;
    private LocalDateTime timeStamp;
    private ApplicantStatus applicantStatus;
}
