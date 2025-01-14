package com.uken.project.controller;

import com.uken.project.model.SchoolClass;
import com.uken.project.model.SchoolUser;
import com.uken.project.model.Subject;
import com.uken.project.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//controller dla Nauczycieli
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final StudentService studentService;


    public TeacherController(StudentService studentService) {
        this.studentService = studentService;
    }

    //dodaje studenta do klasy szkolnej
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @PostMapping("/add/student")
    public SchoolClass addStudentToClass(@RequestParam Long studentId, @RequestParam String className){
        return studentService.addStudentToClass(studentId, className);
    }
    //tworzy klase szkolną
    @PostMapping("/add/class")
    public SchoolClass createClass(@RequestParam String name){
        System.out.println("TEST");
        return studentService.createClass(name);
    }
    //dodaje przedmiot do klasy szkolnej
    @PostMapping("/add/subject")
    public Subject createSubject(@RequestBody Subject subject, @RequestParam Long classId){
        return studentService.createSubject(subject, classId);
    }
    //dodaje lekcje do pprzedmiotu szkolengo
    @PostMapping("/add/lesson")
    public Subject createLesson(@RequestParam String topic, @RequestParam Long subjectId){
        return studentService.addLesson(topic, subjectId);
    }
    //przypisuje nauczyciela o podanym id jako opiekuna klasy tez o podnaym id
    @PostMapping("/assignTeacherToClass")
    public SchoolClass assignTeacherToClass(@RequestParam Long teacherId, @RequestParam Long classId){
        return studentService.asignTeacherToClass(teacherId, classId);
    }




}
