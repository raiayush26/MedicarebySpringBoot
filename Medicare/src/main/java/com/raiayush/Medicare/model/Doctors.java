package com.raiayush.Medicare.model;



import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Doctors {
	
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Integer docId;
	@JsonProperty("doctorName")
	private String docName;
	@JsonProperty("doctorSpecilization")
    private String docSpecialization;
	
	@JsonProperty("YearofExperienc")
    private Integer docExperience;
	
	@JsonProperty("doctorNumber")
    private Long docphoneNumber; 
   
    @JsonProperty("docArea")
    private String docArea;  
    @JsonProperty("doctorEmail")
    private String docEmail;
}
