package me.yushuo.concurrency.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample1 {
    public void count1(int j) {
        synchronized(this) {
            for (int i = 0; i < 10; i++) {
                log.info("thread 1 {} - {}", j, i);
            }
        }
    }

    public synchronized void count2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("thread 2 {} - {}", j, i);
        }
    }
    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.count1(1);
        });
        executorService.execute(() -> {
            example2.count1(2);
        });
    }
}
