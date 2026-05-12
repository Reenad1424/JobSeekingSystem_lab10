package org.example.jobseekingsystem_lab10.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.jobseekingsystem_lab10.Api.ApiResponse;
import org.example.jobseekingsystem_lab10.Model.JobApplication;
import org.example.jobseekingsystem_lab10.Service.JobApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jobApp")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity<?> get(){
        return ResponseEntity.status(200).body(jobApplicationService.getAll());
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Valid JobApplication jobApplication,Errors errors){
        if(errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        jobApplicationService.update(id,jobApplication);
        return ResponseEntity.status(200).body(new ApiResponse("Job updated successfully"));
    }
    //add
    @PostMapping("/apply")
    public ResponseEntity<?> apply(@RequestBody @Valid JobApplication jobApplication,Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        jobApplicationService.applyForJob(jobApplication);
        return ResponseEntity.status(200).body(new ApiResponse("Applied successfully"));
    }

    //delete
    @DeleteMapping("/deleteApp/{id}")
    public ResponseEntity<?> withdraw(@PathVariable Integer id){
        jobApplicationService.withdrawJobApplication(id);
        return ResponseEntity.status(200).body(new ApiResponse("Application withdrawn successfully"));
    }
}
