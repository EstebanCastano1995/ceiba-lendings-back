package com.ceiba.lendings.aplicacion.usecases.client;

import com.ceiba.lendings.aplicacion.usecases.UseCaseVoid;
import com.ceiba.lendings.dominio.servicio.client.DeleteClientService;
import org.springframework.stereotype.Component;

@Component
public class DeleteClientUseCase implements UseCaseVoid<Long> {

    private DeleteClientService deleteClientService;

    public DeleteClientUseCase(DeleteClientService deleteClientService) {
        this.deleteClientService=deleteClientService;
    }

    @Override
    public void execute(Long input)  {
        deleteClientService.deleteClient(input);
    }
}
