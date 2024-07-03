package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.College;

public interface CollegeRepo extends JpaRepository <College,Long>{

}
