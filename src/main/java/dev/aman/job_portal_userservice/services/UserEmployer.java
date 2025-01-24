package dev.aman.job_portal_userservice.services;

import dev.aman.job_portal_userservice.dtos.UserDTOs;
import dev.aman.job_portal_userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service(value = "Employers")
public class UserEmployer implements UserService{



    @Override
    public UserDTOs registerUser(UserDTOs userDTO) {
        return null;
    }
}
