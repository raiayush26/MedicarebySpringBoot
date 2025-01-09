package com.raiayush.Medicare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.raiayush.Medicare.model.Departments;

@Repository
public interface DepartmentDao extends JpaRepository <Departments, Integer> {
		
	//@Query("SELECT j FROM Departments j WHERE j.docArea LIKE %:area%")
	List<Departments> findBydepartmentArea(String place);

}
