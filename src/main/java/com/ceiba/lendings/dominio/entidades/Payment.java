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

    private static final String PAYMENT_VALUE_REQUIRED ="El valor del pago es requerido";
    private static final String PAYMENT_DATE_REQUIRED = "La fecha del pago es requerida";

    private Integer id;
    private Integer payment_value;
    private Date payment_date;

    public Payment(Integer id, Integer payment_value, Date payment_date) {
        PaymentValidator.validateField(payment_date,PAYMENT_DATE_REQUIRED);
        PaymentValidator.validateField(payment_value,PAYMENT_VALUE_REQUIRED);
        this.id = id;
        this.payment_value = payment_value;
        this.payment_date = payment_date;
    }
}
