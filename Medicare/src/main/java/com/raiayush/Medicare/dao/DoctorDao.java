package com.raiayush.Medicare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.raiayush.Medicare.model.Doctors;



@Repository
public interface DoctorDao  extends JpaRepository <Doctors, Integer>{

	@Query("SELECT j FROM Doctors j WHERE j.docArea LIKE %:area%")
	List<Doctors> findDoctorsByArea(String area);

	//@Query("select j from JobPost j where j.PostProfile like %?1% or j.PostDesc like %?2%")
	 
	//  @Query("select d1_0.doc_id,d1_0.doc_area,d1_0.doc_email,d1_0.doc_experience,d1_0.doc_name,d1_0.doc_specialization,d1_0.docphone_number from doctor d1_0")  
	    //List<Doctors> findAllDetails();
	
}
