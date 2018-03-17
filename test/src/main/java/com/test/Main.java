package com.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        Main main = new Main();
        Queue queue = new LinkedList();
        System.out.println(1489 & 5);
        TreeMap<Integer, String> b = new TreeMap<Integer, String>();
        
        ConcurrentLinkedQueue a;
    }
    
    public int getMod(int a, int b) {
        return a % b;
    }
    
    public int getMod1(int a, int b) {
        return a & (b - 1);
    }
    
}
