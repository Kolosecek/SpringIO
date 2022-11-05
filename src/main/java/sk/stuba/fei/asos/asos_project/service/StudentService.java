package sk.stuba.fei.asos.asos_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.asos.asos_project.repositories.StudentRepository;
import sk.stuba.fei.asos.asos_project.student.Student;

import java.util.Optional;


@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void deleteAllStudents(){
        studentRepository.deleteAll();
    }

    public void deleteStudentById(String id){
        studentRepository.deleteById(id);
    }

    public Optional<Student> findStudentById(String id) {
        return studentRepository.findById(id);
    }

}
