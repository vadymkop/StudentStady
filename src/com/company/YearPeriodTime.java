package com.company;

import java.time.LocalDate;

public class YearPeriodTime extends PeriodTime {
    public YearPeriodTime(int startYear, int endYear) {
        super(LocalDate.of(startYear, 1, 1), LocalDate.of(endYear, 1, 1));
    }

    public YearPeriodTime(LocalDate startTime, int duration) {
        super(startTime, startTime.plusYears(duration));
    }

    public YearPeriodTime(LocalDate startTime, LocalDate finishTime) {
        super(startTime, finishTime);
    }
}
