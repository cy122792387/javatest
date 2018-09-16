package com.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
  public static void main(String[] args) {
    long num_block = 10956996 + 10858822 + 11784915 + 10337328 + 10372948 +
        13325820 + 6523873 + 6525649 + 2405802 + 2474023 + 2384165 + 2392118 + 2470552 + 2406144;
    System.out.println(num_block);
    System.out.println((double) (5/14*5/14*5/14*2+4/14*4/14*4/14)*100);
    System.out.println((double) (5*5*5*5*5*5*4*4*4*100/14/14/14/14/14/14));
    System.out.println(num_block/3*13/100);
    int num_rack = 3;
    int num_move = 0;
    for (int i = 0; i < num_block; i++) {
      long b1 = System.currentTimeMillis() % 3;
      long b2 = System.currentTimeMillis() % 3;
      long b3 = (long) Math.random()*10000 % 3;
      if (b1 == b2 && b1 == b3) num_move++;
    }
    System.out.println(num_move);
  }


}
