package org.example.Learn;

import javax.swing.*;
import java.awt.*;

public class l13 {
    public static void main(String[] args) {
        l13_frame myframe = new l13_frame("mf1");
    }
}

class l13_frame extends JFrame {
    JPanel panel1 = new JPanel();
    LayoutManager layout1 = new FlowLayout();
    LayoutManager layout2 = new BorderLayout();

    l11_label label1 = new l11_label("Label 1", Color.red);
    l11_label label2 = new l11_label("Label 2", Color.blue);
    l11_label label3 = new l11_label("Label 3", Color.green);
    l11_label label4 = new l11_label("Label 4", Color.yellow);
    l11_label label5 = new l11_label("Label 5", Color.orange);

    public l13_frame(String title) {
        super(title);
        Init();
    }

    public l13_frame() {
        Init();
    }

    void Init() {

        panel1.setLayout(layout2);
        panel1.add(label1, BorderLayout.NORTH);
        panel1.add(label2, BorderLayout.SOUTH);
        panel1.add(label3, BorderLayout.WEST);
        panel1.add(label4, BorderLayout.EAST);
        panel1.add(label5, BorderLayout.CENTER);

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
