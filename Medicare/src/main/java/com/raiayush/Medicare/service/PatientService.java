package com.raiayush.Medicare.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.raiayush.Medicare.dao.PatientDao;

import com.raiayush.Medicare.model.Patients;

@Service
public class PatientService {
	
	@Autowired
	 PatientDao patientDao;
	
	public List<Patients> getPatients() {
		return patientDao.findAll();	
	}

	

	public ResponseEntity<String> getPatientbypatientEmail(String email) {
		
		return patientDao.findBypatientEmail(email);
	}



	public ResponseEntity<String> deletPatientById(int id) {
		// TODO Auto-generated method stub
		Optional<Patients> optionalPat= patientDao.findById(id);
	    if (optionalPat.isPresent()) {
	        patientDao.deleteById(id);
	        return new ResponseEntity<>("Patient data deleted successfully", HttpStatus.ACCEPTED);
	    }
	    return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
	}

}
