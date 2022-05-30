package Tools;

import java.text.SimpleDateFormat;

public class ThreadInfo {
    public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void printThreadInfo(String msg) {
//        System.out.println(formatter.format(new Date()) + " Thread name: " + Thread.currentThread().getName() + " is Running... " + msg);
    }
}
