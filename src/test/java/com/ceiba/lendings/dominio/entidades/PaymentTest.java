package com.ceiba.lendings.dominio.entidades;

import com.ceiba.lendings.BasePrueba;
import com.ceiba.lendings.databuilder.PaymentTestDataBuilder;
import com.ceiba.lendings.dominio.excepcion.RequiredFieldException;
import org.junit.jupiter.api.Test;

public class PaymentTest {

    @Test
    public void validateLendingPayment() {
        PaymentTestDataBuilder builder = new PaymentTestDataBuilder();
        builder.withLendingId(null);
        BasePrueba.assertThrows(() -> builder.build(), RequiredFieldException.class, "El prestamo del pago es requerido");
    }

    @Test
    public void validatePaymentValue() {
        PaymentTestDataBuilder builder = new PaymentTestDataBuilder();
        builder.withPaymentValue(null);
        BasePrueba.assertThrows(() -> builder.build(), RequiredFieldException.class, "El valor del pago es requerido");
    }

    @Test
    public void validatePaymentDate() {
        PaymentTestDataBuilder builder = new PaymentTestDataBuilder();
        builder.withPaymentDate(null);
        BasePrueba.assertThrows(() -> builder.build(), RequiredFieldException.class, "La fecha del pago es requerida");
    }
}
