package com.ceiba.lendings.infraestructura.configuration.client;

import com.ceiba.lendings.dominio.repositorio.client.ClientRepository;
import com.ceiba.lendings.dominio.servicio.client.CreateClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateClientServiceBean {

    @Bean
    public CreateClientService serviceCreateClientBean(ClientRepository clientRepository){
        return new CreateClientService(clientRepository);
    }
}
