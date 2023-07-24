package com.project.students.controller;

import com.project.students.exception.StudentNotFoundException;
import com.project.students.model.Student;
import com.project.students.repository.StudentRepository;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentsController {

    @Resource
    private StudentRepository studentRepository;
/*    @Resource
    private StudentMongoRepository studentMongoRepository;*/



    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
        //return studentMongoRepository.findAll();
    }

    @GetMapping("/all/{id}")
    public Optional<Student> getStudent(@PathVariable Long id) throws StudentNotFoundException {
        return Optional.of(studentRepository.findById(id)).orElseThrow(() -> new StudentNotFoundException("student with id " + id + " not found"));
        //return Optional.of(studentMongoRepository.findById(id)).orElseThrow(() -> new StudentNotFoundException("student with id " + id + " not found"));
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        //studentMongoRepository.save(student);
        return "Student with id : " + student.getId() + " added successfully";
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student) {
        studentRepository.save(student);
        //studentMongoRepository.save(student);
        return "Student with id : " + student.getId() + " updated successfully";
    }

    @DeleteMapping("/remove/{id}")
    public String removeStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        //studentMongoRepository.deleteById(id);
        return "Strudent with id : " + id + " removed successfully";
    }
}
