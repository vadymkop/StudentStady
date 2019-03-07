package com.company;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.List;

public interface TimeFrame {
    boolean condition(LocalDate day);
}
