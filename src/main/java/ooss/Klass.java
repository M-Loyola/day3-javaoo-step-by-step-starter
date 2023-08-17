package ooss;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void assignLeader(Student student) {
        if (!student.isIn(this)) {
            System.out.println("It is not one of us.");
            return;
        }
        setLeader(student);
        introduceLeader(student);
    }
    private void introduceLeader(Student student) {
        System.out.println((teacher != null) ?
                teacher.introduceLeader(number, leader.getName()):
                student.introduceLeader(students, number, leader.getName())
        );
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

    public void attach(Student student) {
        students.add(student);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Klass klass = (Klass) obj;
        return number == klass.number;
    }
}
