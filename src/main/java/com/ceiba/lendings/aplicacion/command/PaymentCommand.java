package com.ceiba.lendings.aplicacion.command;

import java.util.Date;

public class PaymentCommand {

    private Long id;
    private Double payment_value;
    private Date payment_date;
    private LendingCommand lending_id;

    public PaymentCommand() {
    }

    public PaymentCommand(Long id, Double payment_value, Date payment_date, LendingCommand lending_id) {
        this.id = id;
        this.payment_value = payment_value;
        this.payment_date = (Date)payment_date.clone();
        this.lending_id=lending_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPayment_value() {
        return payment_value;
    }

    public void setPayment_value(Double payment_value) {
        this.payment_value = payment_value;
    }

    public Date getPayment_date() {
        return (Date)payment_date.clone();
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public LendingCommand getLending_id() {
        return lending_id;
    }

    public void setLending_id(LendingCommand lending_id) {
        this.lending_id = lending_id;
    }

    @Override
    public String toString() {
        return "PaymentCommand{" +
                "id=" + id +
                ", payment_value=" + payment_value +
                ", payment_date=" + payment_date +
                ", lending_id=" + lending_id +
                '}';
    }
}
