package com.ceiba.lendings.dominio.entidades.validators;

import com.ceiba.lendings.dominio.excepcion.ClientMustBeAdultException;
import com.ceiba.lendings.dominio.excepcion.RequiredFieldException;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public final class ClientValidator {

    private ClientValidator() {
        throw new UnsupportedOperationException();
    }

    public static void validateField(Object value, String message) {
        if(value==null)
            throw new RequiredFieldException(message);
    }

        public static void validateClientAge(Date birthDate, String message) {
            LocalDate currentDate=LocalDate.now();
            if(Period.between(convertToLocalDate(birthDate), currentDate).getYears()<18)
                throw new ClientMustBeAdultException(message);
        }

        private  static LocalDate convertToLocalDate(Date dateToConvert) {
            return Instant.ofEpochMilli(dateToConvert.getTime())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        }
}
