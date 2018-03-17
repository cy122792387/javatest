package com.code.backup;

public class Run {
    public static void main(String[] args) {
        DBTools dbTools = new DBTools();
        for (int i = 0; i < 20; i++) {
            BackupB output = new BackupB(dbTools);
            BackupA input = new BackupA(dbTools);
            output.start();
            input.start();
        }
    }
}

class BackupA extends Thread {
    DBTools dbTools;
    
    public BackupA(DBTools dbTools) {
        this.dbTools = dbTools;
    }
    
    @Override
    public void run() {
        dbTools.backupA();
    }
}

class BackupB extends Thread {
    DBTools dbTools;
    
    public BackupB(DBTools dbTools) {
        this.dbTools = dbTools;
    }
    
    @Override
    public void run() {
        dbTools.backupB();
    }
}

class DBTools {
    private boolean prevIsA = false;
    
    synchronized public void backupA() {
        while (prevIsA == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 1; i++) {
            System.out.println("❤❤❤❤❤");
        }
        prevIsA = true;
        notifyAll();
        
    }
    
    synchronized public void backupB() {
        while (prevIsA == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 1; i++) {
            System.out.println("-----");
        }
        prevIsA = false;
        notifyAll();
    }
}