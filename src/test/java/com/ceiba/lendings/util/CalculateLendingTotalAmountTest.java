package com.ceiba.lendings.util;

import com.ceiba.lendings.BaseTest;
import com.ceiba.lendings.databuilder.DateDataBuilder;
import com.ceiba.lendings.dominio.entidades.util.CalculateLendingTotalAmount;
import org.junit.jupiter.api.Test;

public class CalculateLendingTotalAmountTest {

    @Test
    public void validateLendingDateBetweenWeekAndCorrectValue() {
        Double totalAmount= CalculateLendingTotalAmount.calculateLendingTotalAmount(DateDataBuilder.build(2020,1,1),DateDataBuilder.build(2020,0,1),185000.0);
        BaseTest.assertCorrect(totalAmount,189014.5);
    }

    @Test
    public void validateLendingDateOnSaturdayAndCorrectValue() {
        Double totalAmount= CalculateLendingTotalAmount.calculateLendingTotalAmount(DateDataBuilder.build(2020,1,18),DateDataBuilder.build(2020,0,18),200000.0);
        BaseTest.assertCorrect(totalAmount,205373.33);
    }

    @Test
    public void testDaysBetweenDates() {
        Long days=CalculateLendingTotalAmount.getDaysBetweenDates(DateDataBuilder.build(2020,0,18),DateDataBuilder.build(2020,1,18));
        System.out.println(days);
        BaseTest.assertCorrect(days,(long)31);
    }
}
