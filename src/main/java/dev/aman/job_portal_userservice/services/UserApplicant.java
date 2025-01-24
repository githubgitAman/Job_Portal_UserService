package dev.aman.job_portal_userservice.services;

import dev.aman.job_portal_userservice.dtos.UserDTOs;
import dev.aman.job_portal_userservice.models.User;
import dev.aman.job_portal_userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service("Applicants")
public class UserApplicant implements UserService {
    private UserRepository userRepository;
    public UserApplicant(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDTOs registerUser(UserDTOs userDTO) {
        User user = userDTO.convertToUser();
        user = userRepository.save(user);
        UserDTOs userDTOs = user.convertToUserDTOs();
        return userDTOs;

    }
}
