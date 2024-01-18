package streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamParallelMatrixMultiplication {
    public static double[][] multiply(double[][] matrixA, double[][] matrixB) {
        return Arrays.stream(matrixA).parallel()
                .map(row -> IntStream.range(0, matrixA.length)
                        .mapToDouble(i -> IntStream.range(0, matrixB[0].length)
                                .mapToDouble(j -> row[j] * matrixB[j][i]).sum())
                        .toArray())
                .toArray(double[][]::new);
    }
}