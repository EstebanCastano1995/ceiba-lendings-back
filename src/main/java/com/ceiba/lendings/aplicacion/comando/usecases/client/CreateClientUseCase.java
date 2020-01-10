package com.ceiba.lendings.aplicacion.comando.usecases.client;

import com.ceiba.lendings.aplicacion.comando.command.ClientCommand;
import com.ceiba.lendings.aplicacion.comando.factory.ClientFactory;
import com.ceiba.lendings.aplicacion.comando.services.ClientService;
import com.ceiba.lendings.aplicacion.comando.usecases.UseCase;
import com.ceiba.lendings.dominio.entidades.Client;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class CreateClientUseCase implements UseCase<ClientCommand, Integer> {

    private final ClientFactory clientFactory;

    @Inject
    private ClientService clientService;

    public CreateClientUseCase(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public Integer execute(ClientCommand input) throws Exception {
        Client cliente = this.clientFactory.createClient(input);
        return clientService.createClient(cliente);
    }
}
