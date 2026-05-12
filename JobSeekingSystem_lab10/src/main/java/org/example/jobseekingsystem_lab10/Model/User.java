package org.example.jobseekingsystem_lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @Size(min = 5, message = "Name length must be more than 4 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only characters (no numbers)")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @Email(message = "Must be a valid email format")
    @Column(columnDefinition = "varchar(50) not null unique")
    private String email;

    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @Min(value = 22, message = "Age must be more than 21")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @Column(columnDefinition = "varchar(15) not null check(role='JOB_SEEKER' or role='EMPLOYER')")
    private String role;
}
