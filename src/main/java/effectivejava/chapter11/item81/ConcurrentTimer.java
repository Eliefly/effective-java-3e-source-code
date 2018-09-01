package effectivejava.chapter11.item81;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Simple framework for timing concurrent execution 327
public class ConcurrentTimer {
    private ConcurrentTimer() {
    } // Noninstantiable

    /**
     * 多个线程同时执行单个任务，并等待最后的执行单元完成
     *
     * @param executor    执行单元
     * @param concurrency 同时执行任务数，并发数
     * @param action      任务动作
     * @return
     * @throws InterruptedException
     */
    public static long time(Executor executor, int concurrency,
                            Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                ready.countDown(); // Tell timer we're ready
                try {
                    start.await(); // Wait till peers are ready
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown();  // Tell timer we're done
                }
            });
        }

        ready.await();     // Wait for all workers to be ready
        long startNanos = System.nanoTime();
        start.countDown(); // And they're off!
        done.await();      // Wait for all workers to finish
        return System.nanoTime() - startNanos;
    }

    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(5);
        long time = time(executor, 3, () -> System.out.println(new Date()));
        System.out.println(time);
    }
}
