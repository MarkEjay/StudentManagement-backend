package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Modifying
    @Transactional
    @Query("delete from Student where id = ?1")
    @DeleteMapping("/student/{id}")
    int deleteOne(Long studentid);

    @Query("SELECT s from Student s WHERE s.email=?1")
    Optional<Student> findStudentByEmail(String email);
}
