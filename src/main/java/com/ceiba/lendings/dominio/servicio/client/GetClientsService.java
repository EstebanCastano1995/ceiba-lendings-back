package com.ceiba.lendings.dominio.servicio.client;

import com.ceiba.lendings.dominio.entidades.Client;
import com.ceiba.lendings.dominio.repositorio.client.ClientRepository;
import java.util.List;

public class GetClientsService {

    private ClientRepository clientRepository;

    public GetClientsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.getClients();
    }
}
