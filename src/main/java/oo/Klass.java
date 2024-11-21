package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {

    public static final String STUDENT_NOT_IN_CLASS_WHEN_ASSIGN_LEADER_MESSAGE = "It is not one of us.";
    private int number;

    private Student leader;

    private List<Person> klassObservers = new ArrayList<>();

    public Klass(int number) {
        this.number = number;
    }

    public boolean isLeader(Student student) {
        return !Objects.isNull(leader) && student.isIn(this) && leader.equals(student);
    }

    public void assignLeader(Student student) {
        if (canAssignLeader(student)) return;
        this.leader = student;
        notifyAllObservers();
    }

    private boolean canAssignLeader(Student student) {
        if (Objects.isNull(student)) return true;
        if (!student.isIn(this)) {
            System.out.print(STUDENT_NOT_IN_CLASS_WHEN_ASSIGN_LEADER_MESSAGE);
            return true;
        }
        return false;
    }

    private void notifyAllObservers() {
        klassObservers.stream()
                .forEach(person -> person.update(this));
    }

    public void attach(Person person) {
        if (!Objects.isNull(person) && !klassObservers.contains(person)) klassObservers.add(person);
    }

    public int getNumber() {
        return number;
    }

    public Student getLeader() {
        return leader;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass that = (Klass) o;
        return this.number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
