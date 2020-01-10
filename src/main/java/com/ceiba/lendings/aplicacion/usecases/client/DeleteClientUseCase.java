package com.ceiba.lendings.aplicacion.usecases.client;

import com.ceiba.lendings.aplicacion.services.ClientService;
import com.ceiba.lendings.aplicacion.usecases.UseCase;
import javax.inject.Inject;
import org.springframework.stereotype.Component;

@Component
public class DeleteClientUseCase implements UseCase<String, Boolean> {

    @Inject
    private ClientService clientService;

    @Override
    public Boolean execute(String input) throws Exception {
        return clientService.deleteClient(input);
    }
}
