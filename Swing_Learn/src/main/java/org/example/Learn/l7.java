package org.example.Learn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


public class l7 {
    public static void main(String[] args) {
        l7_Myframe myframe1 = new l7_Myframe("mf1");
    }
}

class l7_Myframe extends JFrame {

    public l7_Myframe() {
        Init();
    }

    public l7_Myframe(String title) {
        super(title);
        Init();
    }

    void Init() {
        JButton button1 = new JButton("b1");
        JPanel panel1 = new JPanel();
        final JTextField textField1 = new JTextField(20);
        panel1.add(textField1);
        panel1.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField1.getText());
            }
        });
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(800, 400);
        this.setSize(300, 400);
        this.setVisible(true);
    }
}