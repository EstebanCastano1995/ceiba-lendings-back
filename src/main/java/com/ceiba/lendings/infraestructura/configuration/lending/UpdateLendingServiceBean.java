package com.ceiba.lendings.infraestructura.configuration.lending;

import com.ceiba.lendings.dominio.repositorio.lending.LendingRepository;
import com.ceiba.lendings.dominio.servicio.lending.UpdateLendingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateLendingServiceBean {

    @Bean
    public UpdateLendingService serviceCreatePaymentBean(LendingRepository lendingRepository){
        return new UpdateLendingService(lendingRepository);
    }
}
