package test.sinline;

import javax.swing.*;
import java.awt.*;

public class Sin_curve extends JPanel {
    int A = 5;
    int omega = 1;
    int phi = 0;
    int scale = 50;
    Color color = Color.BLACK;
    int line_width = 1;

    double x_offset = 0;
    double y_offset = 0;

    public Sin_curve() {
    }

    public Sin_curve(int A, int omega, int phi, int scale, Color color, int line_width) {
        setParameters(A, omega, phi, scale, color, line_width);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //获取宽度和高度
        int width = getWidth();
        int height = getHeight();
        double x = (-width / 2.0 + x_offset) / scale;
        double y = A * Math.sin(x * omega + phi);
        Point p1 = getPoint(x, y);
        Point p2;
        //设置画笔颜色
        g.setColor(color);
        //设置文字粗细
        g.setFont(new Font("Consolas", Font.PLAIN, 18));
        //设置画笔粗细
        ((Graphics2D) g).setStroke(new BasicStroke(line_width));
        //根据参数绘制sin曲线
        for (int i = 0; i < width; i++) {
            x = (i - width / 2.0 + x_offset) / scale;
            y = A * Math.sin(x * omega + phi);
            p2 = getPoint(x, y);
            g.drawLine((int) (p1.x - x_offset), (int) (p1.y - y_offset),
                    (int) (p2.x - x_offset), (int) (p2.y - y_offset));
            //更新p1
            p1 = p2;
        }
        setOpaque(false);
    }

    void setParameters(int A, int omega, int phi, int scale, Color color, int line_width) {
        this.A = A;
        this.omega = omega;
        this.phi = phi;
        this.scale = scale;
        this.color = color;
    }

    private Point getPoint(double x, double y) {
        return new Point((int) (x * scale + getWidth() / 2), (int) (getHeight() / 2 - y * scale));
    }

    void setXOffset(double x_offset) {
        this.x_offset = x_offset;
    }

    void setYOffset(double y_offset) {
        this.y_offset = y_offset;
    }
}
