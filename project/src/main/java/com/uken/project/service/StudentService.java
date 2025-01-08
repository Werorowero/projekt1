package com.uken.project.service;

import com.uken.project.model.Lesson;
import com.uken.project.model.SchoolClass;
import com.uken.project.model.SchoolUser;
import com.uken.project.model.Subject;

import java.util.List;

public interface StudentService {

    List<SchoolUser> getStudents();

    SchoolUser addStudent(SchoolUser schoolUser);

    SchoolClass addStudentToClass(Long studentId, String className);

    SchoolClass createClass(SchoolClass schoolClass);

    Subject createSubject(Subject subject, Long classId);

    Subject addLesson(String topic, Long subjectId);

    SchoolClass asignTeacherToClass(Long teacherId, Long classId);

    SchoolClass getClassInformation(Long studentId);
}
