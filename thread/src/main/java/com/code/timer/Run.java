package com.code.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run {
    private static Timer timer = new Timer();
    
    static public class MyTask extends TimerTask {
        
        public void run() {
            System.out.println("运行了！ 时间为：" + new Date());
        }
    }
    
    public static void main(String[] args) {
        try {
            MyTask task = new MyTask();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dayString = "2018-01-19 15:11:00";
            Date dateRef = sdf.parse(dayString);
            System.out.println("字符串时间：" + dateRef.toLocaleString() + "当前时间：" + new Date().toLocaleString());
            timer.schedule(task, dateRef,4000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
