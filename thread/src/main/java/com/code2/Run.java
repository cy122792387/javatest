package com.code2;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        ThreadAA aa = new ThreadAA(service);
        ThreadB b = new ThreadB(service);
        ThreadBB bb = new ThreadBB(service);
        a.setName("a");
        aa.setName("aa");
        b.setName("b");
        bb.setName("bb");
        a.start();
        aa.start();
        //Thread.sleep(100);
        b.start();
        bb.start();
    }
}

class ThreadA extends Thread {
    MyService myService;
    
    public ThreadA(MyService myService) {
        this.myService = myService;
    }
    
    @Override
    public void run() {
        myService.methodA();
    }
}

class ThreadAA extends Thread {
    MyService myService;
    
    public ThreadAA(MyService myService) {
        this.myService = myService;
    }
    
    @Override
    public void run() {
        myService.methodA();
    }
}

class ThreadB extends Thread {
    MyService myService;
    
    public ThreadB(MyService myService) {
        this.myService = myService;
    }
    
    @Override
    public void run() {
        myService.methodB();
    }
}

class ThreadBB extends Thread {
    MyService myService;
    
    public ThreadBB(MyService myService) {
        this.myService = myService;
    }
    
    @Override
    public void run() {
        myService.methodB();
    }
}

class MyService {
    private Lock lock = new ReentrantLock();
    
    public void methodA() {
        try {
            lock.lock();
            System.out.println("methodA begin ThreadName = " + Thread.currentThread().getName() + "  time = " + new Date());
            Thread.sleep(3000);
            System.out.println("methodA end   ThreadName = " + Thread.currentThread().getName() + "  time = " + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    
    public void methodB() {
        try {
            lock.lock();
            System.out.println("methodB begin ThreadName = " + Thread.currentThread().getName() + "  time = " + new Date());
            Thread.sleep(3000);
            System.out.println("methodB end   ThreadName = " + Thread.currentThread().getName() + "  time = " + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
