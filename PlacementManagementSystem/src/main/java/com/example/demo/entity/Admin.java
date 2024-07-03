package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
	
	@Id
	private long id;
	private String password;
	private String name;
    
    
	public long getId() {
		
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Admin(long id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}
	public Admin() {
		super();
		
	}
	
	

}
