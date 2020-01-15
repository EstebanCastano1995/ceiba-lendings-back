package com.ceiba.lendings.infraestructura.controller;

import com.ceiba.lendings.aplicacion.command.PaymentCommand;
import com.ceiba.lendings.aplicacion.usecases.payment.CreatePaymentUseCase;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.logging.Logger;

@RestController
@RequestMapping("/service")
public class PaymentController {

    private static final Logger LOGGER = Logger.getLogger(PaymentController.class.getName());

    private CreatePaymentUseCase createPaymentUseCase;

    @Autowired
    public PaymentController( CreatePaymentUseCase createPaymentUseCase) {
        this.createPaymentUseCase=createPaymentUseCase;
    }

    @PostMapping(value = "/payment")
    public void createPayment(@RequestBody PaymentCommand paymentCommand) {
         this.createPaymentUseCase.execute(paymentCommand);
    }
}
