public class Main {
    public static void main(String[] args) {
        LinkedPositionalList<String> itinerary = new LinkedPositionalList<>();

        Position<String> paris = itinerary.addLast("Paris");
        Position<String> eiffelTower = itinerary.addLast("Eiffel Tower");
        Position<String> louvre = itinerary.addLast("San Jose");

        itinerary.addAfter(eiffelTower, "Santa Clara");
        itinerary.addBefore(louvre, "San Francisco");

        System.out.println("Final Travel Itinerary:");
        for (String stop : itinerary) {
            System.out.println("- " + stop);
        }
    }
}