package com.ceiba.lendings.infraestructura.controller;

import com.ceiba.lendings.aplicacion.command.PaymentCommand;
import com.ceiba.lendings.aplicacion.usecases.payment.CreatePaymentUseCase;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/service/payment")
public class PaymentController {

    private CreatePaymentUseCase createPaymentUseCase;

    @Autowired
    public PaymentController( CreatePaymentUseCase createPaymentUseCase) {
        this.createPaymentUseCase=createPaymentUseCase;
    }

    @PostMapping
    public void createPayment(@RequestBody PaymentCommand paymentCommand) {
         this.createPaymentUseCase.execute(paymentCommand);
    }
}
