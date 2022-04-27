package org.example.Learn;

import javax.swing.*;


public class l2 {
    public static void main(String[] args) {
        JButton button1 = new JButton("b1");
        JPanel panel1 = new JPanel();
        JFrame frame1 = new JFrame("f1");
        panel1.add(button1);
        frame1.setContentPane(panel1);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocation(800,400);
        frame1.setSize(300,400);
        frame1.setVisible(true);
    }
}
