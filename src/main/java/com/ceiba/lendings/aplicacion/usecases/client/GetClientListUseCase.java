package com.ceiba.lendings.aplicacion.usecases.client;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.aplicacion.excepcion.UseCaseException;
import com.ceiba.lendings.aplicacion.services.ClientService;
import com.ceiba.lendings.aplicacion.usecases.UseCase;
import com.ceiba.lendings.dominio.entidades.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Component
public class GetClientListUseCase implements UseCase<Void, List<ClientCommand>> {

    private ModelMapper modelMapper = new ModelMapper();

    @Inject
    private  ClientService clientService;

    @Override
    public List<ClientCommand> execute(Void input)throws UseCaseException {
        List<Client> clients = clientService.getClients();
        List<ClientCommand> list = new ArrayList<>();
        for(int i=0;i<clients.size();i++) {
            list.add(modelMapper.map(clients.get(i),ClientCommand.class));
        }
        return list;
    }
}
