package com.ceiba.lendings.aplicacion.usecases.client;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.aplicacion.factory.ClientFactory;
import com.ceiba.lendings.aplicacion.usecases.UseCaseVoid;
import com.ceiba.lendings.dominio.servicio.client.DeleteClientService;
import org.springframework.stereotype.Component;
import com.ceiba.lendings.dominio.entidades.Client;

@Component
public class DeleteClientUseCase implements UseCaseVoid<ClientCommand> {

    private final ClientFactory clientFactory;

    private DeleteClientService deleteClientService;

    public DeleteClientUseCase(ClientFactory clientFactory,DeleteClientService deleteClientService) {
        this.clientFactory = clientFactory;
        this.deleteClientService=deleteClientService;
    }

    @Override
    public void execute(ClientCommand input)  {
        Client cliente = this.clientFactory.createClient(input);
        deleteClientService.deleteClient(cliente);
    }
}
