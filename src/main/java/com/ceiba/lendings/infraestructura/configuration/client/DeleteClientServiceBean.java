package com.ceiba.lendings.infraestructura.configuration.client;

import com.ceiba.lendings.dominio.repositorio.client.ClientRepository;
import com.ceiba.lendings.dominio.servicio.client.CreateClientService;
import com.ceiba.lendings.dominio.servicio.client.DeleteClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteClientServiceBean {

    @Bean
    public DeleteClientService serviceDeleteClientBean(ClientRepository clientRepository){
        return new DeleteClientService(clientRepository);
    }
}
