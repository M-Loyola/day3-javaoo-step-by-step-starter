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
        for (Klass klass : classesTeaching) {
            if (student.isIn(klass)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String introduce() {
        if (classesTeaching.size() == 1) {
            return String.format("My name is %s. I am %d years old. I am a teacher. I teach Class %d.", name, age, classesTeaching.get(0).getNumber());
        } else if (classesTeaching.size() > 1) {
            String classNumbers = classesTeaching.stream().map(klass -> String.valueOf(klass.getNumber())).collect(Collectors.joining(", "));
            return String.format("My name is %s. I am %d years old. I am a teacher. I teach Class %s.", name, age, classNumbers);
        } else {
            return String.format("My name is %s. I am %d years old. I am a teacher.", name, age);
        }
    }
}
