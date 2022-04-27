package org.example.Learn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class l8 {
    public static void main(String[] args) {
        l8_Myframe myframe1 = new l8_Myframe("mf1");
    }
}

class l8_Myframe extends JFrame {

    JButton button1 = new JButton("b1");
    JPanel panel1 = new JPanel();
    JTextField textField1 = new JTextField(20);
    JCheckBox checkBox1 = new JCheckBox("cb1");

    public l8_Myframe() {
        Init();
    }

    public l8_Myframe(String title) {
        super(title);
        Init();
    }

    void Init() {
        panel1.add(textField1);
        panel1.add(button1);
        panel1.add(checkBox1);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField1.getText());
            }
        });
        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(checkBox1.isSelected());
            }
        });

        checkBox1.setSelected(false);
        button1.setEnabled(false);
        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setEnabled(checkBox1.isSelected());
            }
        });

        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(800, 400);
        this.setSize(300, 400);
        this.setVisible(true);
    }
}