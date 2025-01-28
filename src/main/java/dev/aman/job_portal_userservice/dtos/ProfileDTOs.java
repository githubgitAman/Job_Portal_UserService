package dev.aman.job_portal_userservice.dtos;

import dev.aman.job_portal_userservice.models.Certificate;
import dev.aman.job_portal_userservice.models.Experience;
import dev.aman.job_portal_userservice.models.Profile;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProfileDTOs {
    @NotBlank(message = "email not provided")
    private String email;
    private String jobTitle;
    private String company;
    private String location;
    private String about;
    private List<String> skills;
    private List<ExperienceDTOs> experiences;
    private List<CertificateDTOs> certificates;

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

    public List<ExperienceDTOs> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<ExperienceDTOs> experiences) {
        this.experiences = experiences;
    }

    public List<CertificateDTOs> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<CertificateDTOs> certificates) {
        this.certificates = certificates;
    }

    public Profile profileDTOsToProfile(){
        Profile profile = new Profile();
        profile.setEmail(this.email);
        profile.setJobTitle(this.jobTitle);
        profile.setAbout(this.about);
        profile.setCompany(this.company);
        profile.setLocation(this.location);
        profile.setSkills(this.skills);
        List<Experience> experiences = this.experiences.stream()
                .map(experienceDTO -> {
                    Experience experience = new Experience();
                    experience.setJobTitle(experienceDTO.getJobTitle());
                    experience.setCompany(experienceDTO.getCompany());
                    experience.setLocation(experienceDTO.getLocation());
                    experience.setStartDate(experienceDTO.getStartDate());
                    experience.setEndDate(experienceDTO.getEndDate());
                    experience.setWorking(experienceDTO.getWorking());
                    experience.setDescription(experienceDTO.getDescription());
                    return experience;
                })
                .collect(Collectors.toList());

        profile.setExperiences(experiences);

        List<Certificate> certificates = this.certificates.stream()
                .map(certificateDTO -> {
                    Certificate certificate = new Certificate();
                    certificate.setTitle(certificateDTO.getTitle());
                    certificate.setIssuer(certificateDTO.getIssuer());
                    certificate.setIssuedOn(certificateDTO.getIssuedOn());
                    certificate.setCertificateId(certificateDTO.getCertificateId());
                    return certificate;
                })
                .collect(Collectors.toList());

        profile.setCertificates(certificates);
        return profile;
    }
}
