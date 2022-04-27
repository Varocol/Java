package org.example.Learn;

import af.swing.layout.FreeLayout;
import af.swing.layout.HLayout;
import af.swing.layout.Margin;
import af.swing.layout.VLayout;

import javax.swing.*;
import java.awt.*;

public class l17 {
    public static void main(String[] args) {
        l17_frame myframe = new l17_frame();
    }
}

class l17_frame extends JFrame {
    JPanel panel1 = new JPanel();
    l11_label label1 = new l11_label("Label 1", Color.red);
    l11_label label2 = new l11_label("Label 2", Color.blue);
    l11_label label3 = new l11_label("Label 3", Color.green);
    l11_label label4 = new l11_label("Label 4", Color.yellow);
    l11_label label5 = new l11_label("Label 5", Color.orange);

    public l17_frame(String title) {
        super(title);
        Init();
    }

    public l17_frame() {
        Init();
    }

    void Init() {

        panel1.setLayout(null);
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);
        panel1.add(label4);
        panel1.add(label5);

        label1.setBounds(10, 10, 100, 20);
        label2.setBounds(10, 40, 100, 20);
        label3.setBounds(10, 70, 100, 20);
        label4.setBounds(10, 100, 100, 20);
        label5.setBounds(10, 130, 100, 20);

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocation(800, 400);
        setVisible(true);
    }
}
