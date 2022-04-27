package org.example.Learn;

import af.swing.layout.FreeLayout;
import af.swing.layout.HLayout;
import af.swing.layout.Margin;
import af.swing.layout.VLayout;

import javax.swing.*;
import java.awt.*;

public class l16 {
    public static void main(String[] args) {
        l16_frame myframe = new l16_frame("mf1");
    }
}

class l16_frame extends JFrame {
    JPanel panel1 = new JPanel();
    LayoutManager layout1 = new FlowLayout();
    LayoutManager layout2 = new BorderLayout();
    LayoutManager layout3 = new HLayout();
    LayoutManager layout4 = new VLayout(10);
    LayoutManager layout5 = new FreeLayout();

    l11_label label1 = new l11_label("Label 1", Color.red);
    l11_label label2 = new l11_label("Label 2", Color.blue);
    l11_label label3 = new l11_label("Label 3", Color.green);
    l11_label label4 = new l11_label("Label 4", Color.yellow);
    l11_label label5 = new l11_label("Label 5", Color.orange);

    public l16_frame(String title) {
        super(title);
        Init();
    }

    public l16_frame() {
        Init();
    }

    void Init() {

        panel1.setLayout(layout5);
        panel1.add(label1, new Margin(10, 10, -1, -1));
        panel1.add(label2, new Margin(10, -1, -1, 10));
        panel1.add(label3, new Margin(-1, 10, 10, -1));
        panel1.add(label4, new Margin(-1, -1, 10, 10));
        panel1.add(label5, new Margin(10, 10, 10, 10));

//        label1.setPreferredSize(new Dimension(0, 100));
//        label2.setPreferredSize(new Dimension(0, 100));
//        label3.setPreferredSize(new Dimension(100, 0));
//        label4.setPreferredSize(new Dimension(100, 0));
//        label5.setPreferredSize(new Dimension(100, 100));

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocation(800, 400);
        setVisible(true);
    }
}
