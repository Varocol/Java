package org.example.Learn;

import javax.swing.*;
import java.awt.*;

public class l20 {
    public static void main(String[] args) {
        l20_frame myframe = new l20_frame("mf1");
    }
}

class l20_frame extends JFrame {
    JPanel panel1 = new JPanel();
    l11_label label1 = new l11_label("Label 1", Color.red);
    l11_label label2 = new l11_label("Label 2", Color.blue);
    l11_label label3 = new l11_label("Label 3", Color.green);
    l11_label label4 = new l11_label("Label 4", Color.yellow);
    l11_label label5 = new l11_label("Label 5", Color.orange);

    public l20_frame(String title) {
        super(title);
        Init();
    }

    public l20_frame() {
        Init();
    }


    void Init() {
        panel1.setLayout(new layoutadapter() {
            @Override
            public void addLayoutComponent(Component comp, Object constraints) {

            }

            @Override
            public void removeLayoutComponent(Component comp) {

            }

            @Override
            public void layoutContainer(Container parent) {
                int width = parent.getWidth();
                int height = parent.getHeight();

                Component[] componets = parent.getComponents();
                int count = componets.length;
                for (int i = 0; i < count; i++) {
                    Component comp = componets[i];
                    Dimension size = comp.getPreferredSize();
                    switch (i) {
                        case 0:
                            comp.setBounds(0, 0, size.width, size.height);
                            break;
                        case 1:
                            comp.setBounds(width - size.width, 0, size.width, size.height);
                            break;
                        case 2:
                            comp.setBounds(0, height - size.height, size.width, size.height);
                            break;
                        case 3:
                            comp.setBounds(width - size.width, height - size.height, size.width, size.height);
                            break;
                        default:
                            comp.setBounds((width - size.width) / 2, (height - size.height) / 2, size.width, size.height);
                            break;
                    }
                }
            }
        });

        setContentPane(panel1);
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);
        panel1.add(label4);
        panel1.add(label5);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(600, 600);

        setLocation(800, 400);

        setVisible(true);
    }
}
