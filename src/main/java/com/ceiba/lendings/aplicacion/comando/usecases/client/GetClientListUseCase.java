package com.ceiba.lendings.aplicacion.comando.usecases.client;

import com.ceiba.lendings.aplicacion.comando.command.ClientCommand;
import com.ceiba.lendings.aplicacion.comando.services.ClientService;
import com.ceiba.lendings.aplicacion.comando.usecases.UseCase;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

@Component
public class GetClientListUseCase implements UseCase<Void, List<ClientCommand>> {

    @Inject
    private  ClientService clientService;

    @Override
    public List<ClientCommand> execute(Void input) throws Exception {
        return clientService.getClients();
    }
}
