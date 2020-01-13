package com.ceiba.lendings.aplicacion.command;

import java.util.Date;

public class PaymentCommand {

    private Long id;
    private Double paymentvalue;
    private Date paymentdate;
    private LendingCommand lendingid;

    public PaymentCommand() {
    }

    public PaymentCommand(Long id, Double paymentvalue, Date paymentdate, LendingCommand lendingid) {
        this.id = id;
        this.paymentvalue = paymentvalue;
        this.paymentdate = (Date)paymentdate.clone();
        this.lendingid = lendingid;
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
        return (Date)paymentdate.clone();
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = (Date)paymentdate.clone();
    }

    public LendingCommand getLendingid() {
        return lendingid;
    }

    public void setLendingid(LendingCommand lendingid) {
        this.lendingid = lendingid;
    }

    @Override
    public String toString() {
        return "PaymentCommand{" +
                "id=" + id +
                ", paymentvalue=" + paymentvalue +
                ", paymentdate=" + paymentdate +
                ", lendingid=" + lendingid +
                '}';
    }
}
