package com.ceiba.lendings.databuilder;

import com.ceiba.lendings.dominio.entidades.Client;
import com.ceiba.lendings.dominio.entidades.Lending;
import java.util.Date;

public class LendingTestDataBuilder {

    private Long id;
    private Date lendingreturndate;
    private Double lendingvalue;
    private Double lendingtotalamount;
    private Date lendingdate;
    private Client clientid;

    public LendingTestDataBuilder() {
        this.id=(long)1;
        this.lendingreturndate=new Date();
        this.lendingdate=new Date();
        this.lendingvalue=450000.0;
        this.lendingtotalamount=470000.0;
        this.clientid = new ClientTestDataBuilder().build();
    }

    public LendingTestDataBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public LendingTestDataBuilder withReturnDate(Date lendingreturndate) {
        this.lendingreturndate = lendingreturndate;
        return this;
    }

    public LendingTestDataBuilder withlendingDate(Date lendingDate) {
        this.lendingdate = lendingDate;
        return this;
    }

    public LendingTestDataBuilder withLendingValue(Double lendingValue) {
        this.lendingvalue = lendingValue;
        return this;
    }

    public LendingTestDataBuilder withLendingTotalAmount(Double totalAmount) {
        this.lendingtotalamount = totalAmount;
        return this;
    }

    public LendingTestDataBuilder clientId(Client client) {
        this.clientid = clientid;
        return this;
    }

    public Lending build() {
        return new Lending(id,lendingreturndate,lendingvalue,lendingdate,clientid);
    }
}
