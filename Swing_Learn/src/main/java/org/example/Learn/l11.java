package org.example.Learn;

import javax.swing.*;
import java.awt.*;

public class l11 {
    public static void main(String[] args) {
        l11_frame myframe = new l11_frame("mf1");
    }
}

class l11_frame extends JFrame {
    JPanel panel1 = new JPanel();
    l11_label label1 = new l11_label("label1",Color.red);
    l11_label label2 = new l11_label("label2",Color.blue);
    l11_label label3 = new l11_label("label3",Color.green);
    l11_label label4 = new l11_label("label4",Color.yellow);
    public l11_frame(String title) {
        super(title);
        Init();
    }

    public l11_frame() {
        Init();
    }

    void Init() {
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);
        panel1.add(label4);

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocation(800, 400);
        setVisible(true);
    }
}

class l11_label extends JLabel {
    public l11_label(String text,Color color) {
        super(text);
        setBackground(color);
        Init();
    }
    public l11_label() {
        super();
        Init();
    }
    void Init() {
        setOpaque(true);
        setHorizontalAlignment(JLabel.CENTER);
        setPreferredSize(new Dimension(60, 30));
    }
}
