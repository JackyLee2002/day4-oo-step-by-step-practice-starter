package oo;

import java.util.List;

public class School {
    private List<Teacher> teachers;
    private List<Student> students;

    public School(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
    }

    public void startSchool() {
        teachers.stream().map(Teacher::introduce).forEach(System.out::print);
        students.stream().map(Student::introduce).forEach(System.out::print);
    }
}