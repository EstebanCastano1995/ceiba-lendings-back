package com.ceiba.lendings.infraestructura.configuration.lending;

import com.ceiba.lendings.dominio.repositorio.lending.LendingRepository;
import com.ceiba.lendings.dominio.servicio.lending.GetLendingsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetLendingServiceBean {

    @Bean
    public GetLendingsService serviceGetLendingsBean(LendingRepository lendingRepository){
        return new GetLendingsService(lendingRepository);
    }
}
