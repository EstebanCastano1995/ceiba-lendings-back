package com.ceiba.lendings.dominio.repositorio.client;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.dominio.entidades.Client;

import java.util.List;

public interface ClientRepository  {
    List<ClientCommand> getClients();
    Boolean createClient(Client client);
    Boolean deleteClient(String client);
}
