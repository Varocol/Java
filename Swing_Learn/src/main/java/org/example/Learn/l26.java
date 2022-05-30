package org.example.Learn;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class l26 {
    public static void main(String[] args) {
        l26_frame myframe = new l26_frame("mf1");
    }
}

class l26_frame extends JFrame {

    JPanel panel1 = new JPanel();
    JLabel label1 = new JLabel("label1");
    JLabel label2 = new JLabel("label2");

    public l26_frame(String title) {
        super(title);
        Init();
    }

    public l26_frame() {
        Init();
    }


    void Init() {

        Border border = new LineBorder(Color.black, 2);

        label1.setPreferredSize(new Dimension(200, 100));
        label2.setPreferredSize(new Dimension(200, 100));

        label1.setBackground(Color.red);
        label2.setBackground(Color.blue);

        label1.setHorizontalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);

        label1.setOpaque(true);
        label2.setOpaque(true);

        label1.setBorder(border);
//        label2.setBorder(BorderFactory.createLineBorder(Color.red, 2));
//        label2.setBorder(BorderFactory.createDashedBorder(Color.red, 2,2,2,
//                false));
//        label2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,
//                Color.gray));
        //轻微浮雕效果
//        label2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        //轻微内嵌效果
//        label2.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        //浮雕效果
//        label2.setBorder(BorderFactory.createRaisedBevelBorder());
        //内嵌效果
//        label2.setBorder(BorderFactory.createLoweredBevelBorder());
        //线条效果
//        label2.setBorder(BorderFactory.createEtchedBorder());
        //标签边框
//        label2.setBorder(BorderFactory.createTitledBorder("边框"));
        //空白边框
//        label2.setBorder(BorderFactory.createEmptyBorder(6,6,6,6));
//        Border border1 = BorderFactory.createTitledBorder("边框");
//        Border border2 = BorderFactory.createLineBorder(Color.red, 2);
//        label2.setBorder(BorderFactory.createCompoundBorder(border2, border1));

        panel1.add(label1);
        panel1.add(label2);

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocation(800, 400);
        setIconImage(new ImageIcon("img/ic_like.jpg").getImage());
        setVisible(true);
    }
}

