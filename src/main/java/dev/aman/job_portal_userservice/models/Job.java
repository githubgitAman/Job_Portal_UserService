package dev.aman.job_portal_userservice.models;

import dev.aman.job_portal_userservice.dtos.ApplicantsDTOs;
import dev.aman.job_portal_userservice.dtos.JobDTOs;
import dev.aman.job_portal_userservice.dtos.JobStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
public class Job extends BaseModel{

    private String jobTitle;
    private String company;
    @OneToMany(mappedBy = "job")
    private List<Applicants> applicants;
    private String about;
    private String experience;
    private String jobType;
    private String location;
    private Long packageOffered;
    private LocalDateTime postTime;
    private String description;
    private Long postedBy;
    //we use this annotation when we want to create a separate table for simple collections type
    @ElementCollection
    @CollectionTable(name = "job_skills_needed", joinColumns = @JoinColumn(name = "job_skills_id"))
    @Column(name = "job_skill")
    private List<String> skillsRequired;
    private JobStatus jobStatus;

    public Long getPostedBy() {
        return postedBy;
    }
    public void setPostedBy(Long postedBy) {
        this.postedBy = postedBy;
    }
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

    public JobDTOs jobToJobDTOs() {
        JobDTOs jobDTOs = new JobDTOs();
        jobDTOs.setJobTitle(this.jobTitle);
        jobDTOs.setCompany(this.company);
        jobDTOs.setAbout(this.about);
        jobDTOs.setExperience(this.experience);
        jobDTOs.setJobType(this.jobType);
        jobDTOs.setLocation(this.location);
        jobDTOs.setPackageOffered(this.packageOffered);
        jobDTOs.setPostTime(this.postTime);
        jobDTOs.setJobStatus(this.jobStatus);
        jobDTOs.setSkillsRequired(this.skillsRequired);
        jobDTOs.setDescription(this.description);
        jobDTOs.setPostedBy(this.postedBy);
        // Map List<Applicants> to List<ApplicantsDTOs>
        if (this.applicants != null) {
            List<ApplicantsDTOs> applicantsDTOs = this.applicants.stream()
                    .map(applicant -> {
                        ApplicantsDTOs applicantDTO = new ApplicantsDTOs();
                        applicantDTO.setName(applicant.getName());
                        applicantDTO.setEmail(applicant.getEmail());
                        applicantDTO.setPhone(applicant.getPhone());
                        applicantDTO.setWebsite(applicant.getWebsite());
                        applicantDTO.setResume(applicant.getResume());
                        applicantDTO.setCoverLetter(applicant.getCoverLetter());
                        applicantDTO.setTimeStamp(applicant.getTimeStamp());
                        applicantDTO.setApplicantStatus(applicant.getApplicantStatus());
                        return applicantDTO;
                    })
                    .collect(Collectors.toList());
            jobDTOs.setApplicantsDTOs(applicantsDTOs);
        }
        jobDTOs.setAbout(this.about);
        jobDTOs.setExperience(this.experience);
        jobDTOs.setJobType(this.jobType);
        jobDTOs.setLocation(this.location);
        jobDTOs.setPackageOffered(this.packageOffered);
        jobDTOs.setPostTime(this.postTime);
        jobDTOs.setDescription(this.description);
        jobDTOs.setSkillsRequired(this.skillsRequired);
        jobDTOs.setJobStatus(this.jobStatus);
        return jobDTOs;
    }
}
