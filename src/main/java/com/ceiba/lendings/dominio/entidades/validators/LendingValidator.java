package com.ceiba.lendings.dominio.entidades.validators;

import com.ceiba.lendings.dominio.excepcion.LendingDateException;
import com.ceiba.lendings.dominio.excepcion.LendingValueException;
import com.ceiba.lendings.dominio.excepcion.RequiredFieldException;

import java.util.Calendar;
import java.util.Date;

public final class LendingValidator {

    private LendingValidator() {
    }

    public static void validateField(Object valor, String mensaje) {
        if(valor==null)
            throw new RequiredFieldException(mensaje);
    }

    public static void validateLendingValue(Double valor, String mensaje) {
        if(valor>500000 || valor<100000)
            throw new LendingValueException(mensaje);
    }

    public static void  validateLendingDate(Date lendingDate, String mensaje) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(lendingDate);
            if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
                throw  new LendingDateException(mensaje);
    }
}
