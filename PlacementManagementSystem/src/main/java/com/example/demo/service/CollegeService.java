package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.College;
import com.example.demo.repo.CollegeRepo;

@Service
public class CollegeService {
   @Autowired 
   private CollegeRepo repo;
    
   
   public List<College> getCollege(){
	   return repo.findAll();
			   }

public College getCollegeId(long id){
	  return repo.findById(id).get() ;

			   }

public void save(College cl) {
	repo.save(cl);
}

public void delete(Long id) {
	repo.deleteById(id);
}
}
