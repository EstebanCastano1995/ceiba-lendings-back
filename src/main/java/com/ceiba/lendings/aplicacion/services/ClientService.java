package com.ceiba.lendings.aplicacion.services;

import com.ceiba.lendings.dominio.entidades.Client;
import java.util.List;

public interface ClientService {
    List<Client> getClients();
    Boolean createClient(Client client);
    Boolean deleteClient(Client client);
}
