package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Placement;
import com.example.demo.repo.PlacementRepo;

@Service
public class PlacementService {
	
	@Autowired
	private PlacementRepo repo;
	
	public List<Placement> getPlacement(){
		   return repo.findAll();
		   }
	
	public Placement getPlacementId(long id){  
		  return repo.findById(id).get() ;
				   }
	
	public void save(Placement p) {
		repo.save(p);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
	

}
