package org.example.jobseekingsystem_lab10.Service;

import lombok.RequiredArgsConstructor;
import org.example.jobseekingsystem_lab10.Api.ApiException;
import org.example.jobseekingsystem_lab10.Model.JobApplication;
import org.example.jobseekingsystem_lab10.Repository.JobApplicationRepository;
import org.example.jobseekingsystem_lab10.Repository.JobPostRepository;
import org.example.jobseekingsystem_lab10.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;

    public List<JobApplication> getAll() {
        return jobApplicationRepository.findAll();
    }

    //add
    public void applyForJob(JobApplication app) {
        if (userRepository.giveMeUserById(app.getUserId()) == null)
            throw new ApiException("User not found");

        if (jobPostRepository.giveMeJobPostById(app.getJobPostId()) == null)
            throw new ApiException("Job post not found");

        jobApplicationRepository.save(app);
    }

    //Delete
    public void withdrawJobApplication(Integer id) {
        JobApplication app = jobApplicationRepository.giveMeJobApplicationById(id);
        if (app == null)
            throw new ApiException("Job application not found");

        jobApplicationRepository.delete(app);
    }

    public void update(Integer id, JobApplication jobApplication) {
        JobApplication old = jobApplicationRepository.giveMeJobApplicationById(id);
        if (old == null) throw new ApiException("Application not found");

        if (userRepository.giveMeUserById(jobApplication.getUserId()) == null) throw new ApiException("User not found");
        if (jobPostRepository.giveMeJobPostById(jobApplication.getJobPostId()) == null) throw new ApiException("Job post not found");

        old.setJobPostId(jobApplication.getJobPostId());
        old.setUserId(jobApplication.getUserId());
        jobApplicationRepository.save(old);
    }
}

