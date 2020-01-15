package com.ceiba.lendings.aplicacion.usecases.client;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.aplicacion.factory.ClientFactory;
import com.ceiba.lendings.aplicacion.usecases.UseCaseVoid;
import com.ceiba.lendings.dominio.entidades.Client;
import com.ceiba.lendings.dominio.servicio.client.CreateClientService;
import org.springframework.stereotype.Component;

@Component
public class CreateClientUseCase implements UseCaseVoid<ClientCommand> {

    private final ClientFactory clientFactory;

    private CreateClientService createClientService;

    public CreateClientUseCase(ClientFactory clientFactory, CreateClientService createClientService) {
        this.clientFactory = clientFactory;
        this.createClientService=createClientService;
    }

    @Override
    public void execute(ClientCommand input){
        Client cliente = this.clientFactory.createClient(input);
        createClientService.createClient(cliente);
    }
}
