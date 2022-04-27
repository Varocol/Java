package org.example.Learn;

import af.swing.layout.HLayout;
import af.swing.layout.VLayout;

import javax.swing.*;
import java.awt.*;

public class l15 {
    public static void main(String[] args) {
        l15_frame myframe = new l15_frame("mf1");
    }
}

class l15_frame extends JFrame {
    JPanel panel1 = new JPanel();
    LayoutManager layout1 = new FlowLayout();
    LayoutManager layout2 = new BorderLayout();
    LayoutManager layout3 = new HLayout();
    LayoutManager layout4 = new VLayout(10);

    l11_label label1 = new l11_label("Label 1", Color.red);
    l11_label label2 = new l11_label("Label 2", Color.blue);
    l11_label label3 = new l11_label("Label 3", Color.green);
    l11_label label4 = new l11_label("Label 4", Color.yellow);
    l11_label label5 = new l11_label("Label 5", Color.orange);

    public l15_frame(String title) {
        super(title);
        Init();
    }

    public l15_frame() {
        Init();
    }

    void Init() {

        panel1.setLayout(layout4);
        panel1.add(label1, "100px"); // 高度，固定占 100px
        panel1.add(label2, "50%");   // 高度，百分比占 50%
        panel1.add(label3, "auto");  // 高度，自动分配，不能用
        panel1.add(label4, "1w");    // 高度，按权重分配
        panel1.add(label5, "1w");    // 高度，按权重分配

//
//        label5.setPreferredSize(new Dimension(100, label1.setPreferredSize(new Dimension(0, 100));
////        label2.setPreferredSize(new Dimension(0, 100));
////        label3.setPreferredSize(new Dimension(100, 0));
////        label4.setPreferredSize(new Dimension(100, 0));100));

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocation(800, 400);
        setVisible(true);
    }
}
