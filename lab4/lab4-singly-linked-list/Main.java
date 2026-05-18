import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();
        int choice;

        do {
            System.out.println("\nPlaylist Manager");
            System.out.println("1. Add song");
            System.out.println("2. Remove song");
            System.out.println("3. Play next song");
            System.out.println("4. Display playlist");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter song title:");
                    String title = scanner.nextLine();

                    System.out.print("Enter artist:");
                    String artist = scanner.nextLine();

                    playlist.addSong(new Song(title, artist));
                    break;

                case 2:
                    System.out.print("Enter title to remove: ");
                    String removeTitle = scanner.nextLine();

                    playlist.removeSong(removeTitle);
                    break;

                case 3:
                    playlist.playNext();
                    break;

                case 4:
                    playlist.displayPlaylist();
                    break;

                case 5:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
        scanner.close();
    }
}