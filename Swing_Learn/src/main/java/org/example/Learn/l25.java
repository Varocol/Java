package org.example.Learn;

import javax.swing.*;
import java.awt.*;

public class l25 {
    public static void main(String[] args) {
        l25_frame myframe = new l25_frame("mf1");
    }
}

class l25_frame extends JFrame {

    JPanel panel1 = new JPanel();
    mypicture mypicture = new mypicture("/ic_like.jpg", Color.WHITE, true);
    mycontrol mycontrol = new mycontrol();

    public l25_frame(String title) {
        super(title);
        Init();
    }

    public l25_frame() {
        Init();
    }


    void Init() {

        mycontrol.setPreferredSize(new Dimension(400, 400));
        panel1.add(mycontrol);

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocation(800, 400);
        setIconImage(new ImageIcon("img/ic_like.jpg").getImage());
        setVisible(true);
    }
}

