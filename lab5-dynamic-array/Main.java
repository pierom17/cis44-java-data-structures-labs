public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addItem(new Item("Wooden Stick"));
        inventory.addItem(new Item("Magic Stone"));
        inventory.display();

        System.out.println();

        inventory.combineItems("Wooden Stick", "Magic Stone");
        System.out.println();
        System.out.println("Combined:");
        inventory.display();
    }
}