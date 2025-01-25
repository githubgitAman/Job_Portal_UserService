package dev.aman.job_portal_userservice.dtos;

import lombok.Data;

@Data
public class OTPDTOs {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
