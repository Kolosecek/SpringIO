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

    private StudentService studentService;

    @Autowired
    public StudentThymeleafController(StudentService studentService) {
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

    @GetMapping("/delete/{id}")
    public String removeStudent(@PathVariable("id") String id, Model model) {
        studentService.deleteStudentById(id);
        model.addAttribute("students", studentService.getAllStudents());
        return "student/all";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") Optional<String> id, Model model) {
        Student student = id.isPresent() ?
                studentService.findStudentById(id.get()).get() : new Student();
        model.addAttribute("student", student);
        return "student/edit";
    }

    @GetMapping("/delete")
    public String removeAllStudents() {
        studentService.deleteAllStudents();
        return "redirect:/student/all";
    }

    /////////////////////////////////////////////////////////////////////////
    //TODO: Ak chcete dorobte toto find alebo spravte ine funkcie lebo find je zbytocny ked mame show all

    @GetMapping("/find")
    public String find() {
        return "student/find";
    }

    @GetMapping("/find/{name}")
    public String findStudent(@PathVariable("name") String name, Model model) {
        model.addAttribute("student_info", studentService.findStudentByName(name));
        return "student/details";
    }

    @GetMapping("/details")
    public String studentDetails(){
        return "student/details";
    }

}
