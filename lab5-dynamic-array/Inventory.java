import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void display() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (Item item : items) {
                System.out.println("- " + item);
            }
        }
    }

    public void combineItems(String name1, String name2) {
        boolean found1 = false;
        boolean found2 = false;

        Iterator<Item> iter = items.iterator();
        while (iter.hasNext()) {
            Item current = iter.next();
            if (current.getName().equals(name1) || current.getName().equals(name2)) {
                // How do you track which item you found?
                // How do you remove it safely?
                if (current.getName().equals(name1) && !found1) {
                    found1 = true;
                    iter.remove();
                } else if (current.getName().equals(name2) && !found2) {
                    found2 = true;
                    iter.remove();
                }
            }
        }

        // After the loop, check if both were found.
        // If so, add the new combined item.
        // What happens if you add the new item inside the loop?
        if (found1 && found2) {
            items.add(new Item("Magic Staff"));
            System.out.println(name1 + " and " + name2 + " combined into Magic Staff.");
        } else {
            System.out.println("Could not combine items.");
        }
    }
}