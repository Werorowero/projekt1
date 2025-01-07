package com.uken.project.controller;

import com.uken.project.model.Student;
import com.uken.project.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsController {
    private final StudentService studentService;


    public StudentsController(StudentService studentService) {
        this.studentService = studentService;

    }
    @GetMapping("/Student")
    public List<Student> getStudent(){
        return studentService.getStudents();
    }

    @PostMapping("/Student")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }


}
