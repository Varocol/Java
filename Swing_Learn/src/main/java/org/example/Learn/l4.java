package org.example.Learn;

import javax.swing.*;


public class l4 {
    public static void main(String[] args) {
        l4_Myframe myframe1 = new l4_Myframe("mf1");
    }
}

class l4_Myframe extends JFrame {

    public l4_Myframe() {
        Init();
    }

    public l4_Myframe(String title) {
        super(title);
        Init();
    }

    void Init() {
        JButton button1 = new JButton("b1");
        JLabel label1 = new JLabel("label1");
        JPanel panel1 = new JPanel();
        panel1.add(button1);
        panel1.add(label1);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(800, 400);
        this.setSize(300, 400);
        this.setVisible(true);
    }
}