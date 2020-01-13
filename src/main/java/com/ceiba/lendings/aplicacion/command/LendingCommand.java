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

    public LendingCommand(Long id, Date lendingreturndate, Double lendingvalue, Double lendingtotalamount, Date lendingdate, ClientCommand clientid) {
        this.id = id;
        this.lendingreturndate = (Date)lendingreturndate.clone();
        this.lendingvalue = lendingvalue;
        this.lendingtotalamount = lendingtotalamount;
        this.lendingdate = (Date)lendingdate.clone();
        this.clientid = clientid;
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

    public ClientCommand getClientid() {
        return clientid;
    }

    public void setClientid(ClientCommand clientid) {
        this.clientid = clientid;
    }

    @Override
    public String toString() {
        return "LendingCommand{" +
                "id=" + id +
                ", lendingreturndate=" + lendingreturndate +
                ", lendingvalue=" + lendingvalue +
                ", lendingtotalamount=" + lendingtotalamount +
                ", lendingdate=" + lendingdate +
                ", clientid=" + clientid +
                '}';
    }
}
