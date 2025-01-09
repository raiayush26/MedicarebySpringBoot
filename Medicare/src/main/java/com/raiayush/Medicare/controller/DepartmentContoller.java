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

import com.raiayush.Medicare.model.Departments;

import com.raiayush.Medicare.service.DepartmentService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clinic")
public class DepartmentContoller {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/get")
	public ResponseEntity<List<Departments>> getAllDepartment(){
		return new ResponseEntity<>(departmentService.getDepart(),HttpStatus.OK);
	}
	@PostMapping("/post")
	public ResponseEntity<String> addDepartment(@RequestBody Departments department){
		return departmentService.addDepartment(department);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Departments> getDepartmentbyID(@PathVariable int  id) {
		return departmentService.getDocById(id);
	}
	@GetMapping("/clinic/{place}")
	public ResponseEntity<List<Departments>> getDepartmentByArea(@PathVariable String place){
		return new ResponseEntity<>(departmentService.getDepartbyArea(place),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updatedDepart (@PathVariable int id, @RequestBody Departments department) {
		return departmentService.updatedDepart(department, id);
	}
	@DeleteMapping("/clinic/{id}")
	public ResponseEntity<String> DeleteDepart(@PathVariable int id){
		return departmentService.deleteDepart(id);
	}
	

}
