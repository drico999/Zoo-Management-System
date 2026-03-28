public class Bird extends Animal {
    private double wingSpan;

    public Bird(String name, double wingSpan) {
        super(name, "Bird");
        if (wingSpan <= 0) {
            throw new IllegalArgumentException("Wing span must be positive");
        }
        this.wingSpan = wingSpan;
    }

    public double getWingSpan() {
        return wingSpan;
    }

    @Override
    public String makeSound() {
        return "Chirp";
    }

    @Override
    public String toString() {
        return super.toString() + ", Wingspan: " + wingSpan + " m";
    }
}