package com.raiayush.Medicare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.raiayush.Medicare.model.Patients;

@Repository
public interface PatientDao  extends JpaRepository<Patients, Integer>{

	ResponseEntity<String> findBypatientEmail(String email);

}
