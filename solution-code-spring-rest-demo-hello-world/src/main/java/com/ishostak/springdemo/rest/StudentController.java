package com.ishostak.springdemo.rest;

import com.ishostak.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Student("John", "Doe"));
        students.add(new Student("Mary", "Poe"));
        students.add(new Student("Susan", "Coe"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{Id}")
    public Student getStudent(@PathVariable int Id) {

        if (Id < 0 || Id >= students.size()) {
            throw new StudentNotFoundException("There is no such student with this id - " + Id);
        }

        return students.get(Id);
    }

/*
    //specific exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
        StudentErrorResponse response = new StudentErrorResponse();

        response.setMessage(ex.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        response.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //generic exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
        StudentErrorResponse response = new StudentErrorResponse();

        response.setMessage(ex.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        response.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }*/
}
