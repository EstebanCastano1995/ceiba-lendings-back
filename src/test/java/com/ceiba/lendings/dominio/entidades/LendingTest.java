package com.ceiba.lendings.dominio.entidades;

import com.ceiba.lendings.BasePrueba;
import com.ceiba.lendings.databuilder.DateDataBuilder;
import com.ceiba.lendings.databuilder.LendingTestDataBuilder;
import com.ceiba.lendings.dominio.excepcion.LendingDateException;
import com.ceiba.lendings.dominio.excepcion.LendingValueException;
import com.ceiba.lendings.dominio.excepcion.RequiredFieldException;
import org.junit.jupiter.api.Test;

public class LendingTest {

    @Test
    public void validateLendingDateBetweenWeekAndCorrectValue() {
        LendingTestDataBuilder builder = new LendingTestDataBuilder();
        builder.withlendingDate(DateDataBuilder.build(2020,1,1));
        builder.withLendingReturnDate(DateDataBuilder.build(2020,2,1));
        builder.withLendingValue(185000.0);
        BasePrueba.assertCorrect(builder.build().getLendingtotalamount(),188755.5);
    }

    @Test
    public void validateLendingDateOnSaturdayAndCorrectValue() {
        LendingTestDataBuilder builder = new LendingTestDataBuilder();
        builder.withlendingDate(DateDataBuilder.build(2020,1,18));
        builder.withLendingReturnDate(DateDataBuilder.build(2020,2,18));
        builder.withLendingValue(200000.0);
        BasePrueba.assertCorrect(builder.build().getLendingtotalamount(),204060.0);
    }

    @Test
    public void validateLendingDateBetweenWeekNotCorrectValue() {
        LendingTestDataBuilder builder = new LendingTestDataBuilder();
        builder.withLendingValue(32500.0);
        BasePrueba.assertThrows(() -> builder.build(), LendingValueException.class, "El prestamo debe estar entre 100000 COP y 500000 COP");
    }

    @Test
    public void validateLendingDateOnSunday() {
        LendingTestDataBuilder builder = new LendingTestDataBuilder();
        builder.withlendingDate(DateDataBuilder.build(2020,0,19));
        BasePrueba.assertThrows(() -> builder.build(), LendingDateException.class, "Los dias domingos no se hacen prestamos");
    }

    @Test
    public void validateLendingReturnDate() {
        LendingTestDataBuilder builder = new LendingTestDataBuilder();
        builder.withLendingReturnDate(null);
        BasePrueba.assertThrows(() -> builder.build(), RequiredFieldException.class, "La fecha de terminación del prestamo es requerida");
    }

    @Test
    public void validateLendingDate() {
        LendingTestDataBuilder builder = new LendingTestDataBuilder();
        builder.withlendingDate(null);
        BasePrueba.assertThrows(() -> builder.build(), RequiredFieldException.class, "La fecha del prestamo es requerida");
    }

    @Test
    public void validateLendingValue() {
        LendingTestDataBuilder builder = new LendingTestDataBuilder();
        builder.withLendingValue(null);
        BasePrueba.assertThrows(() -> builder.build(), RequiredFieldException.class, "El valor del prestamo es requerido");
    }
}
