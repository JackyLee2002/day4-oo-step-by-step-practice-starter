package oo;

import java.util.Objects;

public class Person {
    public static final String PERSON_INTRODUCTION_MESSAGE = "My name is %s. I am %d years old.";
    protected Integer id;

    protected String name;

    protected Integer age;

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return String.format(PERSON_INTRODUCTION_MESSAGE, name, age);
    }

    public String getName() {
        return name;
    }

    public void update(Klass klass) {}

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
