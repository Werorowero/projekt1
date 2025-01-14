package com.uken.project.controller;

import com.uken.project.model.SchoolClass;

import com.uken.project.service.StudentService;
import org.springframework.web.bind.annotation.*;

//controller dla Studentów
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/student")
public class StudentsController {
    private final StudentService studentService;


    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }
    //pboeira dane klasy
    @GetMapping("/class")
    public SchoolClass GetClassInformation(@RequestParam Long classId){
        return studentService.getClassInformation(classId);
    }


}
