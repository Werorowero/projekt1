package com.uken.project.repository;

import com.uken.project.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

//połączenie z repozytorium przedmiotów szkolnych
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
