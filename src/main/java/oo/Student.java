package oo;

import java.util.Objects;

public class Student extends Person{

    private Klass klass;

    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    public String introduce() {
        String studentIntroduction = String.format("My name is %s. I am %d years old. I am a student.", name, age);
        if (!Objects.isNull(klass)){
            studentIntroduction += String.format(" I am in class %d.", klass.getNumber());
        }
        return studentIntroduction;


    }

    public void join(Klass klass){
        this.klass = klass;
    }

    public boolean isIn(Klass klass) {
        return !Objects.isNull(this.klass) && this.klass.equals(klass);
    }


    @Override
    public boolean equals(Object objectToBeCompared) {
        if (this == objectToBeCompared) return true;
        if (objectToBeCompared == null || getClass() != objectToBeCompared.getClass()) return false;
        Person objectCastedAsPerson = (Person) objectToBeCompared;
        return Objects.equals(this.id, objectCastedAsPerson.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
