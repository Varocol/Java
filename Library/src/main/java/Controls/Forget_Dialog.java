package Controls;

import Tools.Resources;
import af.swing.layout.FreeLayout;
import af.swing.layout.Margin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Forget_Dialog extends JDialog {
    MyLabel tip = new MyLabel("<html>请联系管理员将账号密码找回,点击确认将暂时锁定您的账号以确保账号安全!</html>"
            , new Font("Arial, sans-serif;", Font.BOLD, 16), Color.BLACK);
    MyButton1 confirm = new MyButton1(60, 30, 5, Color.white, "确认", 15,
            Color.BLACK);

    public Forget_Dialog(Window parentWindow) {
        super(parentWindow);
        setSize(300, 200);
        setLayout(new FreeLayout());

        add(tip, new Margin(20, 10, -1, 10));
        add(confirm, new Margin(-1, 110, 20, -1));

        confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        setTitle("忘记密码？");
        setIconImage(Resources.BOOKICON);
        setLocationRelativeTo(parentWindow);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        setVisible(true);
    }
}
