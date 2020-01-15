package com.ceiba.lendings.dominio.repositorio.client;

import com.ceiba.lendings.dominio.entidades.Client;
import java.util.List;

public interface ClientRepository  {
    List<Client> getClients();
    Boolean createClient(Client client);
    Boolean deleteClient(Client client);
    Boolean checkIfLendingClientExists(Client id);
}
