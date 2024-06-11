package org.example.pool;

import java.util.Random;
import java.util.concurrent.*;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

public class CountNumbers {
    private static final int SIZE = 100_000_000; // 데이터 크기를 늘림
    private static final int THRESHOLD = 10_000; // ForkJoinPool의 분할 크기를 늘림
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Generate random numbers
        int[] numbers = new Random().ints(SIZE, 1, 101).toArray();
        int[] numbers2 = new Random().ints(SIZE, 1, 101).toArray();
        int[] numbers3 = new Random().ints(SIZE, 1, 101).toArray();
        // Single thread
        long start = System.nanoTime();
        long count = countSingleThread(numbers);
        long end = System.nanoTime();
        System.out.println("Single Thread Count: " + count + ", Time: " + (end - start) / 1_000_000 + " ms");

        // ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        start = System.nanoTime();
        count = forkJoinPool.invoke(new CountTask(numbers2, 0, numbers.length));
        end = System.nanoTime();
        System.out.println("ForkJoinPool Count: " + count + ", Time: " + (end - start) / 1_000_000 + " ms");

        // ThreadPoolExecutor
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        start = System.nanoTime();
        count = countWithThreadPool(executor, numbers3);
        end = System.nanoTime();
        System.out.println("ThreadPoolExecutor Count: " + count + ", Time: " + (end - start) / 1_000_000 + " ms");

        executor.shutdown();
    }

    private static long countSingleThread(int[] numbers) {
        long count = 0;
        for (int number : numbers) {
            if (number < 10) {
                count++;
            }
        }
        return count;
    }

    static class CountTask extends RecursiveTask<Long> {
        private final int[] numbers;
        private final int start;
        private final int end;

        public CountTask(int[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                long count = 0;
                for (int i = start; i < end; i++) {
                    if (numbers[i] < 10) {
                        count++;
                    }
                }
                return count;
            } else {
                int mid = (start + end) / 2;
                CountTask leftTask = new CountTask(numbers, start, mid);
                CountTask rightTask = new CountTask(numbers, mid, end);
                leftTask.fork();
                long rightResult = rightTask.compute();
                long leftResult = leftTask.join();
                return leftResult + rightResult;
            }
        }
    }

    private static long countWithThreadPool(ExecutorService executor, int[] numbers) throws InterruptedException, ExecutionException {
        int chunkSize = numbers.length / NUM_THREADS;
        Future<Long>[] futures = new Future[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            final int start = i * chunkSize;
            final int end = (i == NUM_THREADS - 1) ? numbers.length : (i + 1) * chunkSize;
            futures[i] = executor.submit(() -> {
                long count = 0;
                for (int j = start; j < end; j++) {
                    if (numbers[j] < 10) {
                        count++;
                    }
                }
                return count;
            });
        }

        long totalCount = 0;
        for (Future<Long> future : futures) {
            totalCount += future.get();
        }
        return totalCount;
    }
}