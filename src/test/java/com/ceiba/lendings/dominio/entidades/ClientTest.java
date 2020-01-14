package com.ceiba.lendings.dominio.entidades;

import com.ceiba.lendings.BaseTest;
import com.ceiba.lendings.databuilder.ClientTestDataBuilder;
import com.ceiba.lendings.databuilder.DateDataBuilder;
import com.ceiba.lendings.dominio.excepcion.ClientMustBeAdultException;
import com.ceiba.lendings.dominio.excepcion.RequiredFieldException;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class ClientTest {

    @Test
    public void validateClientId() {
        ClientTestDataBuilder builder = new ClientTestDataBuilder();
        builder.withId(null);
        BaseTest.assertThrows(() -> builder.build(), RequiredFieldException.class, "La identificación del cliente es requerida");
    }

    @Test
    public void validateClientName() {
        ClientTestDataBuilder builder = new ClientTestDataBuilder();
        builder.withName(null);
        BaseTest.assertThrows(() -> builder.build(), RequiredFieldException.class, "El nombre del cliente es requerido");
    }

    @Test
    public void validateClientAddress() {
        ClientTestDataBuilder builder = new ClientTestDataBuilder();
        builder.withAddress(null);
        BaseTest.assertThrows(() -> builder.build(), RequiredFieldException.class, "La dirección del cliente es requerida ");
    }

    @Test
    public void validateClientPhone() {
        ClientTestDataBuilder builder = new ClientTestDataBuilder();
        builder.withPhone(null);
        BaseTest.assertThrows(() -> builder.build(), RequiredFieldException.class, "El telefono del cliente es requerido");
    }

    @Test
    public void validateBirthDate() {
        ClientTestDataBuilder builder = new ClientTestDataBuilder();
        builder.withBirthDate(null);
        BaseTest.assertThrows(() -> builder.build(), RequiredFieldException.class, "La fecha de nacimiento del cliente es requerida");
    }

    @Test
    public void validateBirthDateNotAdult() {
        ClientTestDataBuilder builder = new ClientTestDataBuilder();
        builder.withBirthDate(new Date());
        BaseTest.assertThrows(() -> builder.build(), ClientMustBeAdultException.class, "El cliente debe tener minimo 18 años");
    }

    @Test
    public void validateBirthDateAdult() {
        ClientTestDataBuilder builder = new ClientTestDataBuilder();
        builder.withBirthDate(DateDataBuilder.build(1995,9,29));
        builder.build();
    }

}
