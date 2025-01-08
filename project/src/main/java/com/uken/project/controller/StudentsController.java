package com.uken.project.controller;

import com.uken.project.model.SchoolClass;
import com.uken.project.model.dto.ClassInformation;
import com.uken.project.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentsController {
    private final StudentService studentService;


    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/class")
    public SchoolClass GetClassInformation(@RequestParam Long studentId){
        return studentService.getClassInformation(studentId);
    }


}
