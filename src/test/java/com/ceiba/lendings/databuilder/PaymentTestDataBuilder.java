package com.ceiba.lendings.databuilder;

import com.ceiba.lendings.dominio.entidades.Lending;
import com.ceiba.lendings.dominio.entidades.Payment;
import java.util.Date;

public class PaymentTestDataBuilder {

    private Long id;
    private Double paymentvalue;
    private Date paymentdate;
    private Lending lendingid;

    public PaymentTestDataBuilder() {
        this.id=(long)1;
        this.paymentdate=new Date();
        this.paymentvalue=25480.0;
        this.lendingid=new LendingTestDataBuilder().build();
    }

    public PaymentTestDataBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public PaymentTestDataBuilder withPaymentDate(Date paymentDate) {
        this.paymentdate = paymentDate;
        return this;
    }

    public PaymentTestDataBuilder withPaymentValue(Double paymentValue) {
        this.paymentvalue = paymentValue;
        return this;
    }

    public PaymentTestDataBuilder withLendingId(Lending lendingCommand) {
        this.lendingid = lendingCommand;
        return this;
    }

    public Payment build() {
        return new Payment(id, paymentvalue, paymentdate, lendingid);
    }
}
