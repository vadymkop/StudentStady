package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class OnlyWorkingDayTime extends PeriodTime {
    public OnlyWorkingDayTime(LocalDate startTime, LocalDate finishTime) {
        super(startTime, finishTime);
    }

    public OnlyWorkingDayTime(LocalDate startTime, int duration) {
        super(startTime, duration);
    }

    @Override
    public boolean condition(LocalDate day) {
        boolean isWorkingDay = true;
        switch (day.getDayOfWeek()){
            case SUNDAY:
                isWorkingDay = false;
                break;
            case SATURDAY:
                isWorkingDay = false;
                break;
        }
        return isWorkingDay && super.condition(day);
    }
}
