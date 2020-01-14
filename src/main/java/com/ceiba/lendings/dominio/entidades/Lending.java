package com.ceiba.lendings.dominio.entidades;

import java.util.Date;
import com.ceiba.lendings.dominio.entidades.util.CalculateLendingTotalAmount;
import com.ceiba.lendings.dominio.entidades.validators.LendingValidator;

public class Lending {

    private static final String LENDINGRETURNDATEREQUIRED ="La fecha de terminación del prestamo es requerida";
    private static final String LENDINGVALUEREQUIRED ="El valor del prestamo es requerido";
    private static final String LENDINGDATEREQUIRED = "La fecha del prestamo es requerida";
    private static final String LENDINGCLIENTREQUIRED = "El cliente del prestamo es requerido";

    private static final String LENDINGLIMITVALUE = "El prestamo debe estar entre 100000 COP y 500000 COP";
    private static final String LENDINGDATERESTRICTION = "Los dias domingos no se hacen prestamos";

    private Long id;
    private Date lendingreturndate;
    private Double lendingvalue;
    private Double lendingtotalamount;
    private Date lendingdate;
    private Client clientid;

    public Lending() {
    }

    public Lending(Long id, Date lendingreturndate, Double lendingvalue, Date lendingdate, Client clientid) {
        LendingValidator.validateField(lendingreturndate,LENDINGRETURNDATEREQUIRED);
        LendingValidator.validateField(lendingvalue,LENDINGVALUEREQUIRED);
        LendingValidator.validateField(lendingdate,LENDINGDATEREQUIRED);
        LendingValidator.validateField(clientid,LENDINGCLIENTREQUIRED);

        LendingValidator.validateLendingValue(lendingvalue,LENDINGLIMITVALUE);
        LendingValidator.validateLendingDate(lendingdate,LENDINGDATERESTRICTION);

        this.lendingtotalamount= CalculateLendingTotalAmount.calculateLendingTotalAmount(lendingreturndate,lendingdate,lendingvalue);
        this.id = id;
        this.lendingreturndate = (Date)lendingreturndate.clone();
        this.lendingvalue = lendingvalue;
        this.lendingdate = (Date)lendingdate.clone();
        this.clientid=clientid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLendingreturndate() {
        return (Date)lendingreturndate.clone();
    }

    public void setLendingreturndate(Date lendingreturndate) {
        this.lendingreturndate = (Date)lendingreturndate.clone();
    }

    public Double getLendingvalue() {
        return lendingvalue;
    }

    public void setLendingvalue(Double lendingvalue) {
        this.lendingvalue = lendingvalue;
    }

    public Double getLendingtotalamount() {
        return lendingtotalamount;
    }

    public void setLendingtotalamount(Double lendingtotalamount) {
        this.lendingtotalamount = lendingtotalamount;
    }

    public Date getLendingdate() {
        return (Date)lendingdate.clone();
    }

    public void setLendingdate(Date lendingdate) {
        this.lendingdate = (Date)lendingdate.clone();
    }

    public Client getClientid() {
        return clientid;
    }

    public void setClientid(Client clientid) {
        this.clientid = clientid;
    }
}
