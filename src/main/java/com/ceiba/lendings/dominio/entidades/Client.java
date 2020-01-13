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
        ClientValidator.validateClientAge(birthdatec,CLIENTMUSTBEADULT);

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
