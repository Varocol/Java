package org.example.Learn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


public class l6 {
    public static void main(String[] args) {
        l6_Myframe myframe1 = new l6_Myframe("mf1");
    }
}

class l6_Myframe extends JFrame {
    JLabel label1 = new JLabel("00:00:00");

    public l6_Myframe() {
        Init();
    }

    public l6_Myframe(String title) {
        super(title);
        Init();
    }

    void Init() {
        JButton button1 = new JButton("b1");
        JPanel panel1 = new JPanel();
        final SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String time = s.format(new Date());
                label1.setText(time);
                System.out.println(time);
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