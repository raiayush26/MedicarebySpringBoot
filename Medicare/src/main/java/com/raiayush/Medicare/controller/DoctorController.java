package com.raiayush.Medicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raiayush.Medicare.model.Doctors;
import com.raiayush.Medicare.service.DoctorService;





@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Doc")
public class DoctorController {
		
	@Autowired
	 DoctorService docService;

	@GetMapping("/api/doctors")
	public ResponseEntity<List<Doctors>> getDoctor(){
		return new ResponseEntity<>(docService.getDoctors(),HttpStatus.OK);
	}
	//@RequestBody
	//PathVariable
	@GetMapping("/api/doctor/{id}")
	public ResponseEntity<Doctors> getDocbyID(@PathVariable int  id) {
		return docService.getDocById(id);
	}
	@PostMapping("/post")
	public ResponseEntity<String> addDoctor(@RequestBody Doctors doctor){
		return (docService.addDoctor(doctor));
	}
	@PutMapping("/updated/doctors/{id}")
	public ResponseEntity<String> updatedDoctor(@RequestBody Doctors doctor ,@PathVariable int id){
		return docService.updateDoctor(doctor, id);
	}
	@GetMapping("/doc/{place}")
	public ResponseEntity<List<Doctors>> getDoctorByArea(@PathVariable String place){
		System.out.print(place);
		return new ResponseEntity<>(docService.getDocbyArea(place),HttpStatus.OK);
		
	}
	@DeleteMapping("/api/doctors/{id}")
	public ResponseEntity<String> deleteDoctorValue(@PathVariable int id){
		System.out.print(id);
		return docService.deleteDoctor(id);
	}
}
