package dev.aman.job_portal_userservice.repository;

import dev.aman.job_portal_userservice.dtos.ProfileDTOs;
import dev.aman.job_portal_userservice.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile save(Profile profile);
    Profile findByEmail(String email);
}
