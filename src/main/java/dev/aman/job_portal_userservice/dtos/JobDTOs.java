package dev.aman.job_portal_userservice.dtos;

import dev.aman.job_portal_userservice.models.Applicants;
import dev.aman.job_portal_userservice.models.Job;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class JobDTOs {
    @NotBlank(message = "job title not provided")
    private String jobTitle;
    @NotBlank(message = "company name not provided")
    private String company;
    private List<ApplicantsDTOs> applicantsDTOs;
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
    private Long postedBy;

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
    public List<ApplicantsDTOs> getApplicantsDTOs() {
        return applicantsDTOs;
    }
    public void setApplicantsDTOs(List<ApplicantsDTOs> applicantsDTOs) {
        this.applicantsDTOs = applicantsDTOs;
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
        job.setAbout(this.about);
        job.setExperience(this.experience);
        job.setJobType(this.jobType);
        job.setLocation(this.location);
        job.setPackageOffered(this.packageOffered);
        job.setPostTime(this.postTime);
        job.setJobStatus(this.jobStatus);
        job.setDescription(this.description);
        job.setSkillsRequired(this.skillsRequired);
        job.setDescription(this.description);
        job.setPostedBy(this.postedBy);
        // Map List<ApplicantsDTOs> to List<Applicants>
        if (this.applicantsDTOs != null) {
            List<Applicants> applicants = this.applicantsDTOs.stream()
                    .map(applicantDTO -> {
                        Applicants applicant = new Applicants();
                        applicant.setJob(job); // Associate the job being created
                        applicant.setName(applicantDTO.getName());
                        applicant.setEmail(applicantDTO.getEmail());
                        applicant.setPhone(applicantDTO.getPhone());
                        applicant.setWebsite(applicantDTO.getWebsite());
                        applicant.setResume(applicantDTO.getResume());
                        applicant.setCoverLetter(applicantDTO.getCoverLetter());
                        applicant.setTimeStamp(applicantDTO.getTimeStamp());
                        applicant.setApplicantStatus(applicantDTO.getApplicantStatus());
                        return applicant;
                    })
                    .collect(Collectors.toList());
            job.setApplicants(applicants);
        }
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
