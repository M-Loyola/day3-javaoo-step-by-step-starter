package ooss;

import java.util.List;
import java.util.stream.Collectors;

public class Student extends Person {

    private Klass klass;
    private boolean isLeader = false;

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public void join(Klass klass) {
        this.klass = klass;
    }

    public boolean isIn(Klass klass) {
        return this.klass != null && this.klass.equals(klass);
    }

    public void setLeader(boolean isLeader) {
        this.isLeader = isLeader;
    }
    public String introduceLeader (List<Student> students, int number, String leader) {
        return students.stream()
                .filter(student -> !student.isLeader())
                .map(student -> String.format("I am %s, student of Class %d. I know %s become Leader.%n", student.getName(), number, leader))
                .collect(Collectors.joining());
    }
    @Override
    public String introduce() {
        if (isLeader) {
            return String.format("My name is %s. I am %d years old. I am a student. I am the leader of class %d.", name, age, klass.getNumber());
        }
        return isIn(klass) ?
                String.format("My name is %s. I am %d years old. I am a student. I am in class %d.", name, age, klass.getNumber()) :
                String.format("My name is %s. I am %d years old. I am a student.", name, age);
    }

    public boolean isLeader() {
        return this.isLeader;
    }
}
