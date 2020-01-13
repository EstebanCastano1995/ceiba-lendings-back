package com.ceiba.lendings.dominio.entidades;

import java.util.Date;
import com.ceiba.lendings.dominio.entidades.validators.PaymentValidator;

public class Payment {

    private static final String PAYMENT_VALUE_REQUIRED ="El valor del pago es requerido";
    private static final String PAYMENT_DATE_REQUIRED = "La fecha del pago es requerida";
    private static final String PAYMENT_LENDING_REQUIRED = "El prestamo del pago es requerido";

    private Integer id;
    private Double payment_value;
    private Date payment_date;
    private Lending lending_id;

    public Payment() {
    }

    public Payment(Integer id, Double payment_value, Date payment_date, Lending lending_id) {
        PaymentValidator.validateField(payment_date,PAYMENT_DATE_REQUIRED);
        PaymentValidator.validateField(payment_value,PAYMENT_VALUE_REQUIRED);
        PaymentValidator.validateField(lending_id,PAYMENT_LENDING_REQUIRED);

        this.id = id;
        this.payment_value = payment_value;
        this.payment_date = payment_date;
        this.lending_id=lending_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPayment_value() {
        return payment_value;
    }

    public void setPayment_value(Double payment_value) {
        this.payment_value = payment_value;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public Lending getLending_id() {
        return lending_id;
    }

    public void setLending_id(Lending lending_id) {
        this.lending_id = lending_id;
    }
}
