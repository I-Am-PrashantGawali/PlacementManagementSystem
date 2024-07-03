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

import com.example.demo.entity.Placement;
import com.example.demo.service.PlacementService;

@RestController
public class PlacementController {

    @Autowired
    private PlacementService ser;
    
    @GetMapping("/placement")
    public List<Placement> getAllPlacement() {
		return ser.getPlacement();

	}
    
    @GetMapping("/placement/{id}")
    public ResponseEntity<Placement> get(@PathVariable Long id) {
		try {
			Placement pl = ser.getPlacementId(id);
			return new ResponseEntity<Placement>(pl, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
		}
	}
    
    @PostMapping("/placement")
	public void add(@RequestBody Placement pl) {
		ser.save(pl);
	}
    
    @PutMapping("/placement/{id}")
    public ResponseEntity<?> update(@RequestBody Placement placement,@PathVariable Long id) {
		try {
			Placement pl = ser.getPlacementId(id);
			if(pl!=null)
			ser.save(placement);
			return new ResponseEntity<>(pl, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
    @DeleteMapping("/placement/{id}")
	public void delete(@PathVariable Long id) {
		ser.delete(id);

	}
}
