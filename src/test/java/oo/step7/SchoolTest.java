package oo.step7;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import oo.Klass;
import oo.School;
import oo.Student;
import oo.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SchoolTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testStartSchool() {
        List<Teacher> teachers = Arrays.asList(new Teacher(1, "Alice", 30), new Teacher(2, "Bob", 40));
        List<Student> students = Arrays.asList(new Student(1, "Charlie", 18), new Student(2, "David", 19));
        School school = new School(teachers, students);

        school.startSchool();

        String expectedOutput = "My name is Alice. I am 30 years old. I am a teacher." +
                "My name is Bob. I am 40 years old. I am a teacher." +
                "My name is Charlie. I am 18 years old. I am a student." +
                "My name is David. I am 19 years old. I am a student.";
        assertThat(systemOut()).isEqualTo(expectedOutput);
    }

        @Test
        public void testStartSchoolWithNoTeachersAndStudents() {
            List<Teacher> teachers = Collections.emptyList();
            List<Student> students = Collections.emptyList();
            School school = new School(teachers, students);

            school.startSchool();

            String expectedOutput = "";
            assertThat(systemOut()).isEqualTo(expectedOutput);
        }

        @Test
        public void testStartSchoolWithOnlyTeachers() {
            List<Teacher> teachers = Arrays.asList(new Teacher(1, "Alice", 30), new Teacher(2, "Bob", 40));
            List<Student> students = Collections.emptyList();
            School school = new School(teachers, students);

            school.startSchool();

            String expectedOutput = "My name is Alice. I am 30 years old. I am a teacher." +
                    "My name is Bob. I am 40 years old. I am a teacher.";
            assertThat(systemOut()).isEqualTo(expectedOutput);
        }

        @Test
        public void testStartSchoolWithOnlyStudents() {
            List<Teacher> teachers = Collections.emptyList();
            List<Student> students = Arrays.asList(new Student(1, "Charlie", 18), new Student(2, "David", 19));
            School school = new School(teachers, students);

            school.startSchool();

            String expectedOutput = "My name is Charlie. I am 18 years old. I am a student." +
                    "My name is David. I am 19 years old. I am a student.";
            assertThat(systemOut()).isEqualTo(expectedOutput);
        }

        private String systemOut() {
            return outContent.toString();
        }

}
