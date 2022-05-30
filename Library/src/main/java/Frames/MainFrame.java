package Frames;

import Controls.User_Panel;
import Tools.Resources;

import javax.swing.*;

public class MainFrame extends JFrame {

    User_Panel user_panel = new User_Panel();


    public MainFrame() {
        Init();
    }

    void Init() {
        setContentPane(user_panel);
        setTitle("图书借阅系统 v1.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setIconImage(Resources.BOOKICON);
    }
}
