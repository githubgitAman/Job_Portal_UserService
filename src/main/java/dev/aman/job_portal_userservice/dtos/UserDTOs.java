package dev.aman.job_portal_userservice.dtos;

import dev.aman.job_portal_userservice.models.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
//DTOs transfers data between layers or over the network.
public class UserDTOs {
    @NotBlank(message = "name not provided")
    private String name;
    @NotBlank(message = "email not provided")
    private String email;
    @NotBlank(message = "password not provided")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "please enter correct password")
    private String password;
    private UserTypeDTOs userType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserTypeDTOs getUserType() {
        return userType;
    }

    public void setUserType(UserTypeDTOs userType) {
        this.userType = userType;
    }

    public User convertToUser() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setUserType(this.userType);
        return user;
    }
}
