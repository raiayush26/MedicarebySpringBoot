package com.raiayush.Medicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raiayush.Medicare.model.Patients;
import com.raiayush.Medicare.service.PatientService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Pat")
public class PatientControlller {
	
	@Autowired
	PatientService patService;
	
	@GetMapping("/Patients")
	public ResponseEntity<List<Patients>> getPatient(){
		return new ResponseEntity<>(patService.getPatients(),HttpStatus.OK);
	}
	@GetMapping("/Patients/{email}")
	public ResponseEntity<String> getPatientByEmail( @PathVariable String email) {
		return patService.getPatientbypatientEmail(email);
	}
	@DeleteMapping("/api/Patients/{id}")
	public ResponseEntity<String> deletPatientById( @PathVariable int id) {
		return patService.deletPatientById(id);
		
	}
}
