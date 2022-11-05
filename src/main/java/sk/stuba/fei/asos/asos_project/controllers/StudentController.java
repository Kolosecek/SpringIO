package sk.stuba.fei.asos.asos_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.stuba.fei.asos.asos_project.service.StudentService;
import sk.stuba.fei.asos.asos_project.student.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String options(){return "student/options";}

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


}
