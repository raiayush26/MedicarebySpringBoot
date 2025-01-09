package com.raiayush.Medicare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Patients {
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	@Id
	private Integer patId;
	private String  PatientName;
	private Integer PatientAge;
	private Character PatientSex;
	private String PatientDisease;
	private String  patientEmail;	
	private String patientBlood;
	private long PatientPhoneNumber;
	private String PatientState;
	private String imageName;
	private String imageType;
	@Lob
	private byte[] imageData;
	
}
