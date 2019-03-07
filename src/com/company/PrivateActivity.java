package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class PrivateActivity extends Activity {
    List<Student> enrolledStudents = new ArrayList();
    public PrivateActivity(TimeFrame timeFrame, float theory, float practice) {
        super(timeFrame, theory, practice);
    }
    public void interview(Student student) {
        enrolledStudents.add(student);
    }
}
