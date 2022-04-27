package test.sinline;

import javax.swing.*;
import java.awt.*;

public class Coordinate_system extends JPanel {

    double pixelWidth = 20;

    double x_offset = 0;
    double y_offset = 0;

    public Coordinate_system() {

    }

    public Coordinate_system(int pixelWidth) {
        if (pixelWidth > 0) {
            setPixelWidth(pixelWidth);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //获取宽度和高度
        int width = getWidth();
        int height = getHeight();

        //设置画笔颜色
        g.setColor(Color.BLACK);
        //设置文字粗细
        g.setFont(new Font("Consolas", Font.PLAIN, 20));
        //画x轴
        g.fillRect(0, (int) (height / 2 - y_offset), width, 3);
        //标记x轴
        g.drawString("x", width - 20, (int) (height / 2 - 10 - y_offset));
        //画y轴
        g.fillRect((int) (width / 2 - x_offset), 0, 3, height);
        //标记y轴
        g.drawString("y", (int) (width / 2 + 10 - x_offset), 20);
        //标记原点
        g.drawString("(0,0)", (int) (width / 2 + 5 - x_offset), (int) (height / 2 - 5 - y_offset));
        //画原点
        g.fillArc((int) (width / 2 - 5 - x_offset), (int) (height / 2 - 5 - y_offset), 10, 10, 0, 360);
        //画网格
        for (int i = (int) (width / 2 + pixelWidth - x_offset); i < width; i += pixelWidth) {
            g.drawLine(i, 0, i, height);
        }
        for (int i = (int) (width / 2 + pixelWidth - x_offset); i > 0; i -= pixelWidth) {
            g.drawLine(i, 0, i, height);
        }
        for (int i = (int) (height / 2 + pixelWidth - y_offset); i < height; i += pixelWidth) {
            g.drawLine(0, i, width, i);
        }
        for (int i = (int) (height / 2 + pixelWidth - y_offset); i > 0; i -= pixelWidth) {
            g.drawLine(0, i, width, i);
        }
        setOpaque(false);
    }

    void setPixelWidth(double pixelWidth) {
        this.pixelWidth = pixelWidth;
    }
}
