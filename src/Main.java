import parallel.ParallelMatrixMultiplication;
import sequential.SequentialMatrixMultiplication;
import streams.StreamParallelMatrixMultiplication;
import utils.Matrix;

import java.util.Date;

public class Main {
	public static final Integer MATRIX_SIZE = 1000;
    public static final String SEQUENTIAL = "sequential";
    public static final String PARALLEL = "parallel";
    public static final String STREAM_PARALLEL = "streams";

    public static void main(String[] args) {
        printResults();
    }

    private static void printResults() {
        double[][] matrixA = Matrix.generateMatrix(MATRIX_SIZE, MATRIX_SIZE);
        double[][] matrixB = Matrix.generateMatrix(MATRIX_SIZE, MATRIX_SIZE);

        printMatrixMultiplicationResults(matrixA, matrixB, SEQUENTIAL);
        printMatrixMultiplicationResults(matrixA, matrixB, PARALLEL);
        printMatrixMultiplicationResults(matrixA, matrixB, STREAM_PARALLEL);
    }

    private static void printMatrixMultiplicationResults(double[][] matrixA, double[][] matrixB, String type) {
        Date start = new Date();

        double[][] result = new double[matrixA.length][matrixB[0].length];

        if (type.equals(SEQUENTIAL)) {
            result = SequentialMatrixMultiplication.multiply(matrixA, matrixB);
        } else if (type.equals(PARALLEL)) {
            ParallelMatrixMultiplication.multiply(matrixA, matrixB, result);
        } else if(type.equals(STREAM_PARALLEL)) {
            result = StreamParallelMatrixMultiplication.multiply(matrixA, matrixB);
        }

        Date end = new Date();
        
        double timeDifferenceSeconds = (end.getTime() - start.getTime()) / 1000.0;
        System.out.println("\nTime taken in seconds for " + type + " algorithm: " + timeDifferenceSeconds + " seconds");
    }
}