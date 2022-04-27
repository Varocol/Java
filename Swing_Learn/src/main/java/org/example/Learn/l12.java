package org.example.Learn;

import javax.swing.*;
import java.awt.*;

public class l12 {
    public static void main(String[] args) {
        l12_frame myframe = new l12_frame("mf1");
    }
}

class l12_frame extends JFrame {
    JPanel panel1 = new JPanel();
    LayoutManager layout1 = new FlowLayout();

    public l12_frame(String title) {
        super(title);
        Init();
    }

    public l12_frame() {
        Init();
    }

    void Init() {

        panel1.setLayout(layout1);
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocation(800, 400);
        setVisible(true);
    }
}
