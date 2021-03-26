package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    @PersistenceContext
    private EntityManager entityManager;

    private StudentRepository studentRepository;


    public Student findOne(Long id){
        Student stu = entityManager.find(Student.class, id);
        return stu;
    }

    @Transactional
    public Student updateStudent(Long id,String name, String email){
        Student stu = entityManager.find(Student.class, id);
        if(name != null &&  name.length()> 0 && !Objects.equals(stu.getName(), name)) {
            stu.setName(name);
        }
        if(email != null && email.length()> 0 && !Objects.equals(stu.getEmail(), email)) {
            stu.setEmail(email);
        }
        return stu;
    }
}
