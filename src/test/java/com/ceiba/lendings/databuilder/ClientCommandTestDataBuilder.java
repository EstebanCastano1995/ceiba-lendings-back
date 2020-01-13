package com.ceiba.lendings.databuilder;

import com.ceiba.lendings.aplicacion.command.ClientCommand;

import java.util.Calendar;
import java.util.Date;

public class ClientCommandTestDataBuilder {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private Date birthdate;

    public ClientCommandTestDataBuilder() {
        Calendar c = Calendar.getInstance();
        c.set(1995, 9, 29, 0, 0);
        this.id=(long)11111;
        this.name="Esteban Castaño";
        this.address="Calle 10 # 24-26 B/Corbones";
        this.phone="3137340927";
        this.birthdate=c.getTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public ClientCommand build() {
        return new ClientCommand(id,name,address,phone,birthdate);
    }

}
