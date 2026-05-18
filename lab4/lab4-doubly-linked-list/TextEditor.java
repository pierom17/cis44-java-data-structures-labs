public class TextEditor {

    private static class Node {
        String text;
        Node previous;
        Node next;

        // Node constructor...
        Node(String text) {
            this.text = text;
            this.previous = null;
            this.next = null;
        }
    }

    private Node current;

    public TextEditor() {
        this.current = null;
    }

    public void type(String text) {
        // Your implementation here...

        Node newNode = new Node(text);
        if (current != null) {
            current.next = newNode;
            newNode.previous = current;
        }

        current = newNode;

        System.out.println("Typed: " + text);
    }

    public void undo() {
        // Move backward through the list.

        if (current == null) {
            System.out.println("Nothing to undo.");
            return;
        }
        current = current.previous;
        System.out.println("Undo completed");
    }

    public void redo() {
        // Move forward through the list.

        if (current == null) {
            System.out.println("Nothing to redo");
            return;
        }
        if (current.next == null) {
            System.out.println("Nothing to redo.");
            return;
        }
        current = current.next;
        System.out.println("Redo completed");
    }

    public void displayCurrentText() {
        // Display the current text state.
        if (current == null) {
            System.out.println("Current text is empty");
        } else {
            System.out.println("Current text: " + current.text);
        }
    }
}