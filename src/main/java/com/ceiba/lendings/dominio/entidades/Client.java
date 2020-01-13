package com.ceiba.lendings.dominio.entidades;

import java.util.Date;
import com.ceiba.lendings.dominio.entidades.validators.ClientValidator;

public class Client {

    private static final String CLIENT_ID_REQUIRED ="La identificación del cliente es requerida";
    private static final String CLIENT_NAME_REQUIRED ="El nombre del cliente es requerido";
    private static final String CLIENT_ADDRESS_REQUIRED = "La dirección del cliente es requerida ";
    private static final String CLIENT_PHONE_REQUIRED ="El telefono del cliente es requerido";
    private static final String CLIENT_BIRTH_DATE_REQUIRED = "La fecha de nacimiento del cliente es requerida";
    private static final String CLIENT_MUST_BE_ADULT = "El cliente debe tener minimo 18 años";

    private Long id;
    private String name;
    private String address;
    private String phone;
    private Date birthdate;

    public Client() {
    }

    public Client(Long id, String name, String address, String phone, Date birthdate) {
        ClientValidator.validateField(name,CLIENT_NAME_REQUIRED);
        ClientValidator.validateField(id,CLIENT_ID_REQUIRED);
        ClientValidator.validateField(address,CLIENT_ADDRESS_REQUIRED);
        ClientValidator.validateField(phone,CLIENT_PHONE_REQUIRED);
        ClientValidator.validateField(birthdate,CLIENT_BIRTH_DATE_REQUIRED);
        ClientValidator.validateClientAge(birthdate,CLIENT_MUST_BE_ADULT);

        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.birthdate = (Date)birthdate.clone();
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
