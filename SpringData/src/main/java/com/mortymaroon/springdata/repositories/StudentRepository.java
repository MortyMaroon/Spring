package com.mortymaroon.springdata.repositories;

import com.mortymaroon.springdata.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByName(String name);
    List<Student> findAllByScoreIsGreaterThanEqual(int score);
    @Query("select s from Student s where s.id = ?1 and s.name = ?2")
    Optional<Student> customFinderById(Long id, String name);
}
