package org.example.Learn;

import javax.swing.*;
import java.awt.*;

public class l22 {
    public static void main(String[] args) {
        l22_frame myframe = new l22_frame("mf1");
    }
}

class l22_frame extends JFrame {

    JPanel panel1 = new JPanel();
    mycontrol mycontrol = new mycontrol();
    public l22_frame(String title) {
        super(title);
        Init();
    }

    public l22_frame() {
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
