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

import com.example.demo.entity.College;
import com.example.demo.service.CollegeService;

@RestController
public class CollegeController {

    @Autowired
    private CollegeService ser;
    
    @GetMapping("/college")
    public List<College> getAllCollege() {
		return ser.getCollege();

	}
    
    @GetMapping("/college/{id}")
    public ResponseEntity<College> get(@PathVariable Long id) {
		try {
			College cl = ser.getCollegeId(id);
			return new ResponseEntity<College>(cl, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
		}
	}
    
    @PostMapping("/college")
    public void add(@RequestBody College cl) {
    	ser.save(cl);
    }
    
	//public void add(@RequestBody College cl) {
	//	ser.save(cl);
	//}
    
    @PutMapping("/college/{id}")
    public ResponseEntity<?> update(@RequestBody College college,@PathVariable Long id) {
		try {
			College cl = ser.getCollegeId(id);
			if(cl!=null)
			ser.save(college);
			return new ResponseEntity<>(cl, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
    @DeleteMapping("/college/{id}")
	public void delete(@PathVariable Long id) {
		ser.delete(id);

	}
}
