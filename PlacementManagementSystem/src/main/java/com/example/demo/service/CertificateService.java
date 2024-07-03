package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Certificate;
import com.example.demo.repo.CertificateRepo;

@Service
public class CertificateService {
   @Autowired 
   private CertificateRepo repo;
    
   
   public List<Certificate> getCertificate(){
	   return repo.findAll();
			   }

public Certificate getCertificateId(long id){
	  return repo.findById(id).get() ;

			   }

public void save(Certificate ct) {
	repo.save(ct);
}

public void delete(Long id) {
	repo.deleteById(id);
}
}
