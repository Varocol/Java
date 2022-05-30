package Tools;

import java.io.File;

public class CheckLargeImg {
    public static boolean isLargeImg(File file) {
        // 文件大小超过16M不允许上传
        return file.length() > 1024 * 1024 * 16;
    }
}
