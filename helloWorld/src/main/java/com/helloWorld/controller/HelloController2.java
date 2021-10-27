package com.helloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloo")
public class HelloController2 {
	
	@GetMapping
	public String helloo() {
		return "Para essa semana, quero consolidar os conhecimentos\n adquiridos sobre spring boot";
	}

}
