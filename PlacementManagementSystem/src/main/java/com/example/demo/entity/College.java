package com.example.demo.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class College {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String collegeName;
	private String location;
	
	@OneToOne
	@JoinColumn(name = "college_admin_id")
    private User collegeAdmin;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public User getCollegeAdmin() {
		return collegeAdmin;
	}

	public void setCollegeAdmin(User collegeAdmin) {
		this.collegeAdmin = collegeAdmin;
	}

	public College(long id, String collegeName, String location, User collegeAdmin) {
		super();
		this.id = id;
		this.collegeName = collegeName;
		this.location = location;
		this.collegeAdmin = collegeAdmin;
	}

	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
	
	

}
