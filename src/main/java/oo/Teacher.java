package oo;

import java.util.Objects;

public class Teacher extends Person {
    public Teacher(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old. I am a teacher.", name, age);
    }

    @Override
    public boolean equals(Object objectToBeCompared) {
        if (this == objectToBeCompared) return true;
        if (objectToBeCompared == null || getClass() != objectToBeCompared.getClass()) return false;
        Person objectCastedAsPerson = (Person) objectToBeCompared;
        return Objects.equals(this.id, objectCastedAsPerson.id);
    }
}
