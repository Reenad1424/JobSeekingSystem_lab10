package org.example.jobseekingsystem_lab10.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.jobseekingsystem_lab10.Api.ApiResponse;
import org.example.jobseekingsystem_lab10.Model.JobPost;
import org.example.jobseekingsystem_lab10.Service.JobPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jobPost")
@RequiredArgsConstructor
public class JobPostController {
    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity<?> get(){
        return ResponseEntity.status(200).body(jobPostService.get());

    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid JobPost jobPost, Errors errors){
        if(errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        jobPostService.add(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("job added successfully"));

    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Valid JobPost jobPost, Errors errors){
        if(errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        jobPostService.update(id,jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("Job updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        jobPostService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("Job deleted successfully"));
    }
}
