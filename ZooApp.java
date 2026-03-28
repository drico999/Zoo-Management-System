import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ZooApp {
    private static final ArrayList<Animal> animals = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("Welcome to the Zoo Management System");

        while (running) {
            printMenu();
            int choice = readInt("Select an option: ");

            switch (choice) {
                case 1 -> viewAnimals();
                case 2 -> addAnimal();
                case 3 -> searchAnimal();
                case 4 -> {
                    running = false;
                    System.out.println("Exiting Zoo Management System. Goodbye!");
                }
                default -> System.out.println("Invalid menu option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n1. View Animals");
        System.out.println("2. Add Animal");
        System.out.println("3. Search Animal");
        System.out.println("4. Exit");
    }

    private static void addAnimal() {
        System.out.println("\nChoose animal type:");
        System.out.println("1. Lion");
        System.out.println("2. Elephant");
        System.out.println("3. Bird");

        int typeChoice = readInt("Enter type option: ");
        String name = readNonEmptyString("Enter animal name: ");

        Animal newAnimal;

        switch (typeChoice) {
            case 1 -> {
                int prideSize;
                while (true) {
                    prideSize = readInt("Enter lion pride size: ");
                    if (prideSize > 0) break;
                    System.out.println("Pride size must be positive.");
                }
                newAnimal = new Lion(name, prideSize);
            }
            case 2 -> {
                double trunkLength;
                while (true) {
                    trunkLength = readDouble("Enter elephant trunk length (meters): ");
                    if (trunkLength > 0) break;
                    System.out.println("Trunk length must be positive.");
                }
                newAnimal = new Elephant(name, trunkLength);
            }
            case 3 -> {
                double wingSpan;
                while (true) {
                    wingSpan = readDouble("Enter bird wing span (meters): ");
                    if (wingSpan > 0) break;
                    System.out.println("Wing span must be positive.");
                }
                newAnimal = new Bird(name, wingSpan);
            }
            default -> {
                System.out.println("Invalid animal type. Returning to menu.");
                return;
            }
        }

        animals.add(newAnimal);
        System.out.println("Animal added successfully: " + newAnimal);
    }

    private static void viewAnimals() {
        if (animals.isEmpty()) {
            System.out.println("\nNo animals in the system yet.");
            return;
        }

        System.out.println("\nAnimal List\n----------------");
        for (Animal animal : animals) {
            System.out.println(animal);
            System.out.println("Sound: " + animal.makeSound() + "\n");
        }
    }

    private static void searchAnimal() {
        String searchName = readNonEmptyString("\nEnter animal name to search: ");
        boolean found = false;

        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(searchName)
                    || animal.getName().toLowerCase().contains(searchName.toLowerCase())) {
                if (!found) {
                    System.out.println("\nSearch Results\n----------------");
                }
                found = true;
                System.out.println(animal);
                System.out.println("Sound: " + animal.makeSound() + "\n");
            }
        }

        if (!found) {
            System.out.println("Animal not found.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine();
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) return value;
            System.out.println("Input cannot be empty. Please try again.");
        }
    }
}