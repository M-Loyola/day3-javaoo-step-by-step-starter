package ooss.step5;

import ooss.Klass;
import ooss.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    @Test
    public void should_return_message_with_name_age_and_leader_when_introduce_given_student_is_the_leader() {
        Student tom = new Student(1, "Tom", 18);
        Klass klass = new Klass(1);
        tom.join(klass);
        klass.assignLeader(tom);

        String introduce = tom.introduce();

        assertEquals("My name is Tom. I am 18 years old. I am a student. I am the leader of class 1.", introduce);
    }
}
