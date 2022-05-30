package org.example.Learn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class l28 {
    public static void main(String[] args) {
        l28_frame myframe = new l28_frame("mf1");
    }
}

class l28_frame extends JFrame {

    JButton button1 = new JButton("确认提示框");
    JButton button2 = new JButton("消息提示框");
    JButton button3 = new JButton("输入提示框");
    JPanel panel = new JPanel();

    public l28_frame(String title) {
        super(title);
        Init();
    }

    public l28_frame() {
        Init();
    }


    void Init() {

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test1();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test2();
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test3();
            }
        });
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocation(800, 400);
        setVisible(true);
    }

    private void test1() {
        int result = JOptionPane.showConfirmDialog(null, "是否确认退出？", "提示", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void test2() {
        JOptionPane.showMessageDialog(null, "提示信息", "提示", JOptionPane.INFORMATION_MESSAGE);
    }

    private void test3() {
        String result = JOptionPane.showInputDialog(null, "请输入您的名字", "提示", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(result);
    }
}
