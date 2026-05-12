package org.example.jobseekingsystem_lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 5, message = "Name length must be more than 4 characters")
    @Column(length = 20, nullable = false)
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Must be a valid email format")
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Column(length = 20, nullable = false)
    private String password;

    @NotNull(message = "Age cannot be null")
    @Min(value = 22, message = "Age must be more than 21")
    @Column(nullable = false)
    private Integer age;

    @NotEmpty(message = "Role cannot be empty")
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$", message = "Role must be either 'JOB_SEEKER' or 'EMPLOYER' only")
    @Column(length = 15, nullable = false)
    private String role;}

