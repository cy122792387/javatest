package com.code3;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwinsLockTest {
    public static void main(String[] args) throws InterruptedException {
        //final TwinsLock lock = new TwinsLock();
        final Lock lock = new ReentrantLock(true);
        class Worker extends Thread {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
// 启动10个线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setName("" + i);
            w.setDaemon(true);
            w.start();
            System.out.println(w.getName());
        }
// 每隔1秒换行
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("" + i + i + i + ".........." + i + i);
        }
    }
    
}
