package com.ceiba.lendings.databuilder;

import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.aplicacion.command.PaymentCommand;
import java.util.Date;

public class PaymentCommandDataBuilder {

    private Long id;
    private Double paymentvalue;
    private Date paymentdate;
    private LendingCommand lendingid;

    public PaymentCommandDataBuilder() {
        this.id=(long)1;
        this.paymentdate=new Date();
        this.paymentvalue=25480.0;
        this.lendingid=new LendingCommandTestDataBuilder().build();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPaymentvalue() {
        return paymentvalue;
    }

    public void setPaymentvalue(Double paymentvalue) {
        this.paymentvalue = paymentvalue;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    public LendingCommand getLendingid() {
        return lendingid;
    }

    public void setLendingid(LendingCommand lendingid) {
        this.lendingid = lendingid;
    }

    public PaymentCommand build() {
        return new PaymentCommand(id, paymentvalue, paymentdate, lendingid);
    }
}
