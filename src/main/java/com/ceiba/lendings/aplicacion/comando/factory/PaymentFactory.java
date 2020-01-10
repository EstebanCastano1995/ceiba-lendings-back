package com.ceiba.lendings.aplicacion.comando.factory;

import com.ceiba.lendings.aplicacion.comando.command.PaymentCommand;
import com.ceiba.lendings.dominio.entidades.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFactory {

    public Payment createPayment(PaymentCommand paymentCommand){
        return new Payment(paymentCommand.getId(), paymentCommand.getPayment_value(), paymentCommand.getPayment_date());
    }
}
