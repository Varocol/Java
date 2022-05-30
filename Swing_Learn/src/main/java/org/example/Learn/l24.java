package org.example.Learn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class l24 {
    public static void main(String[] args) {
        l24_frame myframe = new l24_frame("mf1");
    }
}

class l24_frame extends JFrame {

    JPanel panel1 = new JPanel();
    mypicture mypicture = new mypicture("/ic_like.jpg", Color.WHITE, true);

    public l24_frame(String title) {
        super(title);
        Init();
    }

    public l24_frame() {
        Init();
    }


    void Init() {

        mypicture.setImage("/ic_star.jpg", true);
        mypicture.setPreferredSize(new Dimension(113, 113));
        //Mouse事件是通用事件
        mypicture.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                System.out.println(e.getX() + " " + e.getY());
//                System.out.println(e.getSource().toString());
//                if (e.getButton() == MouseEvent.BUTTON1) {
//                    System.out.println("left");
//                } else if (e.getButton() == MouseEvent.BUTTON2) {
//                    System.out.println("middle");
//                } else if (e.getButton() == MouseEvent.BUTTON3) {
//                    System.out.println("right");
//                }
                //鼠标需要原地按下并抬起才能触发
                System.out.println("mouseClicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mousePressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseReleased");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouseEntered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited");
            }
        });


        panel1.add(mypicture);
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocation(800, 400);
        setIconImage(new ImageIcon("img/ic_like.jpg").getImage());
        setVisible(true);
    }
}

