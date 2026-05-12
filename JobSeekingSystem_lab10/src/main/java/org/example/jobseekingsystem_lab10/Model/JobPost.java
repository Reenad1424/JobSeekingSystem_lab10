package org.example.jobseekingsystem_lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
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

    @Size(min =5 ,message = "The title must be mor than 4 letters")
    @Column(columnDefinition = "varchar(15) not null")
    private String title;

    @Column(columnDefinition = "text not null")
    private String description;

    @Column(columnDefinition = "varchar(20) not null")
    private String location;

    @PositiveOrZero(message = "The salary must be positive number")
    @Column(columnDefinition = "int not null")
    private Integer salary;

    @Column(columnDefinition = "date", updatable = false)// updatable = false: Prevents the field from being modified after the initial insertion to preserve the original posting date.
    private LocalDate postingDate = LocalDate.now();

}
