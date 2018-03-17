package com.code.danli;

public class Run {
    
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}

class MyObject {
    private static MyObject object = new MyObject();
    
    private MyObject() {
    }
    
    public static MyObject getInstance() {
        return object;
    }
}