package com.company;

import java.time.LocalDate;

public class MeetupActivity extends Activity {

    public MeetupActivity(TimeFrame timeFrame, float theory, float practice) {
        super(timeFrame, theory, practice);
    }

    @Override
    public void teach(Student student) {
        student.addTheory(theory);
        if (student.hasNotebook()) {
            student.addPractice(practice);
        }
    }
}
