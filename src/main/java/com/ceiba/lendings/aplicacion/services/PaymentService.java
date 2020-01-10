package com.ceiba.lendings.aplicacion.services;

import com.ceiba.lendings.dominio.entidades.Payment;

public interface PaymentService {
    Boolean createPayment(Payment payment);
}
