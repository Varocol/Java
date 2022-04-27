package org.example.Learn;

import javax.swing.*;
import java.awt.*;

public class l21 {
    public static void main(String[] args) {
        l21_frame myframe = new l21_frame("mf1");
    }
}

class l21_frame extends JFrame {

    JPanel panel1 = new JPanel();
    mycontrol mycontrol = new mycontrol();
    public l21_frame(String title) {
        super(title);
        Init();
    }

    public l21_frame() {
        Init();
    }


    void Init() {

        mycontrol.setPreferredSize(new Dimension(200, 200));
        panel1.add(mycontrol);
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocation(800, 400);
        setVisible(true);
    }
}
