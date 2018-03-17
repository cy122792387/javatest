package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
    private int port = 8000;
    private ServerSocket serverSocket;
    private ExecutorService executorService;
    private final int POOL_SIZE = 4;
    
    public static void main(String[] args) throws IOException {
        new EchoServer().service();
    }
    
    public EchoServer() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("服务器启动！");
        executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors() * POOL_SIZE);
        
    }
    
    public void service() throws IOException {
        while (true) {
            Socket socket = null;
            socket = serverSocket.accept();
            executorService.execute(new Handler(socket));
        }
    }
}

class Handler implements Runnable {
    private Socket socket;
    
    public Handler(Socket socket) {
        this.socket = socket;
    }
    
    public String echo(String msg) {
        return "echo:" + msg;
    }
    
    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut, true);
    }
    
    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream socketIn = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(socketIn));
    }
    
    public void run() {
        try {
            System.out.println("New connection accepted" +
                socket.getInetAddress() + "." + socket.getPort());
            BufferedReader br = getReader(socket);
            PrintWriter pw = getWriter(socket);
            String msg = null;
            while ((msg = br.readLine()) != null) {
                System.out.println(msg);
                pw.println(echo(msg));
                if (msg.equals("bye")) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
