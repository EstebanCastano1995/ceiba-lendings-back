package com.ceiba.lendings.dominio.servicio.client;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.aplicacion.services.ClientService;
import com.ceiba.lendings.dominio.entidades.Client;
import com.ceiba.lendings.dominio.repositorio.client.ClientRepository;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Inject
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    @Override
    public Boolean createClient(Client cliente) {
        return clientRepository.createClient(cliente);
    }

    @Override
    public Boolean deleteClient(Client client) {
        return clientRepository.deleteClient(client);
    }

    @Override
    public List<ClientCommand> getClients() {
        return clientRepository.getClients();
    }
}
