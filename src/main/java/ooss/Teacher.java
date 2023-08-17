package ooss;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private List<Klass> taughtClasses = new ArrayList<>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public void assignTo(Klass klass) {
        if (!taughtClasses.contains(klass)) {
            taughtClasses.add(klass);
        }
    }

    public boolean belongsTo(Klass klass) {
        return taughtClasses.contains(klass);
    }

    public boolean isTeaching(Student student) {
        return taughtClasses.stream().anyMatch(student::isIn);
    }
    public String notifyLeader(int number, String leader) {
        return String.format("I am %s, teacher of Class %d. I know %s become Leader.%n", name, number , leader);
    }

    @Override
    public String introduce() {
        String classNumbers = taughtClasses.stream().map(klass -> String.valueOf(klass.getNumber())).collect(Collectors.joining(", "));
        if (taughtClasses.isEmpty()) {
            return String.format("My name is %s. I am %d years old. I am a teacher.", name, age);
        }
        return String.format("My name is %s. I am %d years old. I am a teacher. I teach Class %s.", name, age, classNumbers);
    }

}
