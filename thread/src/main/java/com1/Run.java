package com1;


class Task {
    private String getDatal;
    private String getData2;
    
    public synchronized void doLongTimeTask() {
        try {
            System.out.println("begin task ");
            Thread.sleep(3000);
            getDatal = " 长时间处理任务后从远程返回的值 1 threadNarne= "
                + Thread.currentThread().getName();
            getData2 = " 长时间处理任务后从远程返回的值 2  threadName= "
                + Thread.currentThread().getName();
            System.out.println(getDatal);
            System.out.println(getData2);
            System.out.println("end  task ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CommonUtils {
    public static long beginTimel;
    public static long endTimel;
    public static long beginTime2;
    public static long endTime2;
}

class MyThread1 extends Thread {
    private Task task;
    
    public MyThread1(Task task) {
        this.task = task;
    }
    
    @Override
    public void run() {
        super.run();
        CommonUtils.beginTimel = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTimel = System.currentTimeMillis();
    }
}

class MyThread2 extends Thread {
    private Task task;
    
    public MyThread2(Task task) {
        super();
        this.task = task;
    }
    
    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime2 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }
}

public class Run {
    public static void main(String[] args) {
        Task task = new Task();
        MyThread1 Thread1 = new MyThread1(task);
        MyThread2 Thread2 = new MyThread2(task);
        Thread1.start();
        Thread2.start();
        try {
            Thread.sleep(13333);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long beginTime = CommonUtils.beginTimel;
        if (CommonUtils.beginTime2 < beginTime)
            beginTime = CommonUtils.beginTime2;
        long endTime = CommonUtils.endTimel;
        if (CommonUtils.endTime2 > endTime)
            endTime = CommonUtils.endTime2;
        System.out.println("耗时：" + (endTime - beginTime) / 1000);
    }
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    