package com.ceiba.lendings.dominio.entidades;

import com.ceiba.lendings.BasePrueba;
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
        BasePrueba.assertThrows(() -> builder.build(), RequiredFieldException.class, "La identificación del cliente es requerida");
    }

    @Test
    public void validateClientName() {
        ClientTestDataBuilder builder = new ClientTestDataBuilder();
        builder.withName(null);
        BasePrueba.assertThrows(() -> builder.build(), RequiredFieldException.class, "El nombre del cliente es requerido");
    }

    @Test
    public void validateClientAddress() {
        ClientTestDataBuilder builder = new ClientTestDataBuilder();
        builder.withAddress(null);
        BasePrueba.assertThrows(() -> builder.build(), RequiredFieldException.class, "La dirección del cliente es requerida ");
    }

    @Test
    public void validateClientPhone() {
        ClientTestDataBuilder builder = new ClientTestDataBuilder();
        builder.withPhone(null);
        BasePrueba.assertThrows(() -> builder.build(), RequiredFieldException.class, "El telefono del cliente es requerido");
    }

    @Test
    public void validateBirthDate() {
        ClientTestDataBuilder builder = new ClientTestDataBuilder();
        builder.withBirthDate(null);
        BasePrueba.assertThrows(() -> builder.build(), RequiredFieldException.class, "La fecha de nacimiento del cliente es requerida");
    }

    @Test
    public void validateBirthDateNotAdult() {
        ClientTestDataBuilder builder = new ClientTestDataBuilder();
        builder.withBirthDate(new Date());
        BasePrueba.assertThrows(() -> builder.build(), ClientMustBeAdultException.class, "El cliente debe tener minimo 18 años");
    }

    @Test
    public void validateBirthDateAdult() {
        ClientTestDataBuilder builder = new ClientTestDataBuilder();
        builder.withBirthDate(DateDataBuilder.build(1995,9,29));
        BasePrueba.assertCorrect(builder.build().getBirthdate().toString(),DateDataBuilder.build(1995,9,29).toString());
    }

}
