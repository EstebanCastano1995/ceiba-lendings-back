package com.ceiba.lendings.dominio.entidades;

import java.util.Date;

public class Client {

    private Integer id;
    private String name;
    private String address;
    private String phone;
    private Date birth_date;

    public Client(Integer id, String name, String address, String phone, Date birth_date) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.birth_date = birth_date;
    }
}
