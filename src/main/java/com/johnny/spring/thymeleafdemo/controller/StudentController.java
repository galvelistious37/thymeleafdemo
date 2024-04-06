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

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){
        // Create a new student object
        Student theStudent = new Student();

        // Add student object as a model attribute
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countries", countries);

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
