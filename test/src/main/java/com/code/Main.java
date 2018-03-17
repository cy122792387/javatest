package com.code;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *类加载器与instanceof关键字演示
 *
 *@author zzm
 */
public class Main {
    public static void main(String[] args) {
        
        System.out.println("请输入2个加数");
        int result;
        try {
            result = add();
            System.out.println("结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //获取输入的2个整数返回
    private static List<Integer> getInputNumbers() {
        List<Integer> nums = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        try {
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            nums.add(new Integer(num1));
            nums.add(new Integer(num2));
        } catch (InputMismatchException immExp) {
            throw immExp;
        } finally {
            scan.close();
        }
        return nums;
    }
    
    //执行加法计算
    private static int add() throws Exception {
        int result;
        try {
            List<Integer> nums = getInputNumbers();
            result = nums.get(0) + nums.get(1);
        } catch (InputMismatchException immExp) {
            throw new Exception("计算失败", immExp);  /////////////////////////////链化:以一个异常对象为参数构造新的异常对象。
        }
        return result;
    }
}

