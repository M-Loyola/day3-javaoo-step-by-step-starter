package ooss;

public class Klass {

    private final int number;
    private Student leader;

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void assignLeader(Student student) {
        if (student.isIn(this)) {
            setLeader(student); // Call setLeader to update both leader and student's isLeader
        } else {
            System.out.println("It is not one of us.");
        }
    }

    public boolean isLeader(Student student) {
        return leader != null && leader.equals(student);
    }

    public void setLeader(Student student) {
        leader = student;
        student.setLeader(true); // Set the student's isLeader attribute to true
    }
}
