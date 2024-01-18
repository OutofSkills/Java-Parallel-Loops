package parallel;

public class RowMultiplyWorker implements Runnable {
    private final double[][] result;
    private double[][] matrixA;
    private double[][] matrixB;
    private final int row;

    public RowMultiplyWorker(double[][] result, double[][] matrixA, double[][] matrixB, int row) {
        this.result = result;
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.row = row;
    }

    @Override
    public void run() {
        for (int i = 0; i < matrixB[0].length; i++) {
            result[row][i] = 0;
            for (int j = 0; j < matrixA[row].length; j++) {
                result[row][i] += matrixA[row][j] * matrixB[j][i];
            }
        }
    }
}