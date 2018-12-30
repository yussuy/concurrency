package me.yushuo.concurrency.atomic;

import lombok.extern.slf4j.Slf4j;
import me.yushuo.concurrency.annotations.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@ThreadSafe
public class AtomicExample4 {

    public static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) throws Exception {
        count.compareAndSet(0, 1);  // 1
        count.compareAndSet(0, 2);  // no
        count.compareAndSet(1, 3);  // 3
        count.compareAndSet(2, 4);  // no
        count.compareAndSet(3, 5);  // 5
        log.info("count:{}", count.get());
    }

}
