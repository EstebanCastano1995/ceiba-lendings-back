package com.ceiba.lendings.infraestructura.configuration.payment;

import com.ceiba.lendings.dominio.repositorio.payment.PaymentRepository;
import com.ceiba.lendings.dominio.servicio.payment.CreatePaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatePaymentServiceBean {
    @Bean
    public CreatePaymentService serviceSavePaymentBean(PaymentRepository paymentRepository){
        return new CreatePaymentService(paymentRepository);
    }
}
