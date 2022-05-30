package Frames;

import Controls.Login_Panel;
import Tools.Resources;

import javax.swing.*;

public class LoginFrame extends JFrame {
    Login_Panel login_panel = new Login_Panel();
    public LoginFrame(){
        Init();
    }
    void Init(){
        setContentPane(login_panel);
        setTitle("登录图书借阅系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,700);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setIconImage(Resources.BOOKICON);
    }
}
