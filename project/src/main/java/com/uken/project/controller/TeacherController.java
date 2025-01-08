package com.uken.project.controller;

import com.uken.project.model.SchoolClass;
import com.uken.project.model.SchoolUser;
import com.uken.project.model.Subject;
import com.uken.project.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final StudentService studentService;


    public TeacherController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<SchoolUser> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/add/student")
    public SchoolClass addStudentToClass(@RequestParam Long studentId, @RequestParam String className){
        return studentService.addStudentToClass(studentId, className);
    }

    @PostMapping("/add/class")
    public SchoolClass createClass(@RequestBody SchoolClass schoolClass){
        return studentService.createClass(schoolClass);
    }

    @PostMapping("/add/subject")
    public Subject createSubject(@RequestBody Subject subject, @RequestParam Long classId){
        return studentService.createSubject(subject, classId);
    }

    @PostMapping("/add/lesson")
    public Subject createLesson(@RequestParam String topic, @RequestParam Long subjectId){
        return studentService.addLesson(topic, subjectId);
    }

    @PostMapping("/assignTeacherToClass")
    public SchoolClass assignTeacherToClass(@RequestParam Long teacherId, @RequestParam Long classId){
        return studentService.asignTeacherToClass(teacherId, classId);
    }




}
