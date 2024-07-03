package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentService {
   @Autowired 
   private StudentRepo repo;
    
   
   public List<Student> getStudent(){
	   List<Student> st;
	   st=repo.findAll() ;
	   return st;
			   }

public Student getStudentId(long id){
	  return repo.findById(id).get() ;

			   }

public void save(Student st) {
	repo.save(st);
}

public void delete(Long id) {
	repo.deleteById(id);
}
}
