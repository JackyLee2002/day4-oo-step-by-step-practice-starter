package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Teacher extends Person {

    private List<Klass> klass = new ArrayList<>();

    public Teacher(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String teacherIntroduction = String.format("My name is %s. I am %d years old. I am a teacher.", name, age);
        if (!Objects.isNull(klass) && !klass.isEmpty()) {
            teacherIntroduction += " I teach Class " + klass.stream()
                    .map(i -> String.valueOf(i.getNumber()))
                    .collect(Collectors.joining(", ")) + ".";
        }
        return teacherIntroduction;
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
