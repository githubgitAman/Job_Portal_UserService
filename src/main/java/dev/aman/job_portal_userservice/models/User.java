package dev.aman.job_portal_userservice.models;

import dev.aman.job_portal_userservice.dtos.UserDTOs;
import dev.aman.job_portal_userservice.dtos.UserTypeDTOs;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
//Entity maps to a database table for persistence.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
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

    public UserDTOs convertToUserDTOs() {
        UserDTOs userDTOs = new UserDTOs();
        userDTOs.setId(this.id);
        userDTOs.setName(this.name);
        userDTOs.setEmail(this.email);
        userDTOs.setPassword(this.password);
        userDTOs.setUserType(this.userType);
        return userDTOs;
    }
}
