package com.ceiba.lendings.dominio.entidades;

import java.util.Date;
import com.ceiba.lendings.dominio.entidades.validators.PaymentValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Payment {

    private static final String PAYMENTVALUEREQUIRED ="El valor del pago es requerido";
    private static final String PAYMENTDATEREQUIRED = "La fecha del pago es requerida";
    private static final String PAYMENTLENDINGREQUIRED = "El prestamo del pago es requerido";

    private Long id;
    private Double paymentvalue;
    private Date paymentdate;
    private Lending lendingid;

    public Payment(Long idc, Double paymentvaluec, Date paymentdatec, Lending lendingidc) {
        PaymentValidator.validateField(paymentdatec,PAYMENTDATEREQUIRED);
        PaymentValidator.validateField(paymentvaluec,PAYMENTVALUEREQUIRED);
        PaymentValidator.validateField(lendingidc,PAYMENTLENDINGREQUIRED);

        this.id = idc;
        this.paymentvalue = paymentvaluec;
        this.paymentdate = (Date)paymentdatec.clone();
        this.lendingid=lendingidc;
    }
}
