package me.yushuo.concurrency.example.threadlocal;

public class RequestHolder {
    // ThreadLocal内部是map，key是线程名称，value是传进去的值。
    private final static ThreadLocal<Long> id = new ThreadLocal<>();
}
