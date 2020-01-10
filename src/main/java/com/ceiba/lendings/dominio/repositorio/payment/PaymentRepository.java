package com.ceiba.lendings.dominio.repositorio.payment;

import com.ceiba.lendings.dominio.entidades.Payment;

public interface PaymentRepository {
    Boolean createPayment(Payment payment);
}
