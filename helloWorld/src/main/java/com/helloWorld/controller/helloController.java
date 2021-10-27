package com.helloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class helloController {
	@GetMapping
	
	public String hello() {
		return "Hello world ta dificil, para essa atividade foi necessária\n muita persistência e atenção aos detalhes";
	}
	
}
  