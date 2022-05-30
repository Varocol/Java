package Controls;

import javax.swing.*;
import java.awt.*;

public class MyPicture extends JPanel {
    private Image image;

    public MyPicture() {
        super();
    }

    public MyPicture(Image image,Dimension size) {
        super();
        setImage(image);
        setPreferredSize(size);
        setOpaque(false);
    }

    public void setImage(Image image) {
        this.image = image;
        this.repaint();
    }

    // 加载图片
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);

        // 图片缩放
        double scaleX = (double) width / imageWidth;
        double scaleY = (double) height / imageHeight;
        double scale = Math.min(scaleX, scaleY);
        int imageNewWidth = (int) (imageWidth * scale);
        int imageNewHeight = (int) (imageHeight * scale);
        int imageX = (width - imageNewWidth) / 2;
        int imageY = (height - imageNewHeight) / 2;
        g.drawImage(image, imageX, imageY, imageNewWidth, imageNewHeight, null);
    }
}
