import java.util.Random;

public class Matrix {

    private int[][] data;

    public Matrix(int rows, int cols) {
        data = new int[rows][cols];
    }

    public Matrix(int[][] data) {
        this.data = data;
    }

    public void populateRandom() {
        Random random = new Random();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = random.nextInt(10) + 1;
            }
        }
    }

    public Matrix add(Matrix other) {
        if (data.length != other.data.length ||
                data[0].length != other.data[0].length) {

            throw new IllegalArgumentException(
                    "Matrices need to have the same dimensions for addition.");
        }

        Matrix result = new Matrix(data.length, data[0].length);

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                result.data[i][j] = data[i][j] + other.data[i][j];
            }
        }

        return result;
    }

    public Matrix multiply(Matrix other) {
        if (data[0].length != other.data.length) {

            throw new IllegalArgumentException(
                    "Number of columns of first matrix must equal number of rows of second matrix.");
        }

        Matrix result = new Matrix(data.length, other.data[0].length);

        for (int i = 0; i < data.length; i++) {

            for (int j = 0; j < other.data[0].length; j++) {

                for (int k = 0; k < data[0].length; k++) {

                    result.data[i][j] += data[i][k] * other.data[k][j];
                }
            }
        }

        return result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int[] row : data) {

            for (int value : row) {
                sb.append(value).append("\t");
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}