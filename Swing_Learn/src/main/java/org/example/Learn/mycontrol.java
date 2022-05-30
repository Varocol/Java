package org.example.Learn;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class mycontrol extends JPanel {
    private boolean isOn;
    private List<List<Point>> points = new ArrayList<>();

    public mycontrol() {
        this.addMouseListener(new MymouseListener());
        this.addMouseMotionListener(new MymouseListener());
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        if (isOn) {
            g.setColor(Color.red);
            g.drawRect(0, 0, width - 1, height - 1);
        } else {
            g.setColor(Color.black);
            g.drawRect(0, 0, width - 1, height - 1);
        }
        for (List<Point> list : points) {
            for (int i = 0; i < list.size(); i++) {
                if (list.size() == 1) {
                    g.drawLine(list.get(i).x, list.get(i).y, list.get(i).x, list.get(i).y);
                }
                if (i == 0) {
                    g.setColor(Color.red);
                } else {
                    g.drawLine(list.get(i - 1).x, list.get(i - 1).y, list.get(i).x, list.get(i).y);
                }
            }
        }
    }

    private class MymouseListener extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
//            System.out.println("entered");
            isOn = true;
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
//            System.out.println("exited");
            isOn = false;
            repaint();
        }

        public void mouseDragged(MouseEvent e) {
            System.out.println("dragged");
            points.get(points.size() - 1).add(new Point(e.getX(), e.getY()));
            repaint();
        }

        public void mouseMoved(MouseEvent e) {
            System.out.println("moved");
        }

        public void mousePressed(MouseEvent e) {
            System.out.println("pressed");
            points.add(new ArrayList<Point>());
        }
    }
}
