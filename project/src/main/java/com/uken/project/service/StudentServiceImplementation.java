package com.uken.project.service;

import com.uken.project.model.Lesson;
import com.uken.project.model.SchoolClass;
import com.uken.project.model.SchoolUser;
import com.uken.project.model.Subject;
import com.uken.project.repository.SchoolClassRepository;
import com.uken.project.repository.StudentsRepository;
import com.uken.project.repository.SubjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class StudentServiceImplementation implements StudentService {
    private final StudentsRepository studentsRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final SubjectRepository subjectRepository;
    public StudentServiceImplementation(StudentsRepository studentsRepository, SchoolClassRepository schoolClassRepository, SubjectRepository subjectRepository) {
        this.studentsRepository = studentsRepository;
        this.schoolClassRepository = schoolClassRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override

    public List<SchoolUser> getStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public SchoolUser addStudent(SchoolUser schoolUser) {
        return studentsRepository.save(schoolUser);
    }

    @Transactional
    @Override
    public SchoolClass addStudentToClass(Long studentId, String className) {
        SchoolClass schoolClass = schoolClassRepository.findByName(className).orElseThrow();
        SchoolUser schoolUser = studentsRepository.findById(studentId).orElseThrow();
        schoolUser.setSchoolClass(schoolClass);
        studentsRepository.save(schoolUser);
        schoolClass.getStudents().add(schoolUser);
        return schoolClassRepository.save(schoolClass);
    }

    @Override
    public SchoolClass createClass(SchoolClass schoolClass) {
        return schoolClassRepository.save(schoolClass);
    }

    @Override
    public SchoolClass asignTeacherToClass(Long teacherId, Long classId) {
        SchoolClass schoolClass = schoolClassRepository.findById(classId).orElseThrow();
        SchoolUser schoolUser = studentsRepository.findById(teacherId).orElseThrow();
        schoolClass.setTeacher(schoolUser);
        return schoolClassRepository.save(schoolClass);
    }

    @Override
    public SchoolClass getClassInformation(Long studentId) {
        SchoolUser schoolUser = studentsRepository.findById(studentId).orElseThrow();
        return schoolClassRepository.findById(schoolUser.getSchoolClass().getId()).orElseThrow();
    }

    @Override
    public Subject createSubject(Subject subject, Long classId) {
        SchoolClass schoolClass = schoolClassRepository.findById(classId).orElseThrow();
        subject.setSchoolClass(schoolClass);
        return subjectRepository.save(subject);
    }

    @Override
    public Subject addLesson(String topic, Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        Lesson lesson = Lesson.builder()
                .topic(topic)
                .subject(subject)
                .date(LocalDateTime.now())
                .build();
        subject.getLessons().add(lesson);
        return subjectRepository.save(subject);
    }




}
