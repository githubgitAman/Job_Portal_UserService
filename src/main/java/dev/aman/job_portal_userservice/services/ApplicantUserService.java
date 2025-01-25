package dev.aman.job_portal_userservice.services;

import dev.aman.job_portal_userservice.dtos.LoginDTOs;
import dev.aman.job_portal_userservice.dtos.UserDTOs;
import dev.aman.job_portal_userservice.models.User;
import dev.aman.job_portal_userservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("Applicants")
public class ApplicantUserService implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public ApplicantUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserDTOs registerUser(UserDTOs userDTO) {
        Optional<User> userOptional = userRepository.findByEmail(userDTO.getEmail());
        if (userOptional.isPresent()) {
            throw  new RuntimeException("User already exists");
        }
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = userDTO.convertToUser();
        user = userRepository.save(user);
        UserDTOs userDTOs = user.convertToUserDTOs();
        return userDTOs;
    }

    @Override
    public void loginUser(LoginDTOs loginDTO) {
        //calling findByEmail query in userRepository with that particular username
        Optional<User> user = userRepository.findByEmail(loginDTO.getEmail());
        if(user.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        //matching password using matches method of passwordEncoder
        //we are using .get.getPassword because user is an optional not just object
        //using .get() we are getting object from optional user and then checking mail
        if(!passwordEncoder.matches(loginDTO.getPassword(), user.get().getPassword())) {
            throw new RuntimeException("Wrong password");
        }

    }
}
