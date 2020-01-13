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

    @Column(name="birth_date")
    @Temporal(TemporalType.DATE)
    private Date birth_date;

    @OneToMany(mappedBy="client_id")
    private Set<LendingEntity> lending;

    public ClientEntity() {
    }

    public ClientEntity(Long id, String name, String address, String phone, Date birth_date) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.birth_date = (Date)birth_date.clone();
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

    public Date getBirth_date() {
        return (Date)birth_date.clone();
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = (Date)birth_date.clone();;
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
                ", birth_date=" + birth_date +
                ", lending=" + lending +
                '}';
    }
}
