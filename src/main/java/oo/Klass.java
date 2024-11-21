package oo;

public class Klass {

    private int number;

    public Klass(int number) {
        this.number = number;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass that = (Klass) o;
        return this.number == that.number;
    }


}
