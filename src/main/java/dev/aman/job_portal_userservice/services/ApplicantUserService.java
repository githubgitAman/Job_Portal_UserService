package dev.aman.job_portal_userservice.services;

import dev.aman.job_portal_userservice.Utilities.GeneratingOTPs;
import dev.aman.job_portal_userservice.Utilities.OTPData;
import dev.aman.job_portal_userservice.dtos.LoginDTOs;
import dev.aman.job_portal_userservice.dtos.OTPDTOs;
import dev.aman.job_portal_userservice.dtos.UserDTOs;
import dev.aman.job_portal_userservice.models.OTPs;
import dev.aman.job_portal_userservice.models.User;
import dev.aman.job_portal_userservice.repository.OTPRepository;
import dev.aman.job_portal_userservice.repository.UserRepository;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.Utilities;
import java.time.LocalDateTime;
import java.util.Optional;


@Service("ApplicantsUser")
public class ApplicantUserService implements UserService {
    private final JavaMailSenderImpl mailSender;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private OTPRepository otpRepository;
    private ProfileService profileService;

    public ApplicantUserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JavaMailSenderImpl mailSender,
                                OTPRepository otpRepository, ProfileService profileService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailSender = mailSender;
        this.otpRepository = otpRepository;
        this.profileService = profileService;
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
        profileService.createProfile(user.getEmail());
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
    @Override
    public Boolean generateOTP(String email) throws Exception {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Your OTP Is");
        String generatedOTP = GeneratingOTPs.generateOTP();
        OTPs otp = new OTPs();
        otp.setOtp(generatedOTP);
        otp.setEmail(email);
        otp.setLocalDateTime(LocalDateTime.now());
        otpRepository.save(otp);
        //Sending normal OTP
//        mimeMessage.setText("Your OTP is: " + generatedOTP);
        //Sending in HTML format
        mimeMessageHelper.setText(OTPData.getMessageBody(generatedOTP, user.get().getName()), true);
        mailSender.send(mimeMessage);
        return true;
    }
    @Override
    public Boolean verifyOTP(String email, String otp) throws Exception {
        Optional<OTPs> otps = otpRepository.findById(email);
        if(otps.isEmpty() || !otps.get().getOtp().equals(otp))
            throw new RuntimeException("OTP do not match");
        return true;
    }
}
