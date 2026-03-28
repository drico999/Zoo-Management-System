public class Lion extends Animal {
    private int prideSize;

    public Lion(String name, int prideSize) {
        super(name, "Lion");
        if (prideSize <= 0) {
            throw new IllegalArgumentException("Pride size must be positive");
        }
        this.prideSize = prideSize;
    }

    public int getPrideSize() {
        return prideSize;
    }

    @Override
    public String makeSound() {
        return "Roar";
    }

    @Override
    public String toString() {
        return super.toString() + ", Pride Size: " + prideSize;
    }
}