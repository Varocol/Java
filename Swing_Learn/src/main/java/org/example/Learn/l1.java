package org.example.Learn;


import javax.swing.*;

public class l1 {
    public static void main(String[] args) {
        //JFrame 指一个窗口，构造方法的参数为窗口标题
        JFrame frame = new JFrame("l1");
        JFrame frame1 = new JFrame("l2");
        //当关闭窗口时。退出整个程序(在Swing高级篇教程中会介绍)
        //HIDE_ON_CLOSE         将程序窗口关闭，但程序仍在后台运行
        //DISPOSE_ON_CLOSE      将程序窗口关闭，但程序资源已被释放，但是其他窗口不会被释放
        //EXIT_ON_CLOSE         将程序窗口关闭，所有窗口关闭
        //DO_NOTHING_ON_CLOSE   什么也不做
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小
        frame.setSize(400, 300);
        frame1.setSize(400, 300);
        //设置窗口的标题
        frame.setTitle("l3");
        frame1.setTitle("l4");
        //显示窗口
        frame.setVisible(true);
        frame1.setVisible(true);

    }
}
