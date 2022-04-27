import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class WindowMenu extends JFrame {
    JMenuBar menubar;
    JMenu menu, subMenu;
    JMenuItem item1, item2;

    public WindowMenu() {
    }

    public WindowMenu(String s, int x, int y, int w, int h) {
        init(s);
        setLocation(x, y);
        setSize(w, h);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    void init(String s)
    {
        setTitle(s);
        menubar = new JMenuBar();
        menu = new JMenu("菜单");
        subMenu = new JMenu("软件项目");
        item1 = new JMenuItem("Java话题");
        item2 = new JMenuItem("动画话题");
        item1.setAccelerator(KeyStroke.getKeyStroke('A'));
        item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
        menu.add(item1);
        menu.addSeparator();
        menu.add(item2);
        menu.add(subMenu);
        subMenu.add(new JMenuItem("汽车销售系统"));
        subMenu.add(new JMenuItem("农场信息系统"));
        menubar.add(menu);
        setJMenuBar(menubar);
    }
}