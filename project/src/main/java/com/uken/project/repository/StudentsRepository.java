package com.uken.project.repository;

import com.uken.project.model.SchoolUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<SchoolUser, Long> {
    Optional<SchoolUser> findByEmail(String email);
}
