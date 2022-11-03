package com.example.springio;

import com.example.springio.classes.Student;
import com.example.springio.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: ak sa budete nudit mozete pridat viacej funkcii
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //FIXME: mozno sa bude dat prerobit tak ze to nebude vracat String ale rovno celu HTML page, malo by to nejako ist cez @Controller
    @GetMapping("/")
    public String home() {
        return "<h1>Add new student to database</h1>\n" +
                "<form action=\"add\" method=\"post\">\n" +
                "  <label for=\"id\">ID:</label><br>\n" +
                "  <input type=\"number\" id=\"id\" name=\"id\"><br>\n" +
                "  <label for=\"name\">Name:</label><br>\n" +
                "  <input type=\"text\" id=\"name\" name=\"name\"><br>\n" +
                "  <label for=\"surname\">Surname:</label><br>\n" +
                "  <input type=\"text\" id=\"surname\" name=\"surname\"><br>\n" +
                "  <label for=\"age\">Age:</label><br>\n" +
                "  <input type=\"number\" id=\"age\" name=\"age\"><br>\n" +
                "  <br>\n" +
                "  <input type=\"submit\" value=\"Add new Student\">\n" +
                "</form>\n" +
                "<br>\n" +
                "<h1>Find student by name</h1>\n" +
                "<form action=\"findStrudentByName\" method=\"get\">\n" +
                "  <label for=\"nameSearch\">Name:</label><br>\n" +
                "  <input type=\"text\" id=\"nameSearch\" name=\"nameSearch\"><br><br>\n" +
                "  <input type=\"submit\" value=\"Find student\">\n" +
                "</form>\n";
    }

    @GetMapping("/all")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    //TODO: mozno nebude zle pridat do returnu "back button" na formular
    @PostMapping("/add")
    public String addStudent(Student student) {
        studentService.addStudent(student);
        return "Student was added";
    }

    //TODO: mozno nebude zle pridat do returnu "back button" na formular
    @GetMapping("/findStrudentByName")
    public String findStudentByName(String nameSearch) {
        Student S = studentService.findStudentByName(nameSearch);
        return S.toString();
    }
}