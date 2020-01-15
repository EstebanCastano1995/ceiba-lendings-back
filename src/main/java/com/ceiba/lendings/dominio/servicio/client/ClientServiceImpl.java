package com.ceiba.lendings.dominio.servicio.client;

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
        if(!this.clientRepository.checkIfLendingClientExists(client))
           return clientRepository.deleteClient(client);
        else
            return false;
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.getClients();
    }
}
