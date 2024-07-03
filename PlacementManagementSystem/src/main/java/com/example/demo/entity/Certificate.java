package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Certificate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int year;
	
    @ManyToOne
    @JoinColumn(name = "college_id")
	private College college;
	
	@OneToMany(mappedBy = "certificate")
	private List<Student> students;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public Certificate(long id, int year, College college) {
		super();
		this.id = id;
		this.year = year;
		this.college = college;
	}
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
