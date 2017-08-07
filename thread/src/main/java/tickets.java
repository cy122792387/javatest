public class tickets {
  public static void main(String[] args) {
//    MyThread myThread = new MyThread();
//    myThread.start();
//    MyThread myThread2 = new MyThread();
//    myThread2.start();
//    MyThread myThread3 = new MyThread();
//    myThread3.start();

//    MyThread mt = new MyThread();
//    Thread t2 = new Thread(mt, "二号窗口");
//    Thread t1 = new Thread(mt, "一号窗口");
//    Thread t3 = new Thread(mt, "三号窗口");
//    t1.start();
//    t2.start();
//    t3.start();

//    MyRunnable mr = new MyRunnable();
//    Thread t1 = new Thread(mr, "一号窗口");
//    Thread t2 = new Thread(mr, "二号窗口");
//    Thread t3 = new Thread(mr, "三号窗口");
//    Thread t4 = new Thread(mr, "四号窗口");
//    t2.start();
//    t3.start();
//    t4.start();
  }
}

class MyThread extends Thread {
  private int ticket = 10;

  @Override
  public void run() {
    super.run();
    while (true) {
      if (ticket > 0) {
        System.out.println(Thread.currentThread().getName() + "出票一张" + ticket--);

      }
    }
  }
}

class MyRunnable implements Runnable {
  private int ticket = 10;

  public void run() {
    // TODO Auto-generated method stub
    while (true) {
      if (ticket > 0) {
        System.out.println(Thread.currentThread().getName() + "出票一张" + ticket--);

      }
    }

  }

}