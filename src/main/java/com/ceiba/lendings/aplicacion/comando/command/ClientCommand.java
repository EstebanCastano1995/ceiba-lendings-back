package com.ceiba.lendings.aplicacion.comando.command;

import java.util.Date;

public class ClientCommand {

    private Integer id;
    private String name;
    private String address;
    private String phone;
    private Date birth_date;

    public ClientCommand() {
    }

    public ClientCommand(Integer id, String name, String address, String phone, Date birth_date) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.birth_date = birth_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    @Override
    public String toString() {
        return "ClientCommand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", birth_date=" + birth_date +
                '}';
    }
}
