package com.mortymaroon.springdata.controllers;

import com.mortymaroon.springdata.models.Student;
import com.mortymaroon.springdata.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).get();
    }

    @PostMapping
    public Student save(@RequestBody Student student){
        student.setId(null);
        return studentRepository.save(student);
    }

    @GetMapping("/search_by_name")
    public Student findStudents(@RequestParam String name) {
        return studentRepository.findByName(name).get();
    }

    @GetMapping("/search_by_min_score")
    public List<Student> searchByMinScore(@RequestParam(name = "min_score") int minScore) {
        return studentRepository.findAllByScoreIsGreaterThanEqual(minScore);
    }

    @GetMapping("/search_by_name_and_id")
    public Student getStudentByIdAndName() {
        return studentRepository.customFinderById(1L, "Bob").get();
    }
}
