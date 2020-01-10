package com.ceiba.lendings.aplicacion.services;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.dominio.entidades.Client;
import java.util.List;

public interface ClientService {
    List<ClientCommand> getClients();
    Boolean createClient(Client client);
    Boolean deleteClient(String client);
}
