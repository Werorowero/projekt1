package com.uken.project.service;

import com.uken.project.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student addStudent(Student student);
}
