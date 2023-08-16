package ooss;

public class Klass {

    private final int number;

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Klass klass = (Klass) obj;
        return number == klass.number;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
