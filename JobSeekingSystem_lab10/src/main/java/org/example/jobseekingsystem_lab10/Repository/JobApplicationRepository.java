package org.example.jobseekingsystem_lab10.Repository;

import org.example.jobseekingsystem_lab10.Model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication,Integer> {

    JobApplication findJobApplicationById(Integer id);
}
