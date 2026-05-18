import java.util.Random;

// Step 1: Create the abstract parent class
abstract class Animal {

    // An abstract method for visualization
    public abstract String toString();
}

// Step 2: Create the concrete animal classes
class Bear extends Animal {

    @Override
    public String toString() {
        return "B";
    }
}

class Fish extends Animal {

    @Override
    public String toString() {
        return "F";
    }
}

// Main class to run the simulation
public class Ecosystem {

    private Animal[] river;
    private Random random;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();

        // Add initial animals to the river
        populateRiver(4, 8);
    }

    // Randomly place starting animals in the river
    private void populateRiver(int bears, int fish) {

        for (int i = 0; i < bears; i++) {
            addAnimalRandomly(new Bear());
        }

        for (int i = 0; i < fish; i++) {
            addAnimalRandomly(new Fish());
        }
    }

    // Place an animal in a random empty cell
    private void addAnimalRandomly(Animal animal) {

        int index;

        do {
            index = random.nextInt(river.length);
        } while (river[index] != null);

        river[index] = animal;
    }

    public void runStep() {

        // 1. Create a new array for the next state.
        Animal[] nextRiver = new Animal[river.length];
        // 2. Iterate through the current river array.
        for (int i = 0; i < river.length; i++) {

            Animal current = river[i];

            if (current == null) {
                continue;
            }

            // 3. For each animal, decide its next move.
            int move = random.nextInt(3) - 1;

            int newIndex = i + move;

            // Prevent animals from leaving the river
            if (newIndex < 0 || newIndex >= river.length) {
                newIndex = i;
            }

            // Move animal if the space is empty
            if (nextRiver[newIndex] == null) {
                nextRiver[newIndex] = current;
            }

            // 4. Handle collisions and place animals in the new array.
            else {
                handleCollision(current, nextRiver[newIndex], nextRiver, newIndex);
            }
        }

        // 5. Replace the old river with the new one.
        river = nextRiver;
    }

    // Handle animal interactions
    private void handleCollision(Animal current, Animal target,
            Animal[] nextRiver, int index) {

        // If two identical animals collide, create a new animal
        if (current.getClass() == target.getClass()) {

            addBabyToRandomEmptyCell(nextRiver, current);

            nextRiver[index] = target;
        }
        // If a bear meets a fish, the fish disappears
        else if (current instanceof Bear && target instanceof Fish) {
            nextRiver[index] = current;
        }

        else if (current instanceof Fish && target instanceof Bear) {
            nextRiver[index] = target;
        }
    }

    // Add a baby animal to a random empty cell
    private void addBabyToRandomEmptyCell(Animal[] nextRiver, Animal parent) {

        int emptyCount = 0;

        for (Animal animal : nextRiver) {
            if (animal == null) {
                emptyCount++;
            }
        }

        // Stop if there are no empty spaces
        if (emptyCount == 0) {
            return;
        }

        int index;

        do {
            index = random.nextInt(nextRiver.length);
        } while (nextRiver[index] != null);

        if (parent instanceof Bear) {
            nextRiver[index] = new Bear();
        }

        else if (parent instanceof Fish) {
            nextRiver[index] = new Fish();
        }
    }

    public void visualize() {
        for (Animal animal : river) {

            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ecosystem eco = new Ecosystem(20);
        eco.visualize();
        // Loop to run multiple steps
        for (int i = 1; i <= 10; i++) {
            System.out.println("Step " + i + ":");
            eco.runStep();
            eco.visualize();
        }
    }
}