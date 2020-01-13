package com.ceiba.lendings.aplicacion.command;

import java.util.Date;

public class ClientCommand {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private Date birthdate;

    public ClientCommand(Long idc, String namec, String addressc, String phonec, Date birthdatec) {
        this.id = idc;
        this.name = namec;
        this.address = addressc;
        this.phone = phonec;
        this.birthdate = (Date)birthdatec.clone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long ids) {
        this.id = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String names) {
        this.name = names;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String addresss) {
        this.address = addresss;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phones) {
        this.phone = phones;
    }

    public Date getBirthdate() {
        return (Date)birthdate.clone();
    }

    public void setBirthdate(Date birthdates) {
        this.birthdate = (Date)birthdates.clone();
    }
}
