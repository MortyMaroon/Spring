package com.mortymaroon.spring.boot.controllers;

import com.mortymaroon.spring.boot.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public String showAll(Model model,
                          @RequestParam(required = false, name = "min_score") Integer minScore,
                          @RequestParam(required = false, name = "max_score") Integer maxScore) {
        model.addAttribute("students",studentService.findAll(minScore, maxScore));
        return "students";
    }

    @GetMapping("/remove/{id}")
    public String removeById(@PathVariable Long id) {
        studentService.removeById(id);
        return "redirect:students";
    }
}
