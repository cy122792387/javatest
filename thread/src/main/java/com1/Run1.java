package com1;

public class Run1 {
    public static void main(String[] args) {
        ObjectService service = new ObjectService();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);
        threadA.setName("a");
        threadB.setName("b");
        threadA.start();
        threadB.start();
    }
}

class ThreadA extends Thread {
    
    ObjectService service;
    
    public ThreadA(ObjectService service) {
        this.service = service;
    }
    
    @Override
    public void run() {
        service.serviceMethod();
    }
}

class ThreadB extends Thread {
    
    ObjectService service;
    
    public ThreadB(ObjectService service) {
        this.service = service;
    }
    
    @Override
    public void run() {
        service.serviceMethod();
    }
}

class ObjectService {
    public void serviceMethod() {
        synchronized (this) {
            System.out.println("begin time = " + System.currentTimeMillis());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end time = " + System.currentTimeMillis());
            
        }
    }
}