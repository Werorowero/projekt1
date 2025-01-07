package com.uken.project.service;

import com.uken.project.model.Student;
import com.uken.project.repository.StudentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImplementation implements StudentService {
private final StudentsRepository studentsRepository;

    public StudentServiceImplementation(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override

    public List<Student> getStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentsRepository.save(student);
    }
}
