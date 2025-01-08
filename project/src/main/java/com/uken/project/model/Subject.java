package com.uken.project.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "school_class_id", nullable = false, unique = false)
    private SchoolClass schoolClass;

    @JsonIgnore
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("date DESC")
    private List<Lesson> lessons;
}
