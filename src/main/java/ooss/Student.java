package ooss;

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

    public void assignLeader() {
        if (klass != null) {
            klass.assignLeader(this);
        }
    }

    public void setLeader(boolean isLeader) {
        this.isLeader = isLeader;
    }

    @Override
    public String introduce() {
        if (isLeader) {
            return String.format("My name is %s. I am %d years old. I am a student. I am the leader of class %d.", name, age, klass.getNumber());
        } else {
            return isIn(klass) ?
                    String.format("My name is %s. I am %d years old. I am a student. I am in class %d.", name, age, klass.getNumber()) :
                    String.format("My name is %s. I am %d years old. I am a student.", name, age);
        }
    }
}
