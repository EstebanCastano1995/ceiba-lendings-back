package com.ceiba.lendings.dominio.entidades;

import java.util.Date;

public class Payment {

    private Integer id;
    private Integer payment_value;
    private Date payment_date;

    public Payment(Integer id, Integer payment_value, Date payment_date) {
        this.id = id;
        this.payment_value = payment_value;
        this.payment_date = payment_date;
    }
}
