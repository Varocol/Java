package Controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

public class MyButton1 extends JButton {

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
    Color text_color = null;

    boolean pressed = false;
    boolean entered = false;

    Font font = null;
    FontRenderContext frc = null;

    public MyButton1(int width, int height, int arcwidth,
                     Color background_color, String text, int font_size,
                     Color text_color) {
        this.width = width;
        this.height = height;
        this.arcWidth = arcwidth;
        this.background_color = background_color;
        this.font_size = font_size;
        this.text = text;
        this.temp_text = text;
        this.text_color = text_color;

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
        x = (width - str_width) / 2;
        y = (int) ((height - str_height) / 2 + str_height * 0.8);

        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));


        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                pressed = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pressed = false;
                repaint();
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
        this.frc = new FontRenderContext(new AffineTransform(), true, true);
        Rectangle rec = font.getStringBounds(text, frc).getBounds();
        setHorizontalAlignment(SwingConstants.CENTER);

        str_width = (int) rec.getWidth();
        str_height = (int) rec.getHeight();
        x = (width - str_width) / 2;
        y = (int) ((height - str_height) / 2 + str_height * 0.8);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (background_color != null) {
            g2.setColor(background_color);
            g2.fillRoundRect(0, 0, width, height, arcWidth, arcWidth);
        }

        if (pressed) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
            g2.setColor(Color.blue);
            g2.drawRoundRect(0, 0, width - 1, height - 1, arcWidth, arcWidth);
        } else if (entered) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
            g2.setColor(Color.blue);
            g2.drawRoundRect(0, 0, width - 1, height - 1, arcWidth, arcWidth);
        }

        if (!entered && !pressed) {
            g2.setColor(new Color(0, 0, 0, 100));
            g2.drawRoundRect(0, 0, width - 1, height - 1, arcWidth, arcWidth);
        }
        g2.setColor(text_color);
        g2.setFont(font);
        g2.drawString(text, x, y);
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
        this.temp_text = text;
        repaint();
    }
}
