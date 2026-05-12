package org.example.jobseekingsystem_lab10.Repository;

import org.example.jobseekingsystem_lab10.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost,Integer> {

    JobPost findJobPostById(Integer id);
}
