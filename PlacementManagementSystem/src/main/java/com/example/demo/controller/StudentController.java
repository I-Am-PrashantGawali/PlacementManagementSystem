package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService ser;
    
    @GetMapping("/student")
    public List<Student> getAllStudent() {
    	return ser.getStudent();
	}
    
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) {
		try {
			Student st = ser.getStudentId(id);
			return new ResponseEntity<Student>(st, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
    
    @PostMapping("/student")
	public void add(@RequestBody Student st) {
		ser.save(st);
	}
    
    @PutMapping("/student/{id}")
    public ResponseEntity<?> update(@RequestBody Student student,@PathVariable Long id) {
		try {
			Student st = ser.getStudentId(id);
			if(st!=null)
			ser.save(student);
			return new ResponseEntity<>(st, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
    @DeleteMapping("/student/{id}")
	public void delete(@PathVariable Long id) {
		ser.delete(id);

	}
}
