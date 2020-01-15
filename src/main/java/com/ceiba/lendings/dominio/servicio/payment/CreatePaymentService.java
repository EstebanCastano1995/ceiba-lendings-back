package com.ceiba.lendings.dominio.servicio.payment;

import com.ceiba.lendings.dominio.entidades.Payment;
import com.ceiba.lendings.dominio.excepcion.LendingMustBeCreatedException;
import com.ceiba.lendings.dominio.repositorio.payment.PaymentRepository;

public class CreatePaymentService {

    private static final String LENDING_DOES_NOT_EXIST = "El pago que desea registrar no tiene un prestamo asociado registrado";

    private PaymentRepository paymentRepository;

    public CreatePaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository=paymentRepository;
    }

    public void createPayment(Payment payment) {
        checkIfLendingExists(payment);
        paymentRepository.createPayment(payment);
    }

    private void checkIfLendingExists(Payment payment){
        if(!paymentRepository.checkIfLendingExist(payment))
            throw new LendingMustBeCreatedException(LENDING_DOES_NOT_EXIST);
    }
}
