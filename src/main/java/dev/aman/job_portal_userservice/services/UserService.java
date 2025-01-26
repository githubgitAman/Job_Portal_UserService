package dev.aman.job_portal_userservice.services;

import dev.aman.job_portal_userservice.dtos.LoginDTOs;
import dev.aman.job_portal_userservice.dtos.OTPDTOs;
import dev.aman.job_portal_userservice.dtos.UserDTOs;

public interface UserService {
    public UserDTOs registerUser(UserDTOs userDTO);
    public void loginUser(LoginDTOs loginDTO);
    public Boolean generateOTP(String email) throws Exception;
    public Boolean verifyOTP(String email, String otp) throws Exception;

}
