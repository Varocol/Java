package Controls;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MyHeadIcon extends JPanel {
    int radius = 0;
    private Image image;

    public MyHeadIcon() {
        super();
    }

    public MyHeadIcon(Image image, int radius) {
        super();
        this.radius = radius;
        setImage(image);
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);
        double scaleX = (double) radius * 2 / imageWidth;
        double scaleY = (double) radius * 2 / imageHeight;
        double scale = Math.min(scaleX, scaleY);
        setPreferredSize(new Dimension((int) (imageWidth * scale), (int) (imageHeight * scale)));
        setOpaque(false);
    }

    public void setImage(Image image) {
        this.image = image;
    }

    // 加载图片
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Shape region = new Ellipse2D.Double(getWidth() / 2.0 - radius,
                getHeight() / 2.0 - radius, radius * 2, radius * 2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.clip(region);
        g2.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }
}
