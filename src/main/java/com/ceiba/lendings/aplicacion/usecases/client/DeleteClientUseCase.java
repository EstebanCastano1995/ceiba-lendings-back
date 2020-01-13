package com.ceiba.lendings.aplicacion.usecases.client;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.aplicacion.excepcion.UseCaseException;
import com.ceiba.lendings.aplicacion.factory.ClientFactory;
import com.ceiba.lendings.aplicacion.services.ClientService;
import com.ceiba.lendings.aplicacion.usecases.UseCase;
import javax.inject.Inject;
import org.springframework.stereotype.Component;
import com.ceiba.lendings.dominio.entidades.Client;

@Component
public class DeleteClientUseCase implements UseCase<ClientCommand, Boolean> {

    private final ClientFactory clientFactory;

    @Inject
    private ClientService clientService;

    public DeleteClientUseCase(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public Boolean execute(ClientCommand input) throws UseCaseException  {
        Client cliente = this.clientFactory.createClient(input);
        return clientService.deleteClient(cliente);
    }
}
