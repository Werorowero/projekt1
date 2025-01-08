package com.uken.project.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String topic;

    private LocalDateTime date = LocalDateTime.now();


    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;
}
