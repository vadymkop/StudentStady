package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PeriodTime implements TimeFrame{
    final LocalDate startTime;
    final LocalDate finishTime;

    public PeriodTime(LocalDate startTime, LocalDate finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public PeriodTime(LocalDate startTime, int duration) {
        this(startTime, startTime.plusDays(duration>0?duration-1:duration));
    }

    @Override
    public boolean condition(LocalDate day) {
        return startTime.isBefore(day) && finishTime.isAfter(day) || startTime.equals(day) || finishTime.equals(day);
    }

    public List<LocalDate> getDates() {
        List<LocalDate> dates = new ArrayList<> ();
        for (LocalDate date = startTime; !date.isAfter(finishTime); date = date.plusDays(1)) {
            dates.add(date);
        }
        return dates;
    }
}
