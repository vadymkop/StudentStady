package com.company;

import java.time.LocalDate;

public abstract class Activity {
    final TimeFrame timeFrame;
    final float theory;
    final float practice;

    public Activity(TimeFrame timeFrame, float theory, float practice) {
        this.timeFrame = timeFrame;
        this.theory = theory;
        this.practice = practice;
    }

    public void teach(Student student){
        student.addTheory(theory);
        student.addPractice(practice);
    };
    public boolean condition(LocalDate day) {
        return timeFrame.condition(day);
    }
}
