public class SynTest {
  public static void main(String args[]) throws InterruptedException {
    SynThread1 s = new SynThread1("1");
    new Thread(s).start();
    new Thread(s).start();
  }

}


class SynThread1 implements Runnable {
  String name;

  public SynThread1(String name) {
    this.name = name;
  }

  public void run() {
    try {
      syn(name);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void syn(String userName) throws Exception {
    synchronized (userName) {
      System.out.println("进入到同步块，userName=" + userName);
      Thread.sleep(5000);  //5秒
      System.out.println("退出同步块，userName=" + userName);
    }
  }
}