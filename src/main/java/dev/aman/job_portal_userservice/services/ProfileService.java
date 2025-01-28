package dev.aman.job_portal_userservice.services;

import dev.aman.job_portal_userservice.dtos.ProfileDTOs;

public interface ProfileService {
     public Long createProfile(String email);
     public ProfileDTOs getProfile(String email);
     public ProfileDTOs updateProfile(ProfileDTOs profileDTOs);
}
