package com.ceiba.lendings.aplicacion.usecases.payment;

import com.ceiba.lendings.aplicacion.command.PaymentCommand;
import com.ceiba.lendings.aplicacion.factory.PaymentFactory;
import com.ceiba.lendings.aplicacion.usecases.UseCaseVoid;
import com.ceiba.lendings.dominio.entidades.Payment;
import com.ceiba.lendings.dominio.servicio.payment.CreatePaymentService;
import org.springframework.stereotype.Component;

@Component
public class CreatePaymentUseCase implements UseCaseVoid<PaymentCommand> {

    private final PaymentFactory paymentFactory;

    private CreatePaymentService createPaymentService;

    public CreatePaymentUseCase(PaymentFactory paymentFactory,CreatePaymentService createPaymentService) {
        this.paymentFactory = paymentFactory;
        this.createPaymentService=createPaymentService;
    }

    @Override
    public void execute(PaymentCommand input){
        Payment payment = this.paymentFactory.createPayment(input);
        createPaymentService.createPayment(payment);
    }
}