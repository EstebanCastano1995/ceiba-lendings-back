package com.ceiba.lendings.infraestructura.entidades;

import javax.persistence.*;

import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="client")
public class ClientEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="phone")
    private String phone;

    @Column(name="birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @OneToMany(mappedBy="clientid")
    private Set<LendingEntity> lending;

    public ClientEntity() {
    }

    public ClientEntity(Long idc, String namec, String addressc, String phonec, Date birthdatec) {
        this.id = idc;
        this.name = namec;
        this.address = addressc;
        this.phone = phonec;
        this.birthdate = (Date)birthdatec.clone();
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

    public void setBirthdate(Date birthdate) {
        this.birthdate = (Date)birthdate.clone();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", birthdate=" + birthdate +
                ", lending=" + lending +
                '}';
    }
}
