package Tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.InputStream;

public class ImageLoader {
    public Image getImage(String name) {
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(
                    name);
            assert inputStream != null;
            return ImageIO.read(inputStream);
        } catch (Exception e) {
            System.out.println("图片：" + name + "不存在");
        }
        return null;
    }

}
