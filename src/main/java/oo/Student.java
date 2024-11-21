package oo;

import java.util.Objects;

public class Student extends Person{

    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old. I am a student.", name, age);
    }

    @Override
    public boolean equals(Object objectToBeCompared) {
        if (this == objectToBeCompared) return true;
        if (objectToBeCompared == null || getClass() != objectToBeCompared.getClass()) return false;
        Person objectCastedAsPerson = (Person) objectToBeCompared;
        return Objects.equals(this.id, objectCastedAsPerson.id);
    }
}
