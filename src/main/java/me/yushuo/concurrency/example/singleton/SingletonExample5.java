package me.yushuo.concurrency.example.singleton;

import me.yushuo.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式 -> 双重同步锁单例模式
 * 单例实例在第一次使用时进行创建
 */
@ThreadSafe
public class SingletonExample5 {

    // 私有构造函数
    private SingletonExample5() {

    }

    // 1、 memory = allocate() 分配对象的内存空间
    // 2、 ctorInstance() 初始化对象
    // 3、 instance = memory 设置instance指向刚刚分配的内存

    // volatile避免指令重排，涉及volatile修饰对象的写操作，volatile禁止指令重排。

    // 单例对象
    private volatile static SingletonExample5 instance = null;

    // 静态的工厂方法
    public static SingletonExample5 getInstance() {
        if (instance == null) { // B
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5(); // A - 3
                }
            }
        }
        return instance;
    }
}
