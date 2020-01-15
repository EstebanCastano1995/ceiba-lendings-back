package com.ceiba.lendings.infraestructura.controller;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.aplicacion.usecases.client.CreateClientUseCase;
import com.ceiba.lendings.aplicacion.usecases.client.DeleteClientUseCase;
import com.ceiba.lendings.aplicacion.usecases.client.GetClientListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/service")
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

	@GetMapping(value = "/client")
	public ResponseEntity<List<ClientCommand>> getClients() {
		List<ClientCommand> clients=this.getClientListUseCase.execute();
		return new ResponseEntity<>(clients, HttpStatus.OK);
	}
	
	@PostMapping(value = "/client")
	public void createClient(@RequestBody ClientCommand clientCommand) {
			this.createClientUseCase.execute(clientCommand);
	}

	@PostMapping(value = "/client/delete")
	public void deleteClient(@RequestBody ClientCommand clientCommand) {
			this.deleteClientUseCase.execute(clientCommand);
	}
}
