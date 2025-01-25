package dev.aman.job_portal_userservice.repository;

import dev.aman.job_portal_userservice.models.OTPs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OTPRepository extends JpaRepository<OTPs, String> {
    OTPs save(OTPs otps);
}
