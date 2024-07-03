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

import com.example.demo.entity.Certificate;
import com.example.demo.service.CertificateService;

@RestController
public class CertificateController {

    @Autowired
    private CertificateService ser;
    
    @GetMapping("/certificate")
    public List<Certificate> getAllCertificate() {
		return ser.getCertificate();

	}
    
    @GetMapping("/certificate/{id}")
    public ResponseEntity<Certificate> get(@PathVariable Long id) {
		try {
			Certificate ct = ser.getCertificateId(id);
			return new ResponseEntity<Certificate>(ct, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Certificate>(HttpStatus.NOT_FOUND);
		}
	}
    
    @PostMapping("/certificate")
	public void add(@RequestBody Certificate ct) {
		ser.save(ct);
	}
    
    @PutMapping("/certificate/{id}")
    public ResponseEntity<?> update(@RequestBody Certificate certificate,@PathVariable Long id) {
		try {
			Certificate ct = ser.getCertificateId(id);
			if(ct!=null)
			ser.save(certificate);
			return new ResponseEntity<>(ct, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
    @DeleteMapping("/certificate/{id}")
	public void delete(@PathVariable Long id) {
		ser.delete(id);

	}
}
