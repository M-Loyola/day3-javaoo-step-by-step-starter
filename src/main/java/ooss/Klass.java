package ooss;

import java.util.ArrayList;
import java.util.List;

public class Klass {

    private final int number;
    private Student leader;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void assignLeader(Student student) {
        if (student.isIn(this)) {
            setLeader(student);
            notifyTeacher(student);
            notifyOtherStudents(student);
        } else {
            System.out.println("It is not one of us.");
        }
    }

    private void notifyTeacher(Student leader) {
        if (teacher != null) {
            System.out.printf("I am %s, teacher of Class %d. I know %s become Leader.%n", teacher.getName(), number, leader.getName());
        }
    }

    private void notifyOtherStudents(Student leader) {
        for (Student student : students) {
            if (!student.isLeader()) {
                System.out.printf("I am %s, student of Class %d. I know %s become Leader.%n", student.getName(), number, leader.getName());
            }
        }
    }

    public boolean isLeader(Student student) {
        return leader != null && leader.equals(student);
    }

    public void setLeader(Student student) {
        leader = student;
        student.setLeader(true);
    }

    public void attach(Teacher teacher) {
        this.teacher = teacher;
    }
}
