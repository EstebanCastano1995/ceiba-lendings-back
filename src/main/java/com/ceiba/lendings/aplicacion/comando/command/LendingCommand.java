package com.ceiba.lendings.aplicacion.comando.command;

import java.util.Date;

public class LendingCommand {

    private Integer id;
    private Date lending_return_date;
    private Integer lending_total_amount;
    private Integer lending_value;
    private Date lending_date;

    public LendingCommand() {
    }

    public LendingCommand(Integer id, Date lending_return_date, Integer lending_total_amount, Integer lending_value, Date lending_date) {
        this.id = id;
        this.lending_return_date = lending_return_date;
        this.lending_total_amount = lending_total_amount;
        this.lending_value = lending_value;
        this.lending_date = lending_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLending_return_date() {
        return lending_return_date;
    }

    public void setLending_return_date(Date lending_return_date) {
        this.lending_return_date = lending_return_date;
    }

    public Integer getLending_total_amount() {
        return lending_total_amount;
    }

    public void setLending_total_amount(Integer lending_total_amount) {
        this.lending_total_amount = lending_total_amount;
    }

    public Integer getLending_value() {
        return lending_value;
    }

    public void setLending_value(Integer lending_value) {
        this.lending_value = lending_value;
    }

    public Date getLending_date() {
        return lending_date;
    }

    public void setLending_date(Date lending_date) {
        this.lending_date = lending_date;
    }

    @Override
    public String toString() {
        return "LendingCommand{" +
                "id=" + id +
                ", lending_return_date=" + lending_return_date +
                ", lending_total_amount=" + lending_total_amount +
                ", lending_value=" + lending_value +
                ", lending_date=" + lending_date +
                '}';
    }
}
