package com.ceiba.lendings.aplicacion.command;

import java.util.Date;

public class PaymentCommand {

    private Long id;
    private Double paymentvalue;
    private Date paymentdate;
    private LendingCommand lendingid;

    public PaymentCommand(Long idc, Double paymentvaluec, Date paymentdatec, LendingCommand lendingidc) {
        this.id = idc;
        this.paymentvalue = paymentvaluec;
        this.paymentdate = (Date)paymentdatec.clone();
        this.lendingid = lendingidc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long ids) {
        this.id = ids;
    }

    public Double getPaymentvalue() {
        return paymentvalue;
    }

    public void setPaymentvalue(Double paymentvalues) {
        this.paymentvalue = paymentvalues;
    }

    public Date getPaymentdate() {
        return (Date)paymentdate.clone();
    }

    public void setPaymentdate(Date paymentdates) {
        this.paymentdate = (Date)paymentdates.clone();
    }

    public LendingCommand getLendingid() {
        return lendingid;
    }

    public void setLendingid(LendingCommand lendingids) {
        this.lendingid = lendingids;
    }
}
