package com.ceiba.lendings.aplicacion.factory;

import com.ceiba.lendings.aplicacion.command.PaymentCommand;
import com.ceiba.lendings.dominio.entidades.Lending;
import com.ceiba.lendings.dominio.entidades.Payment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PaymentFactory {

    private ModelMapper modelMapper = new ModelMapper();

    public Payment createPayment(PaymentCommand paymentCommand){
        return new Payment(paymentCommand.getId(), paymentCommand.getPayment_value(), paymentCommand.getPayment_date(),modelMapper.map(paymentCommand.getLending_id(), Lending.class));
    }
}
