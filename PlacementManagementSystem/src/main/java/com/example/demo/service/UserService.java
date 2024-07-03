package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.repo.UserRepo;

@Service
public class UserService {
   @Autowired 
   private UserRepo repo;
    
   
   public List<User> getUser(){
	   List<User> u;
	   u=repo.findAll() ;
	   return u;
			   }


public User getUserId(long id){
	   
	  return repo.findById(id).get() ;

			   }

public void save(User u) {
	repo.save(u);
}

public void delete(Long id) {
	repo.deleteById(id);
}
}
