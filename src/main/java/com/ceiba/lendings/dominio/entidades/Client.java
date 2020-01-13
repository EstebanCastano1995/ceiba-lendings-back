package com.ceiba.lendings.dominio.entidades;

import java.util.Date;
import com.ceiba.lendings.dominio.entidades.validators.ClientValidator;

public class Client {

    private static final String CLIENTIDREQUIRED ="La identificación del cliente es requerida";
    private static final String CLIENTNAMEREQUIRED ="El nombre del cliente es requerido";
    private static final String CLIENTADDRESSREQUIRED = "La dirección del cliente es requerida ";
    private static final String CLIENTPHONEREQUIRED ="El telefono del cliente es requerido";
    private static final String CLIENTBIRTHDATEREQUIRED = "La fecha de nacimiento del cliente es requerida";
    private static final String CLIENTMUSTBEADULT = "El cliente debe tener minimo 18 años";

    private Long id;
    private String name;
    private String address;
    private String phone;
    private Date birthdate;

    public Client() {
    }

    public Client(Long idc, String namec, String addressc, String phonec, Date birthdatec) {
        ClientValidator.validateField(namec,CLIENTNAMEREQUIRED);
        ClientValidator.validateField(idc,CLIENTIDREQUIRED);
        ClientValidator.validateField(addressc,CLIENTADDRESSREQUIRED);
        ClientValidator.validateField(phonec,CLIENTPHONEREQUIRED);
        ClientValidator.validateField(birthdatec,CLIENTBIRTHDATEREQUIRED);
        ClientValidator.validateClientAge(birthdate,CLIENTMUSTBEADULT);

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
}
