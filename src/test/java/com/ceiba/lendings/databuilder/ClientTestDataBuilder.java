package com.ceiba.lendings.databuilder;

import com.ceiba.lendings.dominio.entidades.Client;
import java.util.Date;

public class ClientTestDataBuilder {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private Date birthdate;

    public ClientTestDataBuilder() {
        this.id=(long)11111;
        this.name="Esteban Castaño";
        this.address="Calle 10 # 24-26 B/Corbones";
        this.phone="3137340927";
        this.birthdate=DateDataBuilder.build(1995,9,29);
    }

    public ClientTestDataBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ClientTestDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ClientTestDataBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public ClientTestDataBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ClientTestDataBuilder withBirthDate(Date birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public Client build() {
        return new Client(id, name, address, phone, birthdate);
    }
}
