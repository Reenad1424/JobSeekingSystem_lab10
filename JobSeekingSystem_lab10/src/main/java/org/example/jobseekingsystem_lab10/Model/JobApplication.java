package org.example.jobseekingsystem_lab10.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;  


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "User ID cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @NotNull(message = "Job Post ID cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer jobPostId;
}
