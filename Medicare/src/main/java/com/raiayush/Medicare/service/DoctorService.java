package com.raiayush.Medicare.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.raiayush.Medicare.dao.DoctorDao;
import com.raiayush.Medicare.model.Doctors;

@Service
public class DoctorService {

	@Autowired
	DoctorDao doctorDao;

	public List<Doctors> getDoctors() {
		return doctorDao.findAll();

	}

	public ResponseEntity<Doctors> getDocById(int id) {
		try {

			Optional<Doctors> doctors = doctorDao.findById(id);
			return doctors.map(doctor -> new ResponseEntity<>(doctor, HttpStatus.OK))
					.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	public ResponseEntity<String> addDoctor(Doctors comingdoctors) {
		try {

			Doctors s1 = new Doctors();

			s1.setDocId(null);
			s1.setDocName(comingdoctors.getDocName());
			s1.setDocSpecialization(comingdoctors.getDocSpecialization());
			s1.setDocExperience(comingdoctors.getDocExperience());
			s1.setDocphoneNumber(comingdoctors.getDocphoneNumber());
			s1.setDocArea(comingdoctors.getDocArea());
			s1.setDocEmail(comingdoctors.getDocEmail());
			doctorDao.save(s1);
			return new ResponseEntity<>("added", HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("notfound", HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<String> updateDoctor(Doctors comingdoctors, int id) {
		try{
			System.out.println(id);
			System.out.println(comingdoctors);

			
			  Optional<Doctors> optionalDoctor =doctorDao.findById(id);
			  
			  if (optionalDoctor.isPresent()) { // Doctor already exists, update existing
				  System.out.println(comingdoctors);
				  Doctors existingDoctor = optionalDoctor.get();
			
			  if(	comingdoctors.getDocName() ==null &&
					comingdoctors.getDocExperience()== null && 
					comingdoctors.getDocEmail() == null&&
					comingdoctors.getDocArea() == null&&
					comingdoctors.getDocphoneNumber() == null&&
					comingdoctors.getDocSpecialization() == null) {
				  return new ResponseEntity<>("All Empty",HttpStatus.NOT_FOUND);
				  
			  }else if(comingdoctors.getDocExperience()== null && 
						comingdoctors.getDocEmail() == null&&
						comingdoctors.getDocArea() == null&&
						comingdoctors.getDocphoneNumber() == null&&
						comingdoctors.getDocSpecialization() == null) {
				  
				  existingDoctor.setDocName(comingdoctors.getDocName());
				  doctorDao.save(existingDoctor);
				  return new ResponseEntity<>("DocName is updated ",HttpStatus.NOT_FOUND);
			  }else if (comingdoctors.getDocName() ==null &&
						comingdoctors.getDocEmail() == null&&
						comingdoctors.getDocphoneNumber() == null&&
						comingdoctors.getDocArea() == null&&
						comingdoctors.getDocSpecialization() == null) {
				  doctorDao.save(existingDoctor);
				  return new ResponseEntity<>("DocExperience is updated",HttpStatus.OK);
				  
			  } else if(comingdoctors.getDocName() ==null &&
						comingdoctors.getDocExperience()== null && 
						comingdoctors.getDocEmail() == null&&
						comingdoctors.getDocArea() == null&&
						comingdoctors.getDocphoneNumber() == null&&
						comingdoctors.getDocSpecialization() == null) {
				  doctorDao.save(existingDoctor);
				  return new ResponseEntity<>("DocName is updated",HttpStatus.OK);
			  }
			  
			  
			  else if(comingdoctors.getDocName() ==null &&
						comingdoctors.getDocExperience()== null &&
						comingdoctors.getDocphoneNumber() == null&&
						comingdoctors.getDocSpecialization() == null&&
						comingdoctors.getDocArea() == null) {
				  existingDoctor.setDocEmail(comingdoctors.getDocEmail());
				  doctorDao.save(existingDoctor);
				  return new ResponseEntity<>("DocEmail is updated",HttpStatus.OK);
			  }
			  else if(comingdoctors.getDocName() ==null &&
						comingdoctors.getDocExperience()== null &&
						comingdoctors.getDocEmail() == null&&
						comingdoctors.getDocArea() == null&&
						comingdoctors.getDocSpecialization() == null) {
				  existingDoctor.setDocphoneNumber(comingdoctors.getDocphoneNumber());
				  doctorDao.save(existingDoctor);
				  return new ResponseEntity<>("DocphoneNumber is updated",HttpStatus.OK);
			  }else if(
					  comingdoctors.getDocName() ==null &&
						comingdoctors.getDocExperience()== null &&
						comingdoctors.getDocEmail() == null&&
						comingdoctors.getDocArea() == null &&
						comingdoctors.getDocphoneNumber() == null) {
				
				  existingDoctor.setDocSpecialization(comingdoctors.getDocSpecialization());
				  doctorDao.save(existingDoctor);
				  return new ResponseEntity<>("Specialization is updated",HttpStatus.OK);
			  }	
			  else if(comingdoctors.getDocName() ==null &&
						comingdoctors.getDocExperience()== null &&
						comingdoctors.getDocEmail() == null&&
						comingdoctors.getDocphoneNumber() == null) {
				  existingDoctor.setDocArea(comingdoctors.getDocArea());
				  doctorDao.save(existingDoctor);
				  return new ResponseEntity<>("DocArea is updated",HttpStatus.OK);
			  }
			  else {
			
				existingDoctor.setDocName(comingdoctors.getDocName());
				existingDoctor.setDocSpecialization(comingdoctors.getDocSpecialization());
				existingDoctor.setDocExperience(comingdoctors.getDocExperience());
				existingDoctor.setDocphoneNumber(comingdoctors.getDocphoneNumber());
				existingDoctor.setDocArea(comingdoctors.getDocArea());
				existingDoctor.setDocEmail(comingdoctors.getDocEmail());
				doctorDao.save(existingDoctor);
				//Save updated doctor 
				 doctorDao.save(existingDoctor);
				 return new ResponseEntity<>("All Filed is updated",HttpStatus.OK);
			  }
			
			}
			 

		} catch (Exception e) {
			e.printStackTrace();			
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
			return new ResponseEntity<>("notfound", HttpStatus.BAD_REQUEST);
		

	}

	public List<Doctors> getDocbyArea(String area) {
		return doctorDao.findDoctorsByArea(area);
	}

	public ResponseEntity<String> deleteDoctor(int id) {
		
		Optional<Doctors> optionalDoctor = doctorDao.findById(id);
	    if (optionalDoctor.isPresent()) {
	        doctorDao.deleteById(id);
	        return new ResponseEntity<>("Doctor data deleted successfully", HttpStatus.ACCEPTED);
	    }
	    return new ResponseEntity<>("Doctor not found", HttpStatus.NOT_FOUND);
	
	}
	
	
}



