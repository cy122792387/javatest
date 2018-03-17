package acom.code.template;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Run {
    public static void main(String[] args) throws InterruptedException {
    
    }
}

class ThreadA extends Thread {
    Object a;
    
    public ThreadA(Object a) {
        this.a = a;
    }
    
    @Override
    public void run() {
    }
}

class ThreadB extends Thread {
    Object a;
    
    public ThreadB(Object a) {
        this.a = a;
    }
    
    @Override
    public void run() {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
