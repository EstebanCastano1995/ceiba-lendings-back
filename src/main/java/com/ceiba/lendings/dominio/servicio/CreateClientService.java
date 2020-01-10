package com.ceiba.lendings.dominio.servicio;

import com.ceiba.lendings.aplicacion.comando.command.ClientCommand;
import com.ceiba.lendings.aplicacion.comando.services.ClientService;
import com.ceiba.lendings.dominio.entidades.Client;
import com.ceiba.lendings.dominio.repositorio.ClientRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CreateClientService implements ClientService {

    @Inject
    private ClientRepository clientRepository;

    public Integer createClient(Client cliente) {
        return 1;
    }

    public List<ClientCommand> getClients() {
        return clientRepository.getClients();
    }
}
