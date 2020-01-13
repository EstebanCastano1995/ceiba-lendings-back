package com.ceiba.lendings.dominio.entidades;

import java.util.Date;
import com.ceiba.lendings.dominio.entidades.util.CalculateLendingTotalAmount;
import com.ceiba.lendings.dominio.entidades.validators.LendingValidator;

public class Lending {

    private static final String LENDING_RETURN_DATE_REQUIRED ="La fecha de terminación del prestamo es requerida";
    private static final String LENDING_VALUE_REQUIRED ="El valor del prestamo es requerido";
    private static final String LENDING_DATE_REQUIRED = "La fecha del prestamo es requerida";
    private static final String LENDING_CLIENT_REQUIRED = "El cliente del prestamo es requerido";

    private static final String LENDING_LIMIT_VALUE = "El prestamo debe estar entre 100000 COP y 500000 COP";
    private static final String LENDING_DATE_RESTRICTION = "Los dias domingos no se hacen prestamos";

    private Long id;
    private Double lending_total_amount;
    private Date lending_return_date;
    private Double lending_value;
    private Date lending_date;
    private Client client_id;

    public Lending() {
    }

    public Lending(Long id, Date lending_return_date, Double lending_value, Date lending_date, Client cliend_id) {
        LendingValidator.validateField(lending_return_date,LENDING_RETURN_DATE_REQUIRED);
        LendingValidator.validateField(lending_value,LENDING_VALUE_REQUIRED);
        LendingValidator.validateField(lending_date,LENDING_DATE_REQUIRED);
        LendingValidator.validateField(cliend_id,LENDING_CLIENT_REQUIRED);

        LendingValidator.validateLendingValue(lending_value,LENDING_LIMIT_VALUE);
        LendingValidator.validateLendingDate(lending_date,LENDING_DATE_RESTRICTION);

        this.lending_total_amount= CalculateLendingTotalAmount.calculateLendingTotalAmount(lending_return_date,lending_date,lending_value);
        this.id = id;
        this.lending_return_date = (Date)lending_return_date.clone();
        this.lending_value = lending_value;
        this.lending_date = (Date)lending_date.clone();
        this.client_id=cliend_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLending_total_amount() {
        return lending_total_amount;
    }

    public void setLending_total_amount(Double lending_total_amount) {
        this.lending_total_amount = lending_total_amount;
    }

    public Date getLending_return_date() {
        return (Date)lending_return_date.clone();
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
        return (Date)lending_date.clone();
    }

    public void setLending_date(Date lending_date) {
        this.lending_date = lending_date;
    }

    public Client getClient_id() {
        return client_id;
    }

    public void setClient_id(Client client_id) {
        this.client_id = client_id;
    }
}
