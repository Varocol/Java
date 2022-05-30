package org.example.Learn;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class mypicture extends JPanel {
    private Image image;
    private Color backgroundColor;

    public mypicture() {
    }

    public mypicture(String path, Color color, boolean isResource) {
        super();
        setImage(path, isResource);
        setBackgroundColor(color);
    }

    public mypicture(Image image, Color color) {
        super();
        setImage(image);
        setBackgroundColor(color);
    }

    public void setBackgroundColor(Color color) {
        backgroundColor = color;
        this.repaint();
    }

    public void setImage(String path, boolean isResource) {
        if (isResource) {
            try {
                InputStream inputStream = this.getClass().getResourceAsStream(path);
                assert inputStream != null;
                image = ImageIO.read(inputStream);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else {
            File file = new File(path);
            try {
                System.out.println("加载图片");
                image = ImageIO.read(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        this.repaint();
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
        // 如果背景色不为空，则绘制背景色
        if (backgroundColor != null) {
            g.setColor(backgroundColor);
            // 图片的背景部分
            g.fillRect(0, 0, width, height);
        }
        // 如果图片不为空，则绘制图片
        if (image != null) {
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
        // 绘制边框,不能被背景色遮挡
        g.setColor(Color.gray);
        g.drawRect(0, 0, width - 1, height - 1);
    }
}
