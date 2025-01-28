package dev.aman.job_portal_userservice.services;

import dev.aman.job_portal_userservice.dtos.ProfileDTOs;
import dev.aman.job_portal_userservice.models.Profile;
import dev.aman.job_portal_userservice.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("ApplicantProfile")
public class ApplicantProfileService implements ProfileService{

    ProfileRepository profileRepository;
    public ApplicantProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    //We will not be creating this API i.e when user register then it will create
    public Long createProfile(String email) {
        Profile profile = new Profile();
        profile.setEmail(email);
        profile.setSkills(new ArrayList<>());
        profile.setExperiences(new ArrayList<>());
        profile.setCertificates(new ArrayList<>());
        profileRepository.save(profile);
        return profile.getId();
    }

    @Override
    public ProfileDTOs getProfile(String email) {
       Profile profile = profileRepository.findByEmail(email);
        if(profile == null) {
            throw new RuntimeException("Profile not found");
        }
        return profile.profileToProfileDTOs();
    }

    @Override
    public ProfileDTOs updateProfile(ProfileDTOs profileDTOs) {
        Profile profile = profileRepository.findByEmail(profileDTOs.getEmail());
        if(profile == null) {
            throw new RuntimeException("Profile not found");
        }
        Profile updatedProfile = profileDTOs.profileDTOsToProfile();
        //Saving previous ID
        updatedProfile.setId(profile.getId());
        profileRepository.save(updatedProfile);
        return updatedProfile.profileToProfileDTOs();
    }
}
