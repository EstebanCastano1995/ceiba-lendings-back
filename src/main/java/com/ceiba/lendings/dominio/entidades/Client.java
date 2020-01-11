package com.ceiba.lendings.dominio.entidades;

import java.util.Date;
import com.ceiba.lendings.dominio.entidades.validators.ClientValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Client {

    private static final String CLIENT_ID_REQUIRED ="La identificación del cliente es requerida";
    private static final String CLIENT_NAME_REQUIRED ="El nombre del cliente es requerido";
    private static final String CLIENT_ADDRESS_REQUIRED = "La dirección del cliente es requerida ";
    private static final String CLIENT_PHONE_REQUIRED ="El telefono del cliente es requerido";
    private static final String CLIENT_BIRTH_DATE_REQUIRED = "La fecha de nacimiento del cliente es requerida";
    private static final String CLIENT_MUST_BE_ADULT = "El cliente debe tener minimo 18 años";

    private Integer id;
    private String name;
    private String address;
    private String phone;
    private Date birth_date;

    public Client(Integer id, String name, String address, String phone, Date birth_date) {
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
        this.birth_date = birth_date;
    }
}
