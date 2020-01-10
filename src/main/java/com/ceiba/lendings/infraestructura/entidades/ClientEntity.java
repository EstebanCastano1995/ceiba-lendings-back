package com.ceiba.lendings.infraestructura.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="client")
public class ClientEntity {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="phone")
    private String phone;

    @Column(name="birth_date")
    @Temporal(TemporalType.DATE)
    private Date birth_date;

    public ClientEntity() {
    }

    public ClientEntity(Integer id, String name, String address, String phone, Date birth_date) {
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
}
