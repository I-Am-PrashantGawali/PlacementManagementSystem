package com.example.demo.controller;
import com.example.demo.entity.User;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService ser;
    
    @GetMapping("/user")
    public List<User> getAllUser() {
		return ser.getUser();

	}
    
    @GetMapping("/user/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
		try {
			User b = ser.getUserId(id);
			return new ResponseEntity<User>(b, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
    
    @PostMapping("/user")
	public void add(@RequestBody User b) {
		ser.save(b);
	}
    
    @PutMapping("/user/{id}")
    public ResponseEntity<?> update(@RequestBody User user,@PathVariable Long id) {
		try {
			User b = ser.getUserId(id);
			if(b!=null)
			ser.save(user);
			return new ResponseEntity<>(b, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
	}
    @DeleteMapping("/user/{id}")
	public void delete(@PathVariable Long id) {
		ser.delete(id);

	}
}
