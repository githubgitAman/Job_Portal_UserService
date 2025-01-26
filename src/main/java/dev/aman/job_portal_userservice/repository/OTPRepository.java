package dev.aman.job_portal_userservice.repository;

import dev.aman.job_portal_userservice.models.OTPs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OTPRepository extends JpaRepository<OTPs, String> {
    OTPs save(OTPs otps);
    Optional<OTPs> findById(String userId);
}
