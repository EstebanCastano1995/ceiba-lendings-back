package com.ceiba.lendings.dominio.entidades.validators;

import com.ceiba.lendings.dominio.excepcion.RequiredFieldException;

public final class PaymentValidator {

    private PaymentValidator() {
        throw new UnsupportedOperationException();
    }

    public static void validateField(Object value, String message) {
        if(value==null) {
            throw new RequiredFieldException(message);
        }
    }
}
