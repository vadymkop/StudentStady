package com.company;

import java.text.DecimalFormat;

public class Student {
    float coefficientKnowlendge;
    float theoryExpirience;
    float practiceExpirience;
    boolean haveNotebook = false;
    String name;
    final float coefficientShareExpirience = .2f;
    private static DecimalFormat float_round_coeff = new DecimalFormat(".##");

    public Student(String name) {
        this.name = name;
        this.coefficientKnowlendge = 1;
        this.theoryExpirience = 0;
        this.practiceExpirience = 0;
    }

    public Student(String name, boolean haveNotebook) {
        this(name);
        this.haveNotebook = haveNotebook;
    }

    public Student(String name, float coeffStady) {
        this.name = name;
        this.coefficientKnowlendge = coeffStady;
        this.theoryExpirience = 0;
        this.practiceExpirience = 0;
    }

    public void usePlan(Plan plan) {
        plan.apply(this);
    }

    public float getTheory() {
        return Float.parseFloat(float_round_coeff.format(theoryExpirience));
    }

    public float getPractice() {
        return Float.parseFloat(float_round_coeff.format(practiceExpirience));
    }

    public String getStatus() {
        return name+":\n\ttheory - "+getTheory()+"\n\tpractice - "+getPractice()+"\n";
    }

    public void addTheory(float expirience) {
        theoryExpirience += expirience * coefficientKnowlendge;
    }

    public void addPractice(float expirience) {
        practiceExpirience += expirience * coefficientKnowlendge;
    }

    public boolean hasNotebook() {
        return haveNotebook;
    }

    public void giveNotebook() {
        haveNotebook = true;
    }

    public void enroll(PrivateActivity privateActivity) {
        privateActivity.interview(this);
    }

    public void shareExpirience(Student student) {
        student.addTheory(theoryExpirience * coefficientShareExpirience);
        if (student.hasNotebook()) {
            student.addPractice(practiceExpirience * coefficientShareExpirience);
        }
    }
}
