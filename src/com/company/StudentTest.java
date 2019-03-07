package com.company;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class StudentTest {
    MeetupActivity meetup = new MeetupActivity(new OnceTime(LocalDate.of(19,3,3)), 7f, 5f);
    IntershipActivity intership = new IntershipActivity(new PeriodTime(LocalDate.of(19,3,3), 3), 20f, 30f);
    SelfStadyActivity selfStadyActivity = new SelfStadyActivity(new EverydayTime(), 5f, 2f);
    UnivercityActivity univercityActivity = new UnivercityActivity(new YearPeriodTime(LocalDate.of(19,3,3), 2), 1f, .2f);
    Plan plan = new Plan(LocalDate.of(19,3,1), LocalDate.of(19,3,8));
    Student s = new Student("Ricardo");
    @Test
    void studentUsePlan__getTheory__0f() {
        s.usePlan(plan);
        assertThat(s.getTheory(), is(0f));
    }

    @Test
    void meetup__withNotebook__true() {
        plan.addActivity(meetup);
        s.giveNotebook();
        s.usePlan(plan);
        assertThat(s.getTheory(), is(7f));
    }

    @Test
    void meetup__withoutNotebook__false() {
        plan.addActivity(meetup);
        s.usePlan(plan);
        assertThat(s.getTheory(), is(7f));
    }

    @Test
    void periodTime__condition__true() {
        TimeFrame period = new PeriodTime(LocalDate.of(19,3,1), LocalDate.of(19,3,8));
        LocalDate day = LocalDate.of(19,3,3);
        assertThat(((PeriodTime) period).condition(day), is(true));
    }

    @Test
    void yearPeriodTime__condition__true() {
        TimeFrame period = new YearPeriodTime(LocalDate.of(19,3,1), 1);
        LocalDate day = LocalDate.of(19,3,3);
        assertThat(((PeriodTime) period).condition(day), is(true));
    }

    @Test
    void intership___teach_not_enrolled_student__0f() {
        plan.addActivity(intership);
        s.usePlan(plan);
        assertThat(s.getTheory(), is(0f));
    }

    @Test
    void intership___teach_enrolled_student__60f() {
        s.enroll(intership);
        plan.addActivity(intership);
        s.usePlan(plan);
        assertThat(s.getTheory(), is(60f));
    }

    @Test
    void intership___teach_in_not_workday__25f() {
        intership = new IntershipActivity(new OnlyWorkingDayTime(LocalDate.of(19, 3, 1), 7), 5f, 10f);
        s.enroll(intership);
        plan.addActivity(intership);
        s.usePlan(plan);
        assertThat(s.getTheory(), is(25f));
    }

    @Test
    void intership___teach_once_in_month__5f() {
        plan = new Plan(LocalDate.of(19, 3, 3), 30);
        intership = new IntershipActivity(new EveryMonthTime(7), 5f, 10f);
        s.enroll(intership);
        plan.addActivity(intership);
        s.usePlan(plan);
        assertThat(s.getTheory(), is(5f));
    }

    @Test
    void student_shareExpirience__theory__9_4f() {
        Student s1 = new Student("Grud");
        plan.addActivity(selfStadyActivity);
        plan.addActivity(meetup);
        s.usePlan(plan);
        s.shareExpirience(s1);
        assertThat(s1.getTheory(), is(9.4f));
    }
}