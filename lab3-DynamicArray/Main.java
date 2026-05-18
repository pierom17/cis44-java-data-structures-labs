public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();

        for (int i = 0; i < 15; i++) {
            dynamicArray.add(i);
        }

        System.out.println("Size: " + dynamicArray.size());

        for (int i = 0; i < dynamicArray.size(); i++) {
            System.out.print(dynamicArray.get(i) + " ");
        }
        System.out.println();

        System.out.println("Removed element at index 5: " + dynamicArray.remove(5));
        System.out.println("Size after removal: " + dynamicArray.size());

        for (int i = 0; i < dynamicArray.size(); i++) {
            System.out.print(dynamicArray.get(i) + " ");
        }
        System.out.println();
    }
}