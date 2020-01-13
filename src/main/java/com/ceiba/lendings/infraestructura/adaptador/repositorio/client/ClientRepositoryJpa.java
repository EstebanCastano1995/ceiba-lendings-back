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
        System.out.println("***********************");
        System.out.println(clientEntity);
        System.out.println(client);
        this.clientJPA.save(clientEntity);
        return true;
    }

    @Override
    public Boolean deleteClient(Client client) {
        ClientEntity clientEntity = modelMapper.map(client, ClientEntity.class);
        if(lendingJPA.existsById(clientEntity.getId().longValue())) {
            clientJPA.delete(clientEntity);
            return true;
        }
        else
            return false;
    }

    private Boolean translateResult(Integer result) {
      return result>0?true:false;
    }
}
