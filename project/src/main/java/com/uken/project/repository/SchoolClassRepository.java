package com.uken.project.repository;

import com.uken.project.model.SchoolClass;
import com.uken.project.model.SchoolUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
    Optional<SchoolClass> findByName(String email);
}
