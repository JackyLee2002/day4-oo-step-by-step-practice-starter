package oo;

import java.util.Objects;

public class Student extends Person implements KlassObserver {

    public static final String STUDENT_INTRODUCTION_MESSAGE = " I am a student.";
    public static final String STUDENT_INTRODUCTION_IF_IS_LEADER = " I am the leader of class %d.";
    public static final String STUDENT_INTRODUCTION_IF_IN_CLASS = " I am in class %d.";
    public static final String STUDENT_OBSERVER_UPDATE_MESSAGE = "I am %s, student of Class %d. I know %s become Leader.%n";

    private Klass klass;

    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String studentIntroduction = String.format(super.introduce() + STUDENT_INTRODUCTION_MESSAGE, name, age);
        studentIntroduction += appendStudentIntroductionMessage();
        return studentIntroduction;
    }

    private String appendStudentIntroductionMessage() {
        if (!Objects.isNull(klass)) {
            return klass.isLeader(this)
                    ? String.format(STUDENT_INTRODUCTION_IF_IS_LEADER, klass.getNumber())
                    : String.format(STUDENT_INTRODUCTION_IF_IN_CLASS, klass.getNumber());
        }
        return "";
    }

    public void join(Klass klass) {
        this.klass = klass;
    }

    public boolean isIn(Klass klass) {
        return !Objects.isNull(this.klass) && this.klass.equals(klass);
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public void update(Klass klass) {
        System.out.printf(STUDENT_OBSERVER_UPDATE_MESSAGE, name, klass.getNumber(), klass.getLeader().getName());
    }
}
