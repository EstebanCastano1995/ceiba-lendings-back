package com.ceiba.lendings.aplicacion.usecases.client;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.aplicacion.factory.ClientFactory;
import com.ceiba.lendings.aplicacion.services.ClientService;
import com.ceiba.lendings.aplicacion.usecases.UseCase;
import com.ceiba.lendings.dominio.entidades.Client;
import org.springframework.stereotype.Component;
import javax.inject.Inject;

@Component
public class CreateClientUseCase implements UseCase<ClientCommand, Boolean> {

    private final ClientFactory clientFactory;

    @Inject
    private ClientService clientService;

    public CreateClientUseCase(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public Boolean execute(ClientCommand input) throws Exception {
        Client cliente = this.clientFactory.createClient(input);
        return clientService.createClient(cliente);
    }
}
