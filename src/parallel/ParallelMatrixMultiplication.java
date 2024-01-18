package parallel;

import java.util.ArrayList;
import java.util.List;

public class ParallelMatrixMultiplication {

    public static void multiply(double[][] matrixA, double[][] matrixB, double[][] result) {
        List<Thread> threads = new ArrayList<>();

        int rows = matrixA.length;
        for (int i = 0; i < rows; i++) {
            RowMultiplyWorker task = new RowMultiplyWorker(result, matrixA, matrixB, i);

            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);

            if (threads.size() % 10 == 0) {
                waitForThreads(threads);
            }
        }
    }

    private static void waitForThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }

}