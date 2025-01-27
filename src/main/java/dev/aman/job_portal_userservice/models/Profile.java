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
