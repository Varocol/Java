package org.example.Learn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class l29 {
    public static void main(String[] args) {
        l29_frame myframe = new l29_frame("mf1");
    }
}

class l29_frame extends JFrame {

    JButton button1 = new JButton("确认提示框");
    JButton button2 = new JButton("消息提示框");
    JButton button3 = new JButton("输入提示框");
    JPanel panel = new JPanel();

    public l29_frame(String title) {
        super(title);
        Init();
    }

    public l29_frame() {
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

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("鼠标点击了");
                if(e.getButton()==MouseEvent.BUTTON3){
                    JPopupMenu jPopupMenu = new JPopupMenu();
                    JMenuItem jMenuItem = new JMenuItem("菜单1");
                    jPopupMenu.add(jMenuItem);
                    jPopupMenu.show(e.getComponent(),e.getX(),e.getY());
                }
            }
        });

        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocation(800, 400);
        setVisible(true);
    }

    private void test1() {
        mydialog mydialog = new mydialog(this);
        boolean result = mydialog.exec();
        if (result) {
            System.out.println(mydialog.get_text());
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
