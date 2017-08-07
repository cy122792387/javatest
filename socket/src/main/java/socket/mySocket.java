package socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class mySocket {
  public static void main(String[] args) throws UnknownHostException {
    InetAddress address = InetAddress.getLocalHost();
    System.out.println("hostname = "+address.getHostName());
    System.out.println("ip = "+address.getHostAddress());
//    System.out.println("hostname = "+address.getHostName());
    byte[] bytes = address.getAddress();
    System.out.println("ip = "+ Arrays.toString(bytes));
  }
}
