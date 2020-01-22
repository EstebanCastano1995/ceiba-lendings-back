package com.ceiba.lendings.dominio.servicio.client;

import com.ceiba.lendings.dominio.entidades.Client;
import com.ceiba.lendings.dominio.excepcion.ClientIsAlreadySavedException;
import com.ceiba.lendings.dominio.repositorio.client.ClientRepository;

public class CreateClientService {

    private static final String CLIENT_ALREADY_EXIST = "El cliente que desea guardar ya se encuentra registrado";

    private ClientRepository clientRepository;

    public CreateClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void createClient(Client client) {
         checkIfClientExists(client);
         clientRepository.createClient(client);
    }

    private void checkIfClientExists(Client client){
        if(clientRepository.checkIfClientExists(client))
            throw new ClientIsAlreadySavedException(CLIENT_ALREADY_EXIST);
    }
}
