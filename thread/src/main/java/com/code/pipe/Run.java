package com.code.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Run {
    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();
            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();
            //inputStream.connect(outputStream);
            outputStream.connect(inputStream);
            ThreadRead threadRead = new ThreadRead(readData, inputStream);
            threadRead.start();
            Thread.sleep(2000);
            ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
            threadWrite.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadWrite extends Thread {
    WriteData write;
    PipedOutputStream out;
    
    public ThreadWrite(WriteData write, PipedOutputStream out) {
        this.write = write;
        this.out = out;
    }
    
    @Override
    public void run() {
        write.writeMethod(out);
    }
}

class ThreadRead extends Thread {
    ReadData read;
    PipedInputStream input;
    
    public ThreadRead(ReadData read, PipedInputStream input) {
        this.read = read;
        this.input = input;
    }
    
    @Override
    public void run() {
        read.readMethod(input);
    }
}

class WriteData {
    public void writeMethod(PipedOutputStream out) {
        System.out.println("write: ");
        try {
            for (int i = 0; i < 300; i++) {
                String outDate = "" + (i + 1);
                out.write(outDate.getBytes());
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReadData {
    public void readMethod(PipedInputStream input) {
        try {
            System.out.println("read: ");
            byte[] byteArray = new byte[20];
            int length = input.read(byteArray);
            while (length != -1) {
                String newData = new String(byteArray, 0, length);
                System.out.println("---"+newData);
                length = input.read(byteArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}