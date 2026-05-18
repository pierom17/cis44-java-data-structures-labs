public class Playlist {
    private static class Node {
        Song song;
        Node next;

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
        // Node constructor...
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }

    public void addSong(Song song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;

        System.out.println("Added: " + song);
    }

    public void removeSong(String title) {
        // Handle two cases: removing the head and removing from elsewhere.
        // Don't forget to update the tail if the last song is removed.

        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (head.song.getTitle().equalsIgnoreCase(title)) {

            System.out.println("Removed: " + head.song);

            if (currentNode == head) {
                currentNode = head.next;
            }

            head = head.next;

            if (head == null) {
                tail = null;
            }

            size--;
            return;
        }

        Node previous = head;
        Node current = head.next;

        while (current != null) {

            if (current.song.getTitle().equalsIgnoreCase(title)) {

                System.out.println("Removed: " + current.song);

                previous.next = current.next;

                if (current == tail) {
                    tail = previous;
                }

                if (currentNode == current) {
                    currentNode = current.next;
                }

                size--;
                return;
            }

            previous = current;
            current = current.next;
        }

        System.out.println("Song not found.");
    }

    public void playNext() {
        // If currentNode is null, start from the head.
        // Otherwise, advance to the next node.
        // If you reach the end, loop back to the head.

        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (currentNode == null) {
            currentNode = head;
        }

        System.out.println("Now playing: " + currentNode.song);

        if (currentNode.next == null) {
            currentNode = head;
        } else {
            currentNode = currentNode.next;
        }
    }

    public void displayPlaylist() {
        // Traverse from the head and print each song.

        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.println(current.song);
            current = current.next;
        }
    }
}