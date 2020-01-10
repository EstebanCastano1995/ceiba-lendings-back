package com.ceiba.lendings.aplicacion.comando.command;

import java.util.Date;

public class PaymentCommand {

    private Integer id;
    private Integer payment_value;
    private Date payment_date;

    public PaymentCommand() {
    }

    public PaymentCommand(Integer id, Integer payment_value, Date payment_date) {
        this.id = id;
        this.payment_value = payment_value;
        this.payment_date = payment_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPayment_value() {
        return payment_value;
    }

    public void setPayment_value(Integer payment_value) {
        this.payment_value = payment_value;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    @Override
    public String toString() {
        return "PaymentCommand{" +
                "id=" + id +
                ", payment_value=" + payment_value +
                ", payment_date=" + payment_date +
                '}';
    }
}
