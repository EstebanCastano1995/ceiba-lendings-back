package com.ceiba.lendings.infraestructura.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ClienteController {

	public ClienteController( ) {
	}
	
	@RequestMapping(value = "/greeting")
	public String crear() {
		return "HOLA";
	}
	
}
