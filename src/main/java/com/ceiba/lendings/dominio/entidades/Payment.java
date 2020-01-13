package com.ceiba.lendings.dominio.entidades;

import java.util.Date;
import com.ceiba.lendings.dominio.entidades.validators.PaymentValidator;

public class Payment {

    private static final String PAYMENTVALUEREQUIRED ="El valor del pago es requerido";
    private static final String PAYMENTDATEREQUIRED = "La fecha del pago es requerida";
    private static final String PAYMENTLENDINGREQUIRED = "El prestamo del pago es requerido";

    private Long id;
    private Double paymentvalue;
    private Date paymentdate;
    private Lending lendingid;

    public Payment() {
    }

    public Payment(Long idc, Double paymentvaluec, Date paymentdatec, Lending lendingidc) {
        PaymentValidator.validateField(paymentdatec,PAYMENTDATEREQUIRED);
        PaymentValidator.validateField(paymentvaluec,PAYMENTVALUEREQUIRED);
        PaymentValidator.validateField(lendingidc,PAYMENTLENDINGREQUIRED);

        this.id = idc;
        this.paymentvalue = paymentvaluec;
        this.paymentdate = (Date)paymentdatec.clone();
        this.lendingid=lendingidc;
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

    public Lending getLendingid() {
        return lendingid;
    }

    public void setLendingid(Lending lendingid) {
        this.lendingid = lendingid;
    }
}
