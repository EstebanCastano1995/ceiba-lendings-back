package com.ceiba.lendings.aplicacion.command;

import java.util.Date;

public class ClientCommand {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private Date birthdate;

    public ClientCommand() {
    }

    public ClientCommand(Long id, String name, String address, String phone, Date birth_date) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.birthdate = (Date)birth_date.clone();
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
        return (Date)birthdate.clone();
    }

    public void setBirthdate(Date birth_date) {
        this.birthdate = (Date)birth_date.clone();
    }

    @Override
    public String toString() {
        return "ClientCommand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
