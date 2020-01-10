package com.ceiba.lendings.dominio.servicio.client;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.aplicacion.services.ClientService;
import com.ceiba.lendings.dominio.entidades.Client;
import com.ceiba.lendings.dominio.repositorio.client.ClientRepository;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import java.util.List;

@Service
public class CreateClientService implements ClientService {

    @Inject
    private ClientRepository clientRepository;

    public Boolean createClient(Client cliente) {
        return true;
    }

    @Override
    public Boolean deleteClient(String client) {
        return null;
    }

    public List<ClientCommand> getClients() {
        return clientRepository.getClients();
    }
}
