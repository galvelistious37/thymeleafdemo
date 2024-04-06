package com.johnny.spring.thymeleafdemo.controller;

import com.johnny.spring.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}") // Read from properties file
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;
    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){
        // Create a new student object
        Student theStudent = new Student();

        // Add student object as a model attribute
        theModel.addAttribute("student", theStudent);
        // Add countries as a model attribute
        theModel.addAttribute("countries", countries);
        // Add languages as a model attribute
        theModel.addAttribute("languages", languages);
        // Add systems as a model attribute
        theModel.addAttribute("systems", systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        // Log the input data
        System.out.println("theStudent: " + theStudent.getFirstName() +
                " " + theStudent.getLastName());
        System.out.println("Country: " + theStudent.getCountry());

        return "student-confirmation";
    }
}
