package org.example.jobseekingsystem_lab10.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.jobseekingsystem_lab10.Api.ApiResponse;
import org.example.jobseekingsystem_lab10.Model.User;
import org.example.jobseekingsystem_lab10.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity<?> get(){
        return ResponseEntity.status(200).body(userService.get());

    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        userService.add(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added successfully"));
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Valid User user , Errors errors){
        if(errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        userService.update(id,user);
        return ResponseEntity.status(200).body(new ApiResponse("User updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        userService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted successfully"));
    }
}
