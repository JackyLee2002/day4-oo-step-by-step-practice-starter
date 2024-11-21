package oo;

import java.util.Objects;

public class Student extends Person implements KlassObserver {

    private Klass klass;

    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String studentIntroduction = String.format("My name is %s. I am %d years old. I am a student.", name, age);
        if (!Objects.isNull(klass)) {
            studentIntroduction += klass.isLeader(this)
                    ? String.format(" I am the leader of class %d.", klass.getNumber())
                    : String.format(" I am in class %d.", klass.getNumber());
        }
        return studentIntroduction;
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
        System.out.println(String.format("I am %s, student of Class %d. I know %s become Leader.", name, klass.getNumber(), klass.getLeader().getName()));
    }
}
