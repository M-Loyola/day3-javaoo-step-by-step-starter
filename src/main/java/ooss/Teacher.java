package ooss;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private List<Klass> classesTeaching = new ArrayList<>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public void assignTo(Klass klass) {
        if (!classesTeaching.contains(klass)) {
            classesTeaching.add(klass);
        }
    }

    public boolean belongsTo(Klass klass) {
        return classesTeaching.contains(klass);
    }

    public boolean isTeaching(Student student) {
        return classesTeaching.stream().anyMatch(klass -> student.isIn(klass));
    }

    @Override
    public String introduce() {
        String classNumbers = classesTeaching.stream().map(klass -> String.valueOf(klass.getNumber())).collect(Collectors.joining(", "));
        if (classesTeaching.isEmpty()) {
            return String.format("My name is %s. I am %d years old. I am a teacher.", name, age);
        }
        return (classesTeaching.size() == 1) ?
                String.format("My name is %s. I am %d years old. I am a teacher. I teach Class %d.", name, age, classesTeaching.get(0).getNumber()) :
                String.format("My name is %s. I am %d years old. I am a teacher. I teach Class %s.", name, age, classNumbers);
    }

}
