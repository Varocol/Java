package org.example.Learn;

import javax.swing.*;
import java.awt.*;

public class mycontrol extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.RED);
        g.fillArc(0,0, 100, 100, 0, 180);
    }
}
