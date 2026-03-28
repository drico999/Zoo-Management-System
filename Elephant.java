public class Elephant extends Animal {
    private double trunkLength;

    public Elephant(String name, double trunkLength) {
        super(name, "Elephant");
        if (trunkLength <= 0) {
            throw new IllegalArgumentException("Trunk length must be positive");
        }
        this.trunkLength = trunkLength;
    }

    public double getTrunkLength() {
        return trunkLength;
    }

    @Override
    public String makeSound() {
        return "Trumpet";
    }

    @Override
    public String toString() {
        return super.toString() + ", Trunk Length: " + trunkLength + " m";
    }
}