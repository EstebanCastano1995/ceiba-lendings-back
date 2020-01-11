package com.ceiba.lendings.dominio.entidades;

import java.util.Date;
import com.ceiba.lendings.dominio.entidades.validators.LendingValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Lending {

    private static final String LENDING_RETURN_DATE_REQUIRED ="La fecha de terminación del prestamo es requerida";
    private static final String LENDING_TOTAL_AMOUNT_REQUIRED = "La cantidad total a pagar es requerida ";
    private static final String LENDING_VALUE_REQUIRED ="El valor del prestamo es requerido";
    private static final String LENDING_DATE_REQUIRED = "La fecha del prestamo es requerida";

    private Integer id;
    private Date lending_return_date;
    private Integer lending_total_amount;
    private Integer lending_value;
    private Date lending_date;

    public Lending(Integer id, Date lending_return_date, Integer lending_total_amount, Integer lending_value, Date lending_date) {
        LendingValidator.validateField(lending_return_date,LENDING_RETURN_DATE_REQUIRED);
        LendingValidator.validateField(lending_total_amount,LENDING_TOTAL_AMOUNT_REQUIRED);
        LendingValidator.validateField(lending_value,LENDING_VALUE_REQUIRED);
        LendingValidator.validateField(lending_date,LENDING_DATE_REQUIRED);

        this.id = id;
        this.lending_return_date = lending_return_date;
        this.lending_total_amount = lending_total_amount;
        this.lending_value = lending_value;
        this.lending_date = lending_date;
    }


}
