package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Certificate;
public interface CertificateRepo extends JpaRepository <Certificate,Long>{

}
