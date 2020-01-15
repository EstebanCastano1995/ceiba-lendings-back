package com.ceiba.lendings.util;

import com.ceiba.lendings.BaseTest;
import com.ceiba.lendings.databuilder.DateDataBuilder;
import com.ceiba.lendings.dominio.entidades.util.CalculateLendingTotalAmount;
import org.junit.jupiter.api.Test;

public class CalculateLendingTotalAmountTest {

    @Test
    public void validateLendingDateBetweenWeekAndCorrectValue() {
        Double totalAmount= CalculateLendingTotalAmount.calculateLendingTotalAmount(DateDataBuilder.build(2020,2,1),DateDataBuilder.build(2020,1,1),185000.0);
        BaseTest.assertCorrect(totalAmount,188755.5);
    }

    @Test
    public void validateLendingDateOnSaturdayAndCorrectValue() {
        Double totalAmount= CalculateLendingTotalAmount.calculateLendingTotalAmount(DateDataBuilder.build(2020,2,18),DateDataBuilder.build(2020,1,18),200000.0);
        BaseTest.assertCorrect(totalAmount,204060.0);
    }
}
