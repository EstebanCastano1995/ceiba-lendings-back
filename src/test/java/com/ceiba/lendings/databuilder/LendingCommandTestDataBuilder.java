package com.ceiba.lendings.databuilder;

import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.aplicacion.command.LendingCommand;
import java.util.Date;

public class LendingCommandTestDataBuilder {

    private Long id;
    private Date lendingreturndate;
    private Double lendingvalue;
    private Double lendingtotalamount;
    private Date lendingdate;
    private ClientCommand clientid;

    public LendingCommandTestDataBuilder() {
        this.id=(long)1;
        this.lendingreturndate=new Date();
        this.lendingdate=new Date();
        this.lendingvalue=450000.0;
        this.lendingtotalamount=470000.0;
        this.clientid = new ClientCommandTestDataBuilder().build();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLendingreturndate() {
        return lendingreturndate;
    }

    public void setLendingreturndate(Date lendingreturndate) {
        this.lendingreturndate = lendingreturndate;
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
        return lendingdate;
    }

    public void setLendingdate(Date lendingdate) {
        this.lendingdate = lendingdate;
    }

    public ClientCommand getClientid() {
        return clientid;
    }

    public void setClientid(ClientCommand clientid) {
        this.clientid = clientid;
    }

    public LendingCommand build() {
        return new LendingCommand(id, lendingreturndate, lendingtotalamount, lendingvalue, lendingdate,clientid);
    }
}
