package com.ceiba.lendings.dominio.entidades.validators;

import com.ceiba.lendings.dominio.excepcion.RequiredFieldException;

public final class PaymentValidator {

    private PaymentValidator() {
    }

    public static void validateField(Object valor, String mensaje) {
        if(valor==null) {
            throw new RequiredFieldException(mensaje);
        }
    }
}
