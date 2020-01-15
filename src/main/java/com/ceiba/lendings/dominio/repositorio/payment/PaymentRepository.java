package com.ceiba.lendings.dominio.repositorio.payment;

import com.ceiba.lendings.dominio.entidades.Payment;

public interface PaymentRepository {
    /**
     *  Método para crear un pago a un prestamo
     * @param payment , pago de un prestamo
     */
    void createPayment(Payment payment);

    /**
     *  Método para saber si un prestamo existe
     * @param payment , pago con el prestamo a buscar
     */
    Boolean checkIfLendingExist(Payment payment);
}
