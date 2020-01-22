package com.ceiba.lendings.dominio.entidades.validators;

import com.ceiba.lendings.dominio.excepcion.LendingDateException;
import com.ceiba.lendings.dominio.excepcion.LendingValueException;
import com.ceiba.lendings.dominio.excepcion.RequiredFieldException;

import java.util.Calendar;
import java.util.Date;

public final class LendingValidator {

    private LendingValidator() {
        throw new UnsupportedOperationException();
    }

    public static final int MONTO_MAXIMO_PERMITIDO = 500000;
    public static final int MINIMUM_VALUE_ALLOWED = 100000;

    public static void validateField(Object value, String message) {
        if(value==null)
            throw new RequiredFieldException(message);
    }

    public static void validateLendingValue(Double value, String message) {
        if(value> MONTO_MAXIMO_PERMITIDO || value< MINIMUM_VALUE_ALLOWED)
            throw new LendingValueException(message);
    }

    public static void  validateLendingDate(Date lendingDate, String message) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(lendingDate);
            if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
                throw  new LendingDateException(message);
    }
}
