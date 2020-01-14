package com.ceiba.lendings.databuilder;

import java.util.Calendar;
import java.util.Date;

public final class DateDataBuilder {

    public static Date build(Integer year, Integer month, Integer day) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        return c.getTime();
    }
}
