package com.ceiba.lendings.infraestructura.configuration.client;

import com.ceiba.lendings.dominio.repositorio.client.ClientRepository;
import com.ceiba.lendings.dominio.servicio.client.GetClientsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetClientServiceBean {
    @Bean
    public GetClientsService serviceGetClientsBean(ClientRepository clientRepository){
        return new GetClientsService(clientRepository);
    }
}
