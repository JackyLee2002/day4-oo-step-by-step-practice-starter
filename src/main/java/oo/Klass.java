package oo;

import java.util.Objects;

public class Klass {

    private int number;

    public Klass(int number) {
        this.number = number;
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
