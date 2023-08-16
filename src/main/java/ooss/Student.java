package ooss;

import java.util.Objects;

public class Student extends Person {

    private Klass klass;

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public void join (Klass klass) {
        this.klass = klass;
    }
    public boolean isIn(Klass klass) {
        return this.klass != null && this.klass.equals(klass);
    }

    @Override
    public String introduce() {
        return isIn(klass) ?
                String.format("My name is %s. I am %d years old. I am a student. I am in class %d.", name, age, klass.getNumber())
                :
                String.format("My name is %s. I am %d years old. I am a student.",name,age);
    }
}
