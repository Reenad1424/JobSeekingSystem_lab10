package org.example.jobseekingsystem_lab10.Service;

import lombok.RequiredArgsConstructor;
import org.example.jobseekingsystem_lab10.Api.ApiException;
import org.example.jobseekingsystem_lab10.Model.JobPost;
import org.example.jobseekingsystem_lab10.Repository.JobPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JobPostRepository jobPostRepository;

    public List<JobPost> get() {
        return jobPostRepository.findAll();
    }

    public void add(JobPost jobPost) {
        jobPostRepository.save(jobPost);
    }

    public void update(Integer id, JobPost jobPost) {
        JobPost oldjobPost = jobPostRepository.giveMeJobPostById(id);

        if (oldjobPost == null)
            throw new ApiException("job not found");

        oldjobPost.setDescription(jobPost.getDescription());
        oldjobPost.setTitle(jobPost.getTitle());
        oldjobPost.setSalary(jobPost.getSalary());
        oldjobPost.setLocation(jobPost.getLocation());

        jobPostRepository.save(oldjobPost);
    }

    public void delete(Integer id) {
        JobPost deleteJob = jobPostRepository.giveMeJobPostById(id);
        if (deleteJob == null)
            throw new ApiException("job not found");

        jobPostRepository.delete(deleteJob);
    }


}
