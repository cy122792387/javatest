package socket;

import java.io.*;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Thread t1 = new Thread(new clientThread());
        t1.setName("T1");
        t1.start();
        Thread t2 = new Thread(new clientThread());
        t2.setName("T2");
        t2.start();
        Thread t3 = new Thread(new clientThread());
        t3.setName("T3");
        t3.start();
    }
}

class clientThread implements Runnable {
    private Socket socket;
    
    public clientThread() throws IOException {
        this.socket = new Socket("localhost", 8000);
    }
    
    public void run() {
        talk();
    }
    
    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut, true);
    }
    
    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }
    
    public void talk() {
        try {
            BufferedReader br = getReader(socket);
            PrintWriter pw = getWriter(socket);
            //BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
            //String msg = null;
            String[] msgs = {"aaa", "bbb", "ccc"};
            //while ((msg = localReader.readLine()) != null) {
            for (int i = 0; i < msgs.length; i++) {
                pw.println(Thread.currentThread().getName() + ":" + msgs[i]);
                System.out.println(br.readLine());
                if (msgs[i].equals("bye")) break;
            }
        } catch (
            IOException e)
        
        {
            e.printStackTrace();
        } finally
        
        {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
