package org.example.jobseekingsystem_lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Title cannot be null")
    @Size(min = 5, message = "The title must be more than 4 letters")
    @Column(columnDefinition = "varchar(50) not null")
    private String title;

    @NotEmpty(message = "Description cannot be null")
    @Column(columnDefinition = "text not null")
    private String description;

    @NotEmpty(message = "Location cannot be null")
    @Column(columnDefinition = "varchar(100) not null")
    private String location;

    @NotNull(message = "Salary cannot be null")
    @PositiveOrZero(message = "The salary must be a non-negative number")
    @Column(columnDefinition = "int not null")
    private Integer salary;

    @Column(columnDefinition = "date", updatable = false)
    private LocalDate postingDate = LocalDate.now();

}

