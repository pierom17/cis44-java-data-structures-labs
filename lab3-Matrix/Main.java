public class Main {

    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(2, 2);
        matrix1.populateRandom();
        Matrix matrix2 = new Matrix(2, 2);
        matrix2.populateRandom();
        System.out.println("Matrix 1:");
        System.out.println(matrix1);
        System.out.println("Matrix 2:");
        System.out.println(matrix2);

        // Sum
        try {
            Matrix sum = matrix1.add(matrix2);

            System.out.println("Matrix Addition:");
            System.out.println(sum);

        } catch (IllegalArgumentException e) {

            System.out.println("Addition Error: " + e.getMessage());
        }

        // Multiplication
        try {
            Matrix product = matrix1.multiply(matrix2);

            System.out.println("Matrix Multiplication:");
            System.out.println(product);

        } catch (IllegalArgumentException e) {

            System.out.println("Multiplication Error: " + e.getMessage());
        }

        // Exception
        Matrix badMatrix = new Matrix(3, 4);

        try {
            matrix1.add(badMatrix);

        } catch (IllegalArgumentException e) {

            System.out.println("Caught Addition Exception:");
            System.out.println(e.getMessage());
        }

        try {
            badMatrix.multiply(matrix1);

        } catch (IllegalArgumentException e) {

            System.out.println("Caught Multiplication Exception:");
            System.out.println(e.getMessage());
        }
    }
}