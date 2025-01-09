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

public class Departments {
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Id   
     private Integer departmentId;
	
	 private String departmentName;
	 private String departmentHead;
	 private String departmentArea;
	 private Integer departmentEmployment;
	 @JsonProperty("departmentphoneno")
	 private Long departmentPhoneNo;
	 @JsonProperty("DepartmentOpeningtime")
	 private String departmentOpeningTime;
	 @JsonProperty("DepartmentClosingtime")
	 private String departmentClosingTime;
	
	
		
}
