package com.ceiba.lendings.dominio.entidades;

import com.ceiba.lendings.BasePrueba;
import com.ceiba.lendings.databuilder.LendingTestDataBuilder;
import com.ceiba.lendings.dominio.excepcion.LendingValueException;
import org.junit.jupiter.api.Test;

public class LendingTest {

    @Test
    public void validateLendingValue() {
        LendingTestDataBuilder builder = new LendingTestDataBuilder();
        builder.withLendingValue(32500.0);
        BasePrueba.assertThrows(() -> builder.build(), LendingValueException.class, "El prestamo debe estar entre 100000 COP y 500000 COP");
    }
}
