package com.tosan.core.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleObject {

    private volatile int a;

    private final Object lockObject = new Object();

    public void increase() throws InterruptedException {

        synchronized (lockObject) {
            lockObject.wait();
            a++;
        }
        System.out.println(Thread.currentThread().getName() + "_" + a);
    }


    public void decrease() {
        synchronized (lockObject) {
            lockObject.notify();
            a--;
        }
        System.out.println(Thread.currentThread().getName() + "_" + a);

    }


    public void lockTest() {
        Lock lock = new ReentrantLock();

        lock.lock();
        lock.unlock();
    }


    public void semaTest() {
        Semaphore semaphore = new Semaphore(2);

    }


    public void countDownLatchTest() {
        CountDownLatch cdl = new CountDownLatch(10);

        cdl.countDown();
    }


    public void executorsTest() {
        Executor executor = Executors.newCachedThreadPool();

        executor.execute(() -> System.out.println(a));
    }


}
