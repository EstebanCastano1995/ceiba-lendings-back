package com.ceiba.lendings.dominio.entidades.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public final class CalculateLendingTotalAmount {

    private CalculateLendingTotalAmount(){
    }

    private static final Double INTEREST=2.1;
    private static final Double OVERINTEREST=2.6;
    private static final Integer DAYSMONTH=30;

    public static Double calculateLendingTotalAmount(Date lendingReturnDate,Date lendingDate, Double value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lendingDate);
        Double totalAmount;
        Long days=getDaysBetweenDates(lendingDate,lendingReturnDate);
        if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
            Double interest=OVERINTEREST/DAYSMONTH*days;
            totalAmount=value+interest/100*value;
        }
        else {
            Double interest = INTEREST / DAYSMONTH * days;
            totalAmount = value + interest / 100 * value;
        }
        return Math.floor(totalAmount * 100) / 100;
    }

    public static Long getDaysBetweenDates(Date lendingDate,Date lendingReturnDate){
        return ChronoUnit.DAYS.between(convertToLocalDate(lendingDate),convertToLocalDate(lendingReturnDate));
    }

    private  static LocalDate convertToLocalDate(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
