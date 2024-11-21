package oo;

import java.util.Objects;

public class Klass {

    private int number;

    private Student leader;

    public Klass(int number) {
        this.number = number;
    }

    public boolean isLeader(Student student) {
        return !Objects.isNull(leader) && student.isIn(this) && leader.equals(student);
    }

    public void assignLeader(Student student) {
        if (Objects.isNull(student)) return;
        if (!student.isIn(this)) {
            System.out.print("It is not one of us.");
            return;
        }
        this.leader = student;
    }

    public int getNumber() {
        return number;
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
