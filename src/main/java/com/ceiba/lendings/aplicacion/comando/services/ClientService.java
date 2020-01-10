package com.ceiba.lendings.aplicacion.comando.services;

import com.ceiba.lendings.aplicacion.comando.command.ClientCommand;
import com.ceiba.lendings.dominio.entidades.Client;
import java.util.List;

public interface ClientService {
    List<ClientCommand> getClients();
    Integer createClient(Client client);
}
