package com.ceiba.lendings.infraestructura.adaptador.repositorio.client;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.dominio.entidades.Client;
import com.ceiba.lendings.dominio.repositorio.client.ClientRepository;
import com.ceiba.lendings.infraestructura.entidades.ClientEntity;
import com.ceiba.lendings.infraestructura.jpa.ClientJPA;
import com.ceiba.lendings.infraestructura.jpa.LendingJPA;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepositoryJpa implements ClientRepository {

    private static final boolean TRUERESULT=true;
    private static final boolean FALSERESULT=false;

    @Autowired
    private ClientJPA clientJPA;

    @Autowired
    private LendingJPA lendingJPA;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ClientCommand> getClients() {
        List<ClientEntity> clienteEntities = clientJPA.findAll();
        List<ClientCommand> list = new ArrayList<>();
        for(int i=0;i<clienteEntities.size();i++) {
            list.add(modelMapper.map(clienteEntities.get(i),ClientCommand.class));
        }
        return list;
    }

    @Override
    public Boolean createClient(Client client) {
        ClientEntity clientEntity = modelMapper.map(client, ClientEntity.class);
        this.clientJPA.save(clientEntity);
        return this.checkIfExists(client);
    }

    @Override
    public Boolean deleteClient(Client client) {
        ClientEntity clientEntity = modelMapper.map(client, ClientEntity.class);
        if(this.checkIfExists(client)) {
            clientJPA.delete(clientEntity);
            Boolean isFound=this.checkIfExists(client);
            return isFound?FALSERESULT:TRUERESULT;
        }
        else
            return false;
    }

    @Override
    public Boolean checkIfLendingClientExists(Client client) {
        ClientEntity clientEntity = modelMapper.map(client, ClientEntity.class);
        return  lendingJPA.getClientLendings(clientEntity.getId())>0?TRUERESULT:FALSERESULT;
    }

    private Boolean checkIfExists(Client client) {
        ClientEntity clientEntity = modelMapper.map(client, ClientEntity.class);
        return clientJPA.existsById(clientEntity.getId());
    }
}
