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
        for (Teacher teacher : teachers) {
            System.out.print(teacher.introduce());
        }
        for (Student student : students) {
            System.out.print(student.introduce());
        }
    }
}