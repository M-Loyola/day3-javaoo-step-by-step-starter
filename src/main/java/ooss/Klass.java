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
        if (student.isIn(this)) {
            setLeader(student);
            System.out.println(notifyLeader(student));
        }
        System.out.println("It is not one of us.");
    }

    private String notifyLeader(Student leader) {
        return (teacher != null) ?
                String.format("I am %s, teacher of Class %d. I know %s become Leader.%n", teacher.getName(), number, leader.getName())
                :
                students.stream()
                        .filter(student -> !student.isLeader())
                        .map(student -> String.format("I am %s, student of Class %d. I know %s become Leader.%n", student.getName(), number, leader.getName()))
                        .collect(Collectors.joining());
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
