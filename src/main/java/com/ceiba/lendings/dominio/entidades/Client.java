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
    private Date birth_date;

    public Client() {
    }

    public Client(Long id, String name, String address, String phone, Date birth_date) {
        ClientValidator.validateField(name,CLIENT_NAME_REQUIRED);
        ClientValidator.validateField(id,CLIENT_ID_REQUIRED);
        ClientValidator.validateField(address,CLIENT_ADDRESS_REQUIRED);
        ClientValidator.validateField(phone,CLIENT_PHONE_REQUIRED);
        ClientValidator.validateField(birth_date,CLIENT_BIRTH_DATE_REQUIRED);
        ClientValidator.validateClientAge(birth_date,CLIENT_MUST_BE_ADULT);

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
        this.birth_date = (Date)birth_date.clone();
    }
}
