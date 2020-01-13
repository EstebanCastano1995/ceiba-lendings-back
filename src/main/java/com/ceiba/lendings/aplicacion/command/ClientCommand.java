package com.ceiba.lendings.aplicacion.command;

import java.util.Date;

public class ClientCommand {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private Date birthdate;

    public ClientCommand(Long id, String name, String address, String phone, Date birthdate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.birthdate = (Date)birthdate.clone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String NAME) {
        this.name = NAME;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String ADDRESS) {
        this.address = ADDRESS;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String PHONE) {
        this.phone = PHONE;
    }

    public Date getBirthdate() {
        return (Date)birthdate.clone();
    }

    public void setBirthdate(Date BIRTHDATE) {
        this.birthdate = (Date)BIRTHDATE.clone();
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
