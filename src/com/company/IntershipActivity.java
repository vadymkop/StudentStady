package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IntershipActivity extends PrivateActivity {
    public IntershipActivity(TimeFrame timeFrame, float theory, float practice) {
        super(timeFrame, theory, practice);
    }

    @Override
    public void teach(Student student) {
        if (enrolledStudents.contains(student)){
            student.addTheory(theory);
            student.addPractice(practice);
        }
    }
}
