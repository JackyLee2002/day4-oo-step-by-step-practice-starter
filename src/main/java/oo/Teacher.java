package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Teacher extends Person implements KlassObserver {

    public static final String TEACHER_INTRODUCTION_MESSAGE = "My name is %s. I am %d years old. I am a teacher.";
    public static final String TEACHER_OBSERVER_MESSAGE = "I am %s, teacher of Class %d. I know %s become Leader.";
    public static final String COMMA_WITH_SPACE = ", ";
    public static final String FULLSTOPS = ".";
    public static final String TEACHER_INTRODUCTION_START_IF_TEACHING_CLASS = " I teach Class ";
    private final List<Klass> klass = new ArrayList<>();

    public Teacher(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String teacherIntroduction = String.format(TEACHER_INTRODUCTION_MESSAGE, name, age);
        teacherIntroduction += appendTeacherIntroductionMessage();
        return teacherIntroduction;
    }

    private String appendTeacherIntroductionMessage() {
        if (!klass.isEmpty()) {
            return TEACHER_INTRODUCTION_START_IF_TEACHING_CLASS + klass.stream()
                    .map(i -> String.valueOf(i.getNumber()))
                    .collect(Collectors.joining(COMMA_WITH_SPACE)) + FULLSTOPS;
        }
        return "";
    }

    @Override
    public void update(Klass klass) {
        System.out.println(String.format(TEACHER_OBSERVER_MESSAGE, name, klass.getNumber(), klass.getLeader().getName()));
    }


    public void assignTo(Klass klass) {
        if (this.klass.stream().noneMatch(i -> i.equals(klass))) {
            this.klass.add(klass);
        }
    }

    public boolean belongsTo(Klass klass) {
        return !this.klass.isEmpty() && !Objects.isNull(klass) && this.klass.contains(klass);
    }

    public boolean isTeaching(Student student) {
        return belongsTo(student.getKlass());
    }

}
