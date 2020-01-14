package com.ceiba.lendings.infraestructura.controller;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.aplicacion.excepcion.UseCaseException;
import com.ceiba.lendings.aplicacion.usecases.client.CreateClientUseCase;
import com.ceiba.lendings.aplicacion.usecases.client.DeleteClientUseCase;
import com.ceiba.lendings.aplicacion.usecases.client.GetClientListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ClientController {

	private static final Logger LOGGER = Logger.getLogger(ClientController.class.getName());

	private GetClientListUseCase getClientListUseCase;

	private CreateClientUseCase createClientUseCase;

	private DeleteClientUseCase deleteClientUseCase;

	@Autowired
	public ClientController(DeleteClientUseCase deleteClientUseCase,CreateClientUseCase createClientUseCase,GetClientListUseCase getClientListUseCase ) {
		this.getClientListUseCase=getClientListUseCase;
		this.createClientUseCase=createClientUseCase;
		this.deleteClientUseCase=deleteClientUseCase;
	}

	@RequestMapping(value = "/client",method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<ClientCommand>> getClients() {
		try {
			 List<ClientCommand> clients=this.getClientListUseCase.execute(null);
			 return new ResponseEntity<>(clients, HttpStatus.OK);
		} catch (UseCaseException e) {
			LOGGER.log(Level.INFO,"Exception getting clients",e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@RequestMapping(value = "/client",method = RequestMethod.POST)
	public ResponseEntity<Boolean> createClient(@RequestBody ClientCommand clientCommand) {
		try {
			Boolean result=this.createClientUseCase.execute(clientCommand);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (UseCaseException e) {
			LOGGER.log(Level.INFO,"Exception saving client",e);
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/client/delete",method = RequestMethod.POST)
	public ResponseEntity<Boolean> deleteClient(@RequestBody ClientCommand clientCommand) {
		try {
			Boolean result=this.deleteClientUseCase.execute(clientCommand);
			return new ResponseEntity<>(result,HttpStatus.OK);
		} catch (UseCaseException e) {
			LOGGER.log(Level.INFO,"Exception deleting client",e);
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
