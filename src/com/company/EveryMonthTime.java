package com.company;

import java.time.LocalDate;

public class EveryMonthTime implements TimeFrame{
    int dayOfMonth;

    public EveryMonthTime(int day) {
        this.dayOfMonth = day;
    }

    @Override
    public boolean condition(LocalDate day) {
        return day.getDayOfMonth() == dayOfMonth;
    }
}
