package com.ceiba.lendings.infraestructura.controller;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.aplicacion.usecases.client.CreateClientUseCase;
import com.ceiba.lendings.aplicacion.usecases.client.DeleteClientUseCase;
import com.ceiba.lendings.aplicacion.usecases.client.GetClientListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

	private GetClientListUseCase getClientListUseCase;

	private CreateClientUseCase createClientUseCase;

	private DeleteClientUseCase deleteClientUseCase;

	@Autowired
	public ClientController(DeleteClientUseCase deleteClientUseCase,CreateClientUseCase createClientUseCase,GetClientListUseCase getClientListUseCase ) {
		this.getClientListUseCase=getClientListUseCase;
		this.createClientUseCase=createClientUseCase;
		this.deleteClientUseCase=deleteClientUseCase;
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
	public Boolean createClient(@RequestBody ClientCommand clientCommand) {
		try {
			return this.createClientUseCase.execute(clientCommand);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@RequestMapping(value = "/client/delete",method = RequestMethod.POST)
	public Boolean deleteClient(@RequestBody ClientCommand clientCommand) {
		try {
			return this.deleteClientUseCase.execute(clientCommand);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
