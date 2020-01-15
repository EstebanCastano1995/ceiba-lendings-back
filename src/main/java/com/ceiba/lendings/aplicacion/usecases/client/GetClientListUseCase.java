package com.ceiba.lendings.aplicacion.usecases.client;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.aplicacion.usecases.UseCaseReturn;
import com.ceiba.lendings.dominio.entidades.Client;
import com.ceiba.lendings.dominio.servicio.client.GetClientsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class GetClientListUseCase implements UseCaseReturn<List<ClientCommand>> {

    private ModelMapper modelMapper = new ModelMapper();

    private GetClientsService getClientsService;

    public GetClientListUseCase(GetClientsService getClientsService) {
        this.getClientsService=getClientsService;
    }

    @Override
    public List<ClientCommand> execute() {
        List<Client> clients = getClientsService.getClients();
        List<ClientCommand> list = new ArrayList<>();
        for(int i=0;i<clients.size();i++) {
            list.add(modelMapper.map(clients.get(i),ClientCommand.class));
        }
        return list;
    }
}
