package com.mortymaroon.spring.boot.services;

import com.mortymaroon.spring.boot.models.Student;
import com.mortymaroon.spring.boot.repositorys.StudentRepositoryInMemory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepositoryInMemory studentRepositoryInMemory;

    public Optional<Student> findById(Long id) {
        return studentRepositoryInMemory.findById(id);
    }

    public List<Student> findAll() {
        return studentRepositoryInMemory.findAll();
    }

    public Student saveOrUpdate(Student student) {
        return studentRepositoryInMemory.saveOrUpdate(student);
    }

    public void removeById(Long id){
        studentRepositoryInMemory.removeById(id);
    }

    public List<Student> findAll(Integer minScore, Integer maxScore) {
        List<Student> out = findAll();
        if (minScore != null) {
            out = out.stream().filter(student -> student.getScore() >= minScore).collect(Collectors.toList());
        }
        if (maxScore != null) {
            out = out.stream().filter(student -> student.getScore() <= maxScore).collect(Collectors.toList());
        }
        return out;
    }
}
