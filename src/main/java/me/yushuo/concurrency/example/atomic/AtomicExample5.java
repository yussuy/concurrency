package me.yushuo.concurrency.example.atomic;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import me.yushuo.concurrency.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicExample5 {

    public static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    public volatile int count = 100;

    public static void main(String[] args) throws Exception {
        AtomicExample5 example5 = new AtomicExample5();

        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success 1:{}", example5.getCount());
        }

        if (updater.compareAndSet(example5, 100, 150)) {
            log.info("update success 2:{}", example5.getCount());
        } else {
            log.info("update fail:{}", example5.getCount());
        }
    }

}
