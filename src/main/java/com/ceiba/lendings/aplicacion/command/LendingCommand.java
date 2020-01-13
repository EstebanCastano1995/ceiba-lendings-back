package com.ceiba.lendings.aplicacion.command;

import java.util.Date;

public class LendingCommand {

    private Long id;
    private Date lendingreturndate;
    private Double lendingvalue;
    private Double lendingtotalamount;
    private Date lendingdate;
    private ClientCommand clientid;

    public LendingCommand() {
    }

    public LendingCommand(Long idc, Date lendingreturndatec, Double lendingvaluec, Double lendingtotalamountc, Date lendingdatec, ClientCommand clientidc) {
        this.id = idc;
        this.lendingreturndate = (Date)lendingreturndatec.clone();
        this.lendingvalue = lendingvaluec;
        this.lendingtotalamount = lendingtotalamountc;
        this.lendingdate = (Date)lendingdatec.clone();
        this.clientid = clientidc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long ids) {
        this.id = ids;
    }

    public Date getLendingreturndate() {
        return (Date)lendingreturndate.clone();
    }

    public void setLendingreturndate(Date lendingreturndates) {
        this.lendingreturndate = (Date)lendingreturndates.clone();
    }

    public Double getLendingvalue() {
        return lendingvalue;
    }

    public void setLendingvalue(Double lendingvalues) {
        this.lendingvalue = lendingvalues;
    }

    public Double getLendingtotalamount() {
        return lendingtotalamount;
    }

    public void setLendingtotalamount(Double lendingtotalamounts) {
        this.lendingtotalamount = lendingtotalamounts;
    }

    public Date getLendingdate() {
        return (Date)lendingdate.clone();
    }

    public void setLendingdate(Date lendingdates) {
        this.lendingdate = (Date)lendingdates.clone();
    }

    public ClientCommand getClientid() {
        return clientid;
    }

    public void setClientid(ClientCommand clientids) {
        this.clientid = clientids;
    }
}
