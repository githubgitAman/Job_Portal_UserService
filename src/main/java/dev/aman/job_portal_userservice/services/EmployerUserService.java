package dev.aman.job_portal_userservice.services;

import dev.aman.job_portal_userservice.dtos.LoginDTOs;
import dev.aman.job_portal_userservice.dtos.OTPDTOs;
import dev.aman.job_portal_userservice.dtos.UserDTOs;
import org.springframework.stereotype.Service;

@Service(value = "Employers")
public class EmployerUserService implements UserService{

    @Override
    public UserDTOs registerUser(UserDTOs userDTO) {
        return null;
    }

    @Override
    public void loginUser(LoginDTOs loginDTO) {
    }

    @Override
    public Boolean generateOTP(String email) {
        return null;
    }

    @Override
    public Boolean verifyOTP(String email, String otp) throws Exception {
        return null;
    }
}
