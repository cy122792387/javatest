package com.code.entity;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        
        MyStack myStack = new MyStack();
        P_Thread p_thread = new P_Thread(new P(myStack));
        C_Thread c_thread = new C_Thread(new C(myStack));
        C_Thread c_thread1 = new C_Thread(new C(myStack));
        C_Thread c_thread2 = new C_Thread(new C(myStack));
        C_Thread c_thread3 = new C_Thread(new C(myStack));
        C_Thread c_thread4 = new C_Thread(new C(myStack));
        p_thread.start();
        c_thread.start();
        c_thread1.start();
        c_thread2.start();
        c_thread3.start();
        c_thread4.start();
    }
    
}

class MyStack {
    List list = new ArrayList();
    
    synchronized public void push() {
        while (list.size() == 1) {
            System.out.println("size=1 push操作中断:" + Thread.currentThread().getName() + "线程呈等待状态");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add("anyString" + Math.random());
        System.out.println("push之后 size=" + list.size());
        this.notify();
    }
    
    synchronized public String pop() {
        String returnValue = "";
        while (list.size() == 0) {
            System.out.println("size=0 pop操作中断:" + Thread.currentThread().getName() + "线程呈等待状态");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        returnValue += list.get(0);
        list.remove(0);
        System.out.println("pop之后 size=" + list.size());
        this.notify();
        return returnValue;
    }
}

class P {
    MyStack myStack;
    
    public P(MyStack myStack) {
        this.myStack = myStack;
    }
    
    public void pushService() {
        myStack.push();
    }
}

class C {
    MyStack myStack;
    
    public C(MyStack myStack) {
        this.myStack = myStack;
    }
    
    public void popService() {
        myStack.pop();
    }
}

class P_Thread extends Thread {
    private P p;
    
    public P_Thread(P p) {
        this.p = p;
    }
    
    @Override
    public void run() {
        while (true) p.pushService();
    }
}

class C_Thread extends Thread {
    private C p;
    
    public C_Thread(C p) {
        this.p = p;
    }
    
    @Override
    public void run() {
        while (true) p.popService();
    }
}