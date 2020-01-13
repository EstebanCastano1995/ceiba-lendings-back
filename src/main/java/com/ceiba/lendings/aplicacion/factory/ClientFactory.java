package com.ceiba.lendings.aplicacion.factory;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.dominio.entidades.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientFactory {

    public Client createClient(ClientCommand clientCommand){
        return new Client(clientCommand.getId(), clientCommand.getName(), clientCommand.getAddress(),
                clientCommand.getPhone(), clientCommand.getBirthdate());
    }
}

