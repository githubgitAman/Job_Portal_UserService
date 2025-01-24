package dev.aman.job_portal_userservice.dtos;

import dev.aman.job_portal_userservice.models.User;
import jakarta.persistence.Column;
import lombok.Data;

@Data
//DTOs transfers data between layers or over the network.
public class UserDTOs {
    private Long id;
    private String name;
    private String email;
    private String password;
    private UserTypeDTOs userType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        user.setId(this.id);
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setUserType(this.userType);
        return user;
    }
}
