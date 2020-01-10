package com.ceiba.lendings.infraestructura.controller;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.aplicacion.usecases.client.GetClientListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

	private GetClientListUseCase getClientListUseCase;

	@Autowired
	public ClientController(GetClientListUseCase getClientListUseCase ) {
		this.getClientListUseCase=getClientListUseCase;
	}

	@RequestMapping(value = "/client",method = RequestMethod.GET)
	public List<ClientCommand> getClients() {
		try {
			return this.getClientListUseCase.execute(null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	@RequestMapping(value = "/client",method = RequestMethod.POST)
	public String createClient(@RequestBody ClientCommand clientCommand) {
		return "CREATING CLIENT";
	}

	@RequestMapping(value = "/client/delete",method = RequestMethod.POST)
	public String deleteClient(@RequestParam String id) {
		return "you want to delete "+id;
	}
	
}
