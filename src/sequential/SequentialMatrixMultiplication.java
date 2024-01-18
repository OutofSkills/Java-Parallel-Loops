package sequential;

public class SequentialMatrixMultiplication {

    public static double[][] multiply(double[][] matrixA, double[][] matrixB) {
        int resultRows = matrixA.length;
        int resultColumns = matrixB[0].length;

        double[][] result = new double[resultRows][resultColumns];

        int columnsMatrixB = matrixB[0].length;

        for (int i = 0; i < resultRows; i++) {
            for (int j = 0; j < columnsMatrixB; j++) {
                result[i][j] = 0;
                for (int k = 0; k < resultColumns; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }
}