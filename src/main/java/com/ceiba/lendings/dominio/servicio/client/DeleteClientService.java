package com.ceiba.lendings.dominio.servicio.client;

import com.ceiba.lendings.dominio.entidades.Client;
import com.ceiba.lendings.dominio.excepcion.ClientHasLendingsException;
import com.ceiba.lendings.dominio.excepcion.ClientMustExistException;
import com.ceiba.lendings.dominio.repositorio.client.ClientRepository;

public class DeleteClientService {

    private static final String CLIENT_DOES_NOT_EXIST = "El cliente que intenta eliminar no esta registrado";

    private static final String CLIENT_HAS_LENDINGS = "El cliente que intenta eliminar tiene prestamos registrados";

    private ClientRepository clientRepository;

    public DeleteClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void deleteClient(Client client) {
       checkIfLendingExist(client);
       checkIfClientExists(client);
       clientRepository.deleteClient(client);
    }

    private void checkIfLendingExist(Client client){
        if(this.clientRepository.checkIfLendingClientExists(client))
            throw new ClientHasLendingsException(CLIENT_HAS_LENDINGS);
    }

    private void checkIfClientExists(Client client){
        if(!this.clientRepository.checkIfClientExists(client))
            throw new ClientMustExistException(CLIENT_DOES_NOT_EXIST);
    }
}
