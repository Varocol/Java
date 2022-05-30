package Controls;

import Tools.Resources;
import af.swing.layout.FreeLayout;
import af.swing.layout.Margin;

import javax.swing.*;
import java.awt.*;

public class Login_LittlePanel2 extends JPanel {
    MyLabel title = new MyLabel("图书借阅系统", new Font("华文楷体", Font.BOLD, 30),
            Color.BLACK);
    MyPicture picture = new MyPicture(Resources.BOOKICON, new Dimension(50, 50));
    public Login_LittlePanel2() {
        super();
        Init();
    }
    void Init() {
        setPreferredSize(new Dimension(300, 90));
        setBackground(new Color(240, 243, 249));
        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 30), 1, true));
        setLayout(new FreeLayout());
        int x = 20;
        add(picture,
                new Margin((int) ((getPreferredSize().getHeight()-picture.getPreferredSize().getHeight())/2),
                        x, -1, -1));
        add(title,
                new Margin((int) ((getPreferredSize().getHeight()-title.getPreferredSize().getHeight())/2),
                        (int) (x+picture.getPreferredSize().getWidth()+10), -1, -1))    ;

    }
}
