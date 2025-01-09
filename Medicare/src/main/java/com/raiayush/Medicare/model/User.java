package com.raiayush.Medicare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class User {
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private int id;
	private String username;
	private String password;
}
