package com.ceiba.lendings.dominio.entidades;

import java.util.Date;

public class Lending {

    private Integer id;
    private Date lending_return_date;
    private Integer lending_total_amount;
    private Integer lending_value;
    private Date lending_date;

    public Lending(Integer id, Date lending_return_date, Integer lending_total_amount, Integer lending_value, Date lending_date) {
        this.id = id;
        this.lending_return_date = lending_return_date;
        this.lending_total_amount = lending_total_amount;
        this.lending_value = lending_value;
        this.lending_date = lending_date;
    }
}
