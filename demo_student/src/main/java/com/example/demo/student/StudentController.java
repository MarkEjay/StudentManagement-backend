package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
//@RequestMapping(path = "api/v1/students")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    @Autowired
    private  StudentRepository studentRepository;


    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }


    @GetMapping("api/v1/students")
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    @GetMapping("api/v1/students/{id}")
    public ResponseEntity<Iterable<Student>> findOne(@PathVariable Long id){
        Iterable<Student> stu = studentService.findOne(id);
        return new ResponseEntity<Iterable<Student>>(stu, HttpStatus.OK);
    }
    @PostMapping("api/v1/students")
    public ResponseEntity<Student> registerNewStudent(@RequestBody Student stu){

       // if(stu.p)
        Optional<Student> stuEmail = studentRepository.findStudentByEmail(stu.getEmail());
        if(stuEmail.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
        Student newStu = studentRepository.save(stu);
        return new ResponseEntity<Student>(newStu, HttpStatus.OK);
    }

    @PutMapping("api/v1/students/{id}")
    public void updateOne(@PathVariable long id,
                                             @RequestParam(required = false) String name,
                                             @RequestParam(required = false) String email
                                             ){
        studentService.updateStudent(id,name,email);
    }

    @DeleteMapping("api/v1/students/{id}")
    public ResponseEntity<Integer> DeleteStudent(@PathVariable long id){
        return new ResponseEntity<Integer>(studentRepository.deleteOne(id), HttpStatus.OK);
    }
}
