package org.example.Learn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class l5 {
    public static void main(String[] args) {
        l5_Myframe myframe1 = new l5_Myframe("mf1");
    }
}

class l5_Myframe extends JFrame {

    public l5_Myframe() {
        Init();
    }

    public l5_Myframe(String title) {
        super(title);
        Init();
    }

    void Init() {
        JButton button1 = new JButton("b1");
        JLabel label1 = new JLabel("label1");
        JPanel panel1 = new JPanel();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("123");
            }
        });
        panel1.add(button1);
        panel1.add(label1);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(800, 400);
        this.setSize(300, 400);
        this.setVisible(true);
    }
}