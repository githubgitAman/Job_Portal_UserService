package dev.aman.job_portal_userservice.repository;

import dev.aman.job_portal_userservice.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {
    Job save(Job job);
    List<Job> findAll();
    Optional<Job> findById(long id);
}
