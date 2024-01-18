package utils;

public class Matrix {
    public static double[][] generateMatrix(int rows, int columns) {
        double[][] matrix = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = RandomGenerator.generateRandomNumber(10,100);
            }
        }

        return matrix;
    }

    public static void print(double[][] matrix) {
        System.out.println();
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}