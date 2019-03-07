package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        UnivercityActivity ChNU = new UnivercityActivity(new YearPeriodTime(LocalDate.of(2019, 9, 1), 5), 1f, .2f);
        UnivercityActivity ChDTU = new UnivercityActivity(new YearPeriodTime(LocalDate.of(2019, 9, 1), 3), 1f, .2f);
        UnivercityActivity ChNU_Magistr = new UnivercityActivity(new YearPeriodTime(LocalDate.of(2019, 9, 1), 2), 1f, .2f);

        MeetupActivity oopMeetup = new MeetupActivity(new OnceTime(LocalDate.of(2019, 10, 28)), 15f, 30f);
        MeetupActivity fpMeetup = new MeetupActivity(new OnceTime(LocalDate.of(2020, 1, 24)), 12f, 3f);
        MeetupActivity gitMeetup = new MeetupActivity(new OnceTime(LocalDate.of(2020, 4, 15)), 20f, 15f);
        MeetupActivity designMeetup = new MeetupActivity(new OnceTime(LocalDate.of(2020, 11, 6)), 15f, 30f);
        MeetupActivity authMeetup = new MeetupActivity(new OnceTime(LocalDate.of(2021, 2, 17)), 10f, 20f);
        MeetupActivity regexpMeetup = new MeetupActivity(new OnceTime(LocalDate.of(2022, 5, 15)), 30f, 15f);

        IntershipActivity intership1 = new IntershipActivity(new PeriodTime(LocalDate.of(2020, 6, 1), 20), 10f, 15f);
        IntershipActivity intership2 = new IntershipActivity(new PeriodTime(LocalDate.of(2021, 6, 1), 20), 12f, 17f);

        SelfStadyActivity easySelfStady = new SelfStadyActivity(new EverydayTime(), 1f, 1f);
        SelfStadyActivity normalSelfStady = new SelfStadyActivity(new OnlyWorkingDayTime(LocalDate.of(2019, 10, 1), LocalDate.of(2021, 11, 6)), 3f, 2f);
        SelfStadyActivity hardSelfStady = new SelfStadyActivity(new EverydayTime(), 4f, 3f);

        Plan pacifist = new Plan(LocalDate.of(2019, 9, 1), LocalDate.of(2026, 6, 30));
        Plan selfTaught = new Plan(LocalDate.of(2019, 9, 1), LocalDate.of(2022, 6, 30));
        Plan teachMeFull = new Plan(LocalDate.of(2019, 9, 1), LocalDate.of(2024, 6, 30));
        Plan consciousStudent = new Plan(LocalDate.of(2019, 9, 1), LocalDate.of(2023, 6, 30));

        pacifist.addActivity(ChNU);
        pacifist.addActivity(ChNU_Magistr);

        selfTaught.addActivity(oopMeetup);
        selfTaught.addActivity(gitMeetup);
        selfTaught.addActivity(authMeetup);
        selfTaught.addActivity(regexpMeetup);
        selfTaught.addActivity(normalSelfStady);
        selfTaught.addActivity(intership2);

        teachMeFull.addActivity(ChNU);
        teachMeFull.addActivity(oopMeetup);
        teachMeFull.addActivity(fpMeetup);
        teachMeFull.addActivity(gitMeetup);
        teachMeFull.addActivity(designMeetup);
        teachMeFull.addActivity(authMeetup);
        teachMeFull.addActivity(regexpMeetup);
        teachMeFull.addActivity(easySelfStady);

        consciousStudent.addActivity(ChDTU);
        consciousStudent.addActivity(hardSelfStady);
        consciousStudent.addActivity(oopMeetup);
        consciousStudent.addActivity(fpMeetup);
        consciousStudent.addActivity(gitMeetup);
        consciousStudent.addActivity(designMeetup);
        consciousStudent.addActivity(authMeetup);
        consciousStudent.addActivity(regexpMeetup);
        consciousStudent.addActivity(intership1);

        Student Artur = new Student("Artur", 1.5f);
        Student Denis = new Student("Denis");
        Student Ruslan = new Student("Ruslan", 1.2f);
        Student Stas = new Student("Stas", 0.2f);

        Artur.giveNotebook();
        Ruslan.giveNotebook();

        Artur.enroll(intership1);
        Artur.enroll(ChDTU);
        Denis.enroll(ChNU);
        Ruslan.enroll(intership2);
        Stas.enroll(ChNU);
        Stas.enroll(ChNU_Magistr);

        Artur.usePlan(consciousStudent);
        Denis.usePlan(teachMeFull);
        Ruslan.usePlan(selfTaught);
        Stas.usePlan(pacifist);

        System.out.println(Artur.getStatus());
        System.out.println(Denis.getStatus());
        System.out.println(Ruslan.getStatus());
        System.out.println(Stas.getStatus());
    }
}
