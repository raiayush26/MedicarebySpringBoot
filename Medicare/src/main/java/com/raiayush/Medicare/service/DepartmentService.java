package com.raiayush.Medicare.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.raiayush.Medicare.dao.DepartmentDao;
import com.raiayush.Medicare.model.Departments;


@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDao depatmentDao;
	
	public List<Departments> getDepart() {		
		return depatmentDao.findAll();
	}

	public ResponseEntity<Departments> getDocById(int id) {
		try {

			Optional<Departments> department = depatmentDao.findById(id);			
			return department.map(depart -> new ResponseEntity<>(depart, HttpStatus.OK))
					.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
}

	public ResponseEntity<String> addDepartment(Departments comingdepartment) {
		System.out.println(comingdepartment);
		Departments d = new Departments();
		d.setDepartmentName(comingdepartment.getDepartmentName());
		d.setDepartmentHead(comingdepartment.getDepartmentHead());
		d.setDepartmentArea(comingdepartment.getDepartmentArea());
		d.setDepartmentEmployment(comingdepartment.getDepartmentEmployment());
		d.setDepartmentPhoneNo(comingdepartment.getDepartmentPhoneNo());
		d.setDepartmentOpeningTime(comingdepartment.getDepartmentOpeningTime());
		d.setDepartmentClosingTime(comingdepartment.getDepartmentClosingTime());
		 //System.out.println(d);
		depatmentDao.save(d);
		return new ResponseEntity<>("added",HttpStatus.ACCEPTED);
	}

	public List<Departments> getDepartbyArea(String place) {
	
		return depatmentDao.findBydepartmentArea(place);
	}

	public ResponseEntity<String> updatedDepart(Departments comingdepar, int id) {
		System.out.println(comingdepar);
		System.out.println(id);
		Optional<Departments> checkDepart = depatmentDao.findById(id);
	try {
		if(checkDepart.isPresent()) {
			Departments existDepart  = checkDepart.get();
		if(
				Objects.equals(comingdepar.getDepartmentName(), null)&&
				Objects.equals(comingdepar.getDepartmentHead(), null)&&
				Objects.equals(comingdepar.getDepartmentArea(), null)&&
				Objects.equals(comingdepar.getDepartmentName(), null)&&
				Objects.equals(comingdepar.getDepartmentEmployment(), null)&&
				Objects.equals(comingdepar.getDepartmentPhoneNo(), null)&&
				Objects.equals(comingdepar.getDepartmentOpeningTime(), null)&&
				Objects.equals(comingdepar.getDepartmentClosingTime(), null)
			) {
			
			return new ResponseEntity<>("All Empty",HttpStatus.ALREADY_REPORTED);
		}else if(
				
				comingdepar.getDepartmentHead() ==null &&
				comingdepar.getDepartmentArea()== null&&
				Objects.equals(comingdepar.getDepartmentEmployment(), null)&&
				Objects.equals(comingdepar.getDepartmentPhoneNo(), null)&&
				comingdepar.getDepartmentOpeningTime()== null&&
				comingdepar.getDepartmentClosingTime()== null) {
			existDepart.setDepartmentName(comingdepar.getDepartmentName());
			depatmentDao.save(existDepart);
			return new ResponseEntity<>("getDepartmentName is updated",HttpStatus.ALREADY_REPORTED);
		}
		else if(
				Objects.equals(comingdepar.getDepartmentName(), null)&&
				Objects.equals(comingdepar.getDepartmentArea(), null)&&
				Objects.equals(comingdepar.getDepartmentName(), null)&&
				Objects.equals(comingdepar.getDepartmentEmployment(), null)&&
				Objects.equals(comingdepar.getDepartmentPhoneNo(), null)&&
				Objects.equals(comingdepar.getDepartmentOpeningTime(), null)&&
				Objects.equals(comingdepar.getDepartmentClosingTime(), null)
				) {
			existDepart.setDepartmentHead(comingdepar.getDepartmentHead());
			depatmentDao.save(existDepart);
			return new ResponseEntity<>("getDepartmentHead is updated",HttpStatus.ACCEPTED);
		}else if(
				Objects.equals(comingdepar.getDepartmentName(), null)&&
				Objects.equals(comingdepar.getDepartmentHead(), null)&&
				Objects.equals(comingdepar.getDepartmentEmployment(), null)&&
				Objects.equals(comingdepar.getDepartmentPhoneNo(), null)&&
				comingdepar.getDepartmentOpeningTime()==null &&
				comingdepar.getDepartmentClosingTime()==null) {
			existDepart.setDepartmentArea(comingdepar.getDepartmentArea());
			depatmentDao.save(existDepart);
			return new ResponseEntity<>("DepartmentArea is updated",HttpStatus.ACCEPTED);	
	
		}
		else if(
				Objects.equals(comingdepar.getDepartmentName(), null)&&
				Objects.equals(comingdepar.getDepartmentHead(), null)&&
				Objects.equals(comingdepar.getDepartmentArea(), null)&&
				Objects.equals(comingdepar.getDepartmentPhoneNo(), null)&&
				Objects.equals(comingdepar.getDepartmentOpeningTime(), null)&&
				Objects.equals(comingdepar.getDepartmentClosingTime(), null) ){
			existDepart.setDepartmentEmployment(comingdepar.getDepartmentEmployment());
			depatmentDao.save(existDepart);
			return new ResponseEntity<>("DepartmentEmployment is updated",HttpStatus.ACCEPTED);
				}
		else if(Objects.equals(comingdepar.getDepartmentName(), null)&&
				Objects.equals(comingdepar.getDepartmentHead(), null)&&
				Objects.equals(comingdepar.getDepartmentArea(), null)&&
				Objects.equals(comingdepar.getDepartmentName(), null)&&
				Objects.equals(comingdepar.getDepartmentEmployment(), null)&&
				Objects.equals(comingdepar.getDepartmentOpeningTime(), null)&&
				Objects.equals(comingdepar.getDepartmentClosingTime(), null)) {
			existDepart.setDepartmentPhoneNo(comingdepar.getDepartmentPhoneNo());
			depatmentDao.save(existDepart);
			return new ResponseEntity<>("DepartmentPhoneNo is updated",HttpStatus.ACCEPTED);
		}else if(Objects.equals(comingdepar.getDepartmentName(), null)&&
				Objects.equals(comingdepar.getDepartmentHead(), null)&&
				Objects.equals(comingdepar.getDepartmentArea(), null)&&
				Objects.equals(comingdepar.getDepartmentName(), null)&&
				Objects.equals(comingdepar.getDepartmentEmployment(), null)&&
				Objects.equals(comingdepar.getDepartmentPhoneNo(), null)&&
				Objects.equals(comingdepar.getDepartmentClosingTime(), null)) {
			existDepart.setDepartmentOpeningTime(comingdepar.getDepartmentOpeningTime());
			depatmentDao.save(existDepart);
			return new ResponseEntity<>("DepartmentOpeningTime is updated",HttpStatus.ACCEPTED);
		}else if(Objects.equals(comingdepar.getDepartmentName(), null)&&
				Objects.equals(comingdepar.getDepartmentHead(), null)&&
				Objects.equals(comingdepar.getDepartmentArea(), null)&&
				Objects.equals(comingdepar.getDepartmentName(), null)&&
				Objects.equals(comingdepar.getDepartmentEmployment(), null)&&
				Objects.equals(comingdepar.getDepartmentPhoneNo(), null)&&
				Objects.equals(comingdepar.getDepartmentOpeningTime(), null)) {
			existDepart.setDepartmentClosingTime(comingdepar.getDepartmentClosingTime());
			depatmentDao.save(existDepart);
			return new ResponseEntity<>("DepartmentClosingTime is updated",HttpStatus.ACCEPTED);	
		}
		existDepart.setDepartmentName(comingdepar.getDepartmentName());
		existDepart.setDepartmentHead(comingdepar.getDepartmentHead());
		existDepart.setDepartmentArea(comingdepar.getDepartmentArea());
		existDepart.setDepartmentEmployment(comingdepar.getDepartmentEmployment());	
		existDepart.setDepartmentEmployment(comingdepar.getDepartmentEmployment());
		existDepart.setDepartmentPhoneNo(comingdepar.getDepartmentPhoneNo());
		existDepart.setDepartmentOpeningTime(comingdepar.getDepartmentOpeningTime());
		existDepart.setDepartmentClosingTime(comingdepar.getDepartmentClosingTime());
			return new ResponseEntity<>("All flid have to updated",HttpStatus.ACCEPTED);
		}
		else return new ResponseEntity<>("Not Found ID",HttpStatus.NOT_FOUND);
				
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);
		} 
	}

	public ResponseEntity<String> deleteDepart(int id) {
		try {
		Optional<Departments> checkDepart = depatmentDao.findById(id);
			if(checkDepart.isPresent()) {
				depatmentDao.deleteById(id);
				return new  ResponseEntity<>("Delete",HttpStatus.ACCEPTED);
			}
			return new  ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new  ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
		}
	}
}




/*
 * comingdepar.getDepartmentName()== null&& comingdepar.getDepartmentHead()==
 * null&& comingdepar.getDepartmentArea()==null&&
 * comingdepar.getDepartmentName()== null&&
 * comingdepar.getDepartmentEmployment()==null&&
 * comingdepar.getDepartmentPhoneNo()== null&&
 * comingdepar.getDepartmentOpeningTime() ==null&&
 * comingdepar.getDepartmentClosingTime()== null
 */
