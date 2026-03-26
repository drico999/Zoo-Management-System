public class Animal {
    private final String name;
    private final String species;

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String makeSound() {
        return "Unknown sound";
    }

    @Override
    public String toString() {
        return name + " the " + species;
    }
}