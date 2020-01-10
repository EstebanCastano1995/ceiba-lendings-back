package com.ceiba.lendings.infraestructura.controller;

import com.ceiba.lendings.aplicacion.command.PaymentCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    public PaymentController( ) {
    }

    @RequestMapping(value = "/payment")
    public String createPayment(@RequestBody PaymentCommand paymentCommand) {
        return "you want to create a payment";
    }
}
