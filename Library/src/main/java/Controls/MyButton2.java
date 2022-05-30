package Controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

public class MyButton2 extends JButton {
    int width = 0;
    int height = 0;
    int font_size = 0;
    int x = 0;
    int y = 0;
    int str_width = 0;
    int str_height = 0;
    int arcWidth = 0;

    Color background_color = null;
    String text = null;
    String temp_text = null;
    boolean entered = false;

    Image image1 = null;
    Image image2 = null;

    Font font = null;
    FontRenderContext frc = null;

    public MyButton2(int width, int height, int arcwidth, Color background_color, String text, int font_size, Image image1, Image image2) {
        this.width = width;
        this.height = height;
        this.arcWidth = arcwidth;
        this.background_color = background_color;
        this.font_size = font_size;
        this.text = text;
        this.temp_text = text;
        this.image1 = image1;
        this.image2 = image2;

        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);

        this.font = new Font("Arial, sans-serif;", Font.BOLD, font_size);
        this.frc = new FontRenderContext(new AffineTransform(), true, true);
        Rectangle rec = font.getStringBounds(text, frc).getBounds();
        setHorizontalAlignment(SwingConstants.CENTER);

        str_width = (int) rec.getWidth();
        str_height = (int) rec.getHeight();
        x = (width - str_width) * 3 / 5;
        y = (int) ((height - str_height) / 2 + str_height * 0.8);

        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));


        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                entered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                entered = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int Img_width = image1.getWidth(null);
        int Img_height = image1.getHeight(null);
        double Scale = (double) Img_width / Img_height;
        //设置背景颜色
        if (background_color != null) {
            // 鼠标进入时的样式
            if (entered) {
                g2.setColor(background_color);
                g2.fillRoundRect(0, 0, width, height, arcWidth, arcWidth);
                g2.setColor(Color.white);
                g2.drawImage(image1, width / 10, height / 6,
                        (int) (Scale * height * 2 / 3),
                        height * 2 / 3,
                        null);
            }
            // 鼠标离开时的样式
            else {
                g2.setColor(new Color(240, 243, 249));
                g2.fillRoundRect(0, 0, width, height, arcWidth, arcWidth);
                g2.setColor(Color.black);
                g2.drawImage(image2, width / 10, height / 6,
                        (int) (Scale * height * 2 / 3),
                        height * 2 / 3,
                        null);
            }
        }
        g2.setFont(font);
        g2.drawString(text, x, y);
    }

}

