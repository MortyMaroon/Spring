package com.mortymaroon.spring.boot.repositorys;

import com.mortymaroon.spring.boot.models.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class StudentRepositoryInMemory {
    private List<Student> students;

    @PostConstruct
    public void init() {
        this.students = new ArrayList<>();
        students.add(new Student(1L,"Denis", 40));
        students.add(new Student(2L,"Mark", 44));
        students.add(new Student(3L,"Max", 12));
    }

    public Student saveOrUpdate(Student student) {
        if (student.getId() != null){
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId().equals(student.getId())) {
                    students.set(i,student);
                    return student;
                }
            }
        }
        Long newId = students.stream().mapToLong(Student::getId).max().orElseGet(() -> 0L) + 1L;
        student.setId(newId);
        students.add(student);
        return student;
    }

    public Optional<Student> findById(Long id) {
        return students.stream().
                filter(student -> student.getId().equals(id)).
                findFirst();
    }

    public List<Student> findAll() {
        return Collections.unmodifiableList(students);
    }

    public void removeById(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}
