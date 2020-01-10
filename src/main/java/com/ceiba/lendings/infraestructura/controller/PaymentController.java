package com.ceiba.lendings.infraestructura.controller;

import com.ceiba.lendings.aplicacion.command.PaymentCommand;
import com.ceiba.lendings.aplicacion.usecases.payment.CreatePaymentUseCase;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class PaymentController {

    private CreatePaymentUseCase createPaymentUseCase;

    @Autowired
    public PaymentController( CreatePaymentUseCase createPaymentUseCase) {
        this.createPaymentUseCase=createPaymentUseCase;
    }

    @RequestMapping(value = "/payment",method=RequestMethod.POST)
    public Boolean createPayment(@RequestBody PaymentCommand paymentCommand) {
        try {
            return this.createPaymentUseCase.execute(paymentCommand);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
