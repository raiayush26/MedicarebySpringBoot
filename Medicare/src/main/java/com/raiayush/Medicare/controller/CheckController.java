package com.raiayush.Medicare.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {
	
	@GetMapping("/")
	public String Hello() {
		return "is working fine";
	}
	
}
