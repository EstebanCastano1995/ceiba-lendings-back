package com.ceiba.lendings.infraestructura.configuration.lending;

import com.ceiba.lendings.dominio.repositorio.lending.LendingRepository;
import com.ceiba.lendings.dominio.servicio.lending.CreateLendingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateLendingServiceBean {

    @Bean
    public CreateLendingService serviceCreateLendingBean(LendingRepository lendingRepository){
        return new CreateLendingService(lendingRepository);
    }
}
