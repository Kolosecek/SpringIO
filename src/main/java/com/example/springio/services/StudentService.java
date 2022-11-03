package com.example.springio.services;

import com.example.springio.classes.Student;
import com.example.springio.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

//FIXME: mongo funkcionalita nie je testovana kedze este nemame vytvorenu db
@Service
@EnableMongoRepositories
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        System.out.println("Data creation started...");
        studentRepository.save(new Student(1L, "Peter", "...", 21));
        studentRepository.save(new Student(2L, "Pavol", "...", 18));
        studentRepository.save(new Student(3L, "Michal", "...", 15));
        studentRepository.save(new Student(4L, "Katka", "...", 35));
        studentRepository.save(new Student(5L, "Lucia", "...", 19));
        System.out.println("Data creation complete...");
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student newStudent) {
        studentRepository.save(newStudent);
    }

    public Student findStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }

}
