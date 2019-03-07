package com.company;

import java.time.LocalDate;

public class EverydayTime implements TimeFrame {
    @Override
    public boolean condition(LocalDate day) {
        return true;
    }
}
