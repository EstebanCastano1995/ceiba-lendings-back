package com.ceiba.lendings.dominio.entidades;

import com.ceiba.lendings.BasePrueba;
import com.ceiba.lendings.databuilder.ClientTestDataBuilder;
import com.ceiba.lendings.dominio.excepcion.ClientMustBeAdultException;
import com.ceiba.lendings.dominio.excepcion.RequiredFieldException;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class ClientTest {

    @Test
    public void validateBirthDate() {
        ClientTestDataBuilder builder = new ClientTestDataBuilder();
        builder.withBirthDate(new Date());
        BasePrueba.assertThrows(() -> builder.build(), ClientMustBeAdultException.class, "El cliente debe tener minimo 18 años");
    }

    @Test
    public void validateClientId() {
        ClientTestDataBuilder builder = new ClientTestDataBuilder();
        builder.withId(null);
        BasePrueba.assertThrows(() -> builder.build(), RequiredFieldException.class, "La identificación del cliente es requerida");
    }

}
