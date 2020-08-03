package kz.proger.test.forkjoin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FJDemo {
    private static final Logger logger = LoggerFactory.getLogger(FJDemo.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long from = 1L;
        long to = 1_000_000_000L;
        seqCalc(from, to);
        fjCalc(from, to);
    }


    public static void fjCalc(Long from, Long to) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        ForkJoinPool pool = ForkJoinPool.commonPool();
        Long result = pool.submit(new SumOfNumbers(from, to)).get();
        long time = System.currentTimeMillis() - startTime;
        logger.info("time of FJ: {}", time);

        logger.info("FJ: sum of {} to {} is {}", from, to, result);
    }

    public static void seqCalc(Long from, Long to) {
        long startTime = System.currentTimeMillis();

        long result = 0L;
        for (long i = from; i <= to; i++) {
            result += i;
        }

        long time = System.currentTimeMillis() - startTime;
        logger.info("time of SEQ: {}", time);

        logger.info("SEQ: sum of {} to {} is {}", from, to, result);
    }
}

class SumOfNumbers extends RecursiveTask<Long> {
    private static final Logger logger = LoggerFactory.getLogger(SumOfNumbers.class);
    private final Long from;
    //inclusive
    private final Long to;
    private final Long threshHold;

    public SumOfNumbers(Long from, Long to) {
        this.from = from;
        this.to = to;
        this.threshHold = (to - from) / (7 * 10);
    }

    public SumOfNumbers(Long from, Long to, Long threshHold) {
        this.from = from;
        this.to = to;
        this.threshHold = threshHold;
    }

    @Override
    protected Long compute() {
        long size = to - from + 1;
        long result = 0L;

        if (size <= threshHold) {
            logger.info("task is small enough computing result");
            for (long i = from; i <= to; i++) {
                result += i;
            }
        } else {
            logger.info("task is too big");
            long mid = (from + to) / 2L;
            SumOfNumbers task1 = new SumOfNumbers(from, mid, threshHold);
            SumOfNumbers task2 = new SumOfNumbers(mid + 1, to, threshHold);
            invokeAll(task1, task2);

            Long res2 = task2.join();
            Long res1 = task1.join();

            result = result + res2 + res1;
        }
        return result;
    }
}
