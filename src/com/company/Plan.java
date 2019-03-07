package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Plan extends PeriodTime {
    List<Activity> activityList = new ArrayList();

    public Plan(LocalDate startTime, LocalDate finishTime) {
        super(startTime, finishTime);
    }

    public Plan(LocalDate startTime, int duration) {
        super(startTime, duration);
    }

    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public void apply(Student student) {
        for (LocalDate day : getDates()) {
            for (Activity activity : activityList) {
                if (activity.condition(day)) {
                    activity.teach(student);
                }
            }
        }
    }
}
