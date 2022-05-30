package org.example.Learn;

import af.swing.layout.VLayout;

import javax.swing.*;
import java.awt.*;

public class l27 {
    public static void main(String[] args) {
        l27_frame myframe = new l27_frame("mf1");
    }
}

class l27_frame extends JFrame {

    JPanel panel1 = new JPanel();
    mypicture mypicture = new mypicture("img/北华大学嵌入式实验室图标.png", Color.WHITE, false);
    JLabel label1 = new JLabel("label1");
    LayoutBox layoutBox =
            new LayoutBox().padding(10).bgColor(Color.WHITE).layout(new VLayout(4));


    public l27_frame(String title) {
        super(title);
        Init();
    }

    public l27_frame() {
        Init();
    }


    void Init() {

        label1.setOpaque(true);
        label1.setBackground(Color.RED);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setPreferredSize(new Dimension(200, 200));

        mypicture.setPreferredSize(new Dimension(200, 200));


//        layoutBox.padding(10);
//        layoutBox.bgColor(Color.BLUE);
//        layoutBox.layout(new VLayout(4));

        //添加组件必须在layoutbox之后
        layoutBox.add(mypicture);
        layoutBox.add(label1);

        setContentPane(layoutBox);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocation(800, 400);
        setVisible(true);
    }
}
