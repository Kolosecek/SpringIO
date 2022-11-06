package sk.stuba.fei.asos.asos_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.asos.asos_project.service.StudentService;
import sk.stuba.fei.asos.asos_project.student.Student;

import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentThymeleafController {

    private final StudentService studentService;

    @Autowired
    public StudentThymeleafController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student/all";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("student", new Student());
        return "/student/add";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/student/all";
    }

    @GetMapping("/")
    public String student() {
        return "student/index";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") Optional<String> id, Model model) {
        Student student = id.map(s -> studentService.findStudentById(s).get()).orElseGet(Student::new);
        model.addAttribute("student", student);
        return "student/edit";
    }

    @GetMapping("/delete/{id}")
    public String removeStudent(@PathVariable("id") String id, Model model) {
        studentService.deleteStudentById(id);
        model.addAttribute("students", studentService.getAllStudents());
        return "student/all";
    }

    @GetMapping("/delete")
    public String removeAllStudents() {
        studentService.deleteAllStudents();
        return "redirect:/student/all";
    }
}
