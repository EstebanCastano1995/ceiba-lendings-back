package com.ceiba.lendings.infraestructura.controller;

import com.ceiba.lendings.aplicacion.command.PaymentCommand;
import com.ceiba.lendings.aplicacion.excepcion.UseCaseException;
import com.ceiba.lendings.aplicacion.usecases.payment.CreatePaymentUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class PaymentController {

    private static final Logger LOGGER = Logger.getLogger(PaymentController.class.getName());

    private CreatePaymentUseCase createPaymentUseCase;

    @Autowired
    public PaymentController( CreatePaymentUseCase createPaymentUseCase) {
        this.createPaymentUseCase=createPaymentUseCase;
    }

    @RequestMapping(value = "/payment",method=RequestMethod.POST)
    public ResponseEntity<Boolean> createPayment(@RequestBody PaymentCommand paymentCommand) {
        try {
             Boolean result=this.createPaymentUseCase.execute(paymentCommand);
             return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (UseCaseException e) {
            LOGGER.log(Level.INFO,"Exception saving payments",e);
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
