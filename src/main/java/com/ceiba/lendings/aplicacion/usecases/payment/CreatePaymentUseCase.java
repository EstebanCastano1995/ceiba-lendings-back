package com.ceiba.lendings.aplicacion.usecases.payment;

import com.ceiba.lendings.aplicacion.command.PaymentCommand;
import com.ceiba.lendings.aplicacion.excepcion.UseCaseException;
import com.ceiba.lendings.aplicacion.factory.PaymentFactory;
import com.ceiba.lendings.aplicacion.services.PaymentService;
import com.ceiba.lendings.aplicacion.usecases.UseCase;
import com.ceiba.lendings.dominio.entidades.Payment;
import javax.inject.Inject;
import org.springframework.stereotype.Component;

@Component
public class CreatePaymentUseCase implements UseCase<PaymentCommand, Boolean> {

    private final PaymentFactory paymentFactory;

    @Inject
    private PaymentService paymentService;

    public CreatePaymentUseCase(PaymentFactory paymentFactory) {
        super();
        this.paymentFactory = paymentFactory;
    }

    @Override
    public Boolean execute(PaymentCommand input) throws UseCaseException {
        Payment payment = this.paymentFactory.createPayment(input);
        return paymentService.createPayment(payment);
    }
}