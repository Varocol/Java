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
        menu = new JMenu("�˵�");
        subMenu = new JMenu("�����Ŀ");
        item1 = new JMenuItem("Java����");
        item2 = new JMenuItem("��������");
        item1.setAccelerator(KeyStroke.getKeyStroke('A'));
        item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
        menu.add(item1);
        menu.addSeparator();
        menu.add(item2);
        menu.add(subMenu);
        subMenu.add(new JMenuItem("��������ϵͳ"));
        subMenu.add(new JMenuItem("ũ����Ϣϵͳ"));
        menubar.add(menu);
        setJMenuBar(menubar);
    }
}