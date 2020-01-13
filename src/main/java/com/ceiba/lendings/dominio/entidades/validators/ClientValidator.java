package com.ceiba.lendings.dominio.entidades.validators;

import com.ceiba.lendings.dominio.excepcion.ClientMustBeAdultException;
import com.ceiba.lendings.dominio.excepcion.RequiredFieldException;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class ClientValidator {

    public static void validateField(Object valor, String mensaje) {
        if(valor==null)
            throw new RequiredFieldException(mensaje);
    }

        public static void validateClientAge(Date birthDate, String mensaje) {
            LocalDate currentDate=LocalDate.now();
            if(Period.between(convertToLocalDate(birthDate), currentDate).getYears()<18)
                throw new ClientMustBeAdultException(mensaje);
        }

        private  static LocalDate convertToLocalDate(Date dateToConvert) {
            return Instant.ofEpochMilli(dateToConvert.getTime())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        }
}
