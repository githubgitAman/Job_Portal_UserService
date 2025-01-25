package dev.aman.job_portal_userservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Data
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}
