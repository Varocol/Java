package org.example.Learn;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class l23 {
    public static void main(String[] args) {
        l23_frame myframe = new l23_frame("mf1");
    }
}

class l23_frame extends JFrame {

    JPanel panel1 = new JPanel();
    mypicture mypicture = new mypicture("/ic_like.jpg",Color.WHITE,true);

    public l23_frame(String title) {
        super(title);
        Init();
    }

    public l23_frame() {
        Init();
    }


    void Init() {

        mypicture.setImage("/ic_star.jpg",true);
        mypicture.setPreferredSize(new Dimension(113, 113));
        panel1.add(mypicture);
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocation(800, 400);
        setIconImage(new ImageIcon("img/ic_like.jpg").getImage());
        setVisible(true);
    }
}
