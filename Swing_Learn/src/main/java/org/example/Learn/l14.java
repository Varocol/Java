package org.example.Learn;

import af.swing.layout.HLayout;

import javax.swing.*;
import java.awt.*;

public class l14 {
    public static void main(String[] args) {
        l14_frame myframe = new l14_frame("mf1");
    }
}

class l14_frame extends JFrame {
    JPanel panel1 = new JPanel();
    LayoutManager layout1 = new FlowLayout();
    LayoutManager layout2 = new BorderLayout();
    LayoutManager layout3 = new HLayout(10);

    l11_label label1 = new l11_label("Label 1", Color.red);
    l11_label label2 = new l11_label("Label 2", Color.blue);
    l11_label label3 = new l11_label("Label 3", Color.green);
    l11_label label4 = new l11_label("Label 4", Color.yellow);
    l11_label label5 = new l11_label("Label 5", Color.orange);

    public l14_frame(String title) {
        super(title);
        Init();
    }

    public l14_frame() {
        Init();
    }

    void Init() {

        panel1.setLayout(layout3);
        panel1.add(label1, "100px"); // 宽度，固定占 100px
        panel1.add(label2, "50%");   // 宽度，百分比占 50%
        panel1.add(label3, "auto");  // 宽度，自动按需分配
        panel1.add(label4, "1w");    // 宽度，按权重分配
        panel1.add(label5, "1w");    // 宽度，按权重分配

        label1.setPreferredSize(new Dimension(0, 100));
        label2.setPreferredSize(new Dimension(0, 100));
        label3.setPreferredSize(new Dimension(100, 0));
        label4.setPreferredSize(new Dimension(100, 0));
//        label5.setPreferredSize(new Dimension(100, 100));

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocation(800, 400);
        setVisible(true);
    }
}
