import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        int choice;

        do {
            System.out.println();
            System.out.println("Text Editor History");
            System.out.println("1. Type text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display current text");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter text:");
                String text = scanner.nextLine();

                editor.type(text);

            } else if (choice == 2) {
                editor.undo();

            } else if (choice == 3) {

                editor.redo();
            } else if (choice == 4) {

                editor.displayCurrentText();

            } else if (choice == 5) {
                System.out.println("Exiting");

            } else {

                System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        scanner.close();
    }
}