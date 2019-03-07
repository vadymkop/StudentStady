package com.company;

import java.time.LocalDate;

public class OnceTime implements TimeFrame {
    public final LocalDate date;

    public OnceTime(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean condition(LocalDate day) {
        return date.equals(day);
    }
}
