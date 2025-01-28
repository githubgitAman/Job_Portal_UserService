package dev.aman.job_portal_userservice.models;


import dev.aman.job_portal_userservice.dtos.CertificateDTOs;
import dev.aman.job_portal_userservice.dtos.ExperienceDTOs;
import dev.aman.job_portal_userservice.dtos.ProfileDTOs;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
public class Profile extends BaseModel {
    private String email;
    private String jobTitle;
    private String company;
    private String location;
    private String about;
    //we use this annotation when we want to create a separate table for simple collections type
    @ElementCollection
    @CollectionTable(name = "profile_skills", joinColumns = @JoinColumn(name = "profile_id"))
    @Column(name = "skill")
    private List<String> skills;
    @OneToMany(mappedBy = "profile")
    private List<Experience> experiences;
    @OneToMany(mappedBy = "profile")
    private List<Certificate> certificates;
    //we use this annotation when we want to create a separate table for simple collections type
    //It tells JPA that the savedJobs list is not an entity itself,
    //but rather a collection of simple values that should be stored in a separate table.
    @ElementCollection
    //The name = "profile_job" specifies that the collection should be stored in a table named profile_job.
    //The joinColumns = @JoinColumn(name = "job_id") specifies that this collection table will have a foreign key column (job_id)
    //that refers to the primary key of the entity that owns the collection
    @CollectionTable(name = "profile_job", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "savedJobs")
    private List<Long> savedJobs;

    public List<Long> getSavedJobs() {
        return savedJobs;
    }

    public void setSavedJobs(List<Long> savedJobs) {
        this.savedJobs = savedJobs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
    public ProfileDTOs profileToProfileDTOs(){
        ProfileDTOs profileDTOs = new ProfileDTOs();
        profileDTOs.setEmail(this.email);
        profileDTOs.setJobTitle(this.jobTitle);
        profileDTOs.setAbout(this.about);
        profileDTOs.setCompany(this.company);
        profileDTOs.setLocation(this.location);
        profileDTOs.setAbout(this.about);
        profileDTOs.setSkills(this.skills);
        profileDTOs.setSavedJobs(this.savedJobs);
        // Convert List<Experience> to List<ExperienceDTOs>
        List<ExperienceDTOs> experienceDTOs = this.experiences.stream()
                .map(experience -> {
                    ExperienceDTOs experienceDTO = new ExperienceDTOs();
                    experienceDTO.setJobTitle(experience.getJobTitle());
                    experienceDTO.setCompany(experience.getCompany());
                    experienceDTO.setLocation(experience.getLocation());
                    experienceDTO.setStartDate(experience.getStartDate());
                    experienceDTO.setEndDate(experience.getEndDate());
                    experienceDTO.setWorking(experience.getWorking());
                    experienceDTO.setDescription(experience.getDescription());
                    return experienceDTO;
                })
                .collect(Collectors.toList());

        profileDTOs.setExperiences(experienceDTOs);

        // Convert List<Certificate> to List<CertificateDTOs>
        List<CertificateDTOs> certificateDTOs = this.certificates.stream()
                .map(certificate -> {
                    CertificateDTOs certificateDTO = new CertificateDTOs();
                    certificateDTO.setTitle(certificate.getTitle());
                    certificateDTO.setIssuer(certificate.getIssuer());
                    certificateDTO.setIssuedOn(certificate.getIssuedOn());
                    certificateDTO.setCertificateId(certificate.getCertificateId());
                    return certificateDTO;
                })
                .collect(Collectors.toList());

        profileDTOs.setCertificates(certificateDTOs);


        return profileDTOs;
    }
}
