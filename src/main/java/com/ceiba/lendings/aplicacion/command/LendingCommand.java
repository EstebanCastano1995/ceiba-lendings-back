package com.ceiba.lendings.aplicacion.command;

import java.util.Date;

public class LendingCommand {

    private Long id;
    private Date lending_return_date;
    private Double lending_value;
    private Double lending_total_amount;
    private Date lending_date;
    private ClientCommand client_id;

    public LendingCommand() {
    }

    public LendingCommand(Long id, Date lending_return_date, Double lending_value, Date lending_date,ClientCommand client_id) {
        this.id = id;
        this.lending_return_date = lending_return_date;
        this.lending_value = lending_value;
        this.lending_date = lending_date;
        this.client_id=client_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLending_return_date() {
        return lending_return_date;
    }

    public void setLending_return_date(Date lending_return_date) {
        this.lending_return_date = lending_return_date;
    }

    public Double getLending_value() {
        return lending_value;
    }

    public void setLending_value(Double lending_value) {
        this.lending_value = lending_value;
    }

    public Date getLending_date() {
        return lending_date;
    }

    public void setLending_date(Date lending_date) {
        this.lending_date = lending_date;
    }

    public ClientCommand getClient_id() {
        return client_id;
    }

    public void setClient_id(ClientCommand client_id) {
        this.client_id = client_id;
    }

    public Double getLending_total_amount() {
        return lending_total_amount;
    }

    public void setLending_total_amount(Double lending_total_amount) {
        this.lending_total_amount = lending_total_amount;
    }

    @Override
    public String toString() {
        return "LendingCommand{" +
                "id=" + id +
                ", lending_return_date=" + lending_return_date +
                ", lending_value=" + lending_value +
                ", lending_total_amount=" + lending_total_amount +
                ", lending_date=" + lending_date +
                ", client_id=" + client_id +
                '}';
    }
}
