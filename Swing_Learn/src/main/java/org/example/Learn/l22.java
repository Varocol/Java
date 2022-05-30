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
    mypicture mypicture = new mypicture("img/北华大学嵌入式实验室图标.png",Color.WHITE,false);

    public l22_frame(String title) {
        super(title);
        Init();
    }

    public l22_frame() {
        Init();
    }


    void Init() {

        mypicture.setPreferredSize(new Dimension(400, 400));
        panel1.add(mypicture);
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocation(800, 400);
        setVisible(true);
    }
}
