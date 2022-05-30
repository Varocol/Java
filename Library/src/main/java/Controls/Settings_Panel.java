package Controls;

import Datas.User;
import Tools.Judgespchar;
import Tools.SqlError;
import Tools.ThreadInfo;
import af.swing.layout.FreeLayout;
import af.swing.layout.Margin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;

public class Settings_Panel extends JPanel {
    MyLabel panel_label = new MyLabel("修改密码", new Font("Arial, " +
            "sans-serif;", Font.BOLD, 25), Color.black);

    MyLabel old_password_label = new MyLabel("旧密码：", new Font("Arial, " +
            "sans-serif;", Font.BOLD, 20), Color.black);
    MyLabel new_password_label = new MyLabel("新密码：", new Font("Arial, " +
            "sans-serif;", Font.BOLD, 20), Color.black);
    MyLabel confirm_password_label = new MyLabel("确认密码：", new Font("Arial, " +
            "sans-serif;", Font.BOLD, 20), Color.black);
    MyPasswordText old_password_text = new MyPasswordText(new Dimension(200, 30));
    MyPasswordText new_password_text = new MyPasswordText(new Dimension(200, 30));
    MyPasswordText confirm_password_text = new MyPasswordText(new Dimension(200, 30));
    MyButton1 confirm = new MyButton1(100, 30, 5, Color.white, "确 认", 20,
            Color.BLACK);
    JSeparator separator = new JSeparator();
    Thread updateThread;
    boolean isRunning = true;
    JPanel parentpanel;

    public Settings_Panel(JPanel parentpanel) {
        this.parentpanel = parentpanel;
        Init();
    }

    void Init() {

//        ThreadCreate();
//        ThreadStart();

        setBackground(new Color(240, 243, 249));
        setPreferredSize(new Dimension(800, 650));
        setOpaque(true);
        setLayout(new FreeLayout());

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user_filter = new User();
                try {
                    user_filter.setPassword(new String(old_password_text.getPassword()));
                     if (!Arrays.equals(new_password_text.getPassword(), confirm_password_text.getPassword())) {
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Settings_Panel.this),
                                "两次密码不一致!", "错误", JOptionPane.ERROR_MESSAGE);
                    } else if (new_password_text.getPassword().length < 6) {
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Settings_Panel.this),
                                "密码长度不能小于6位!", "错误", JOptionPane.ERROR_MESSAGE);
                    } else if (Judgespchar.check(new_password_text.getPassword())) {
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Settings_Panel.this),
                                "密码不能包含特殊字符!", "错误", JOptionPane.ERROR_MESSAGE);
                    } else if (!user_filter.getPassword().equals(User.CurrentUser.getPassword())) {
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Settings_Panel.this), "旧密码错误!"
                                , "错误", JOptionPane.ERROR_MESSAGE);
                    } else {
                         user_filter.setPassword(new String(new_password_text.getPassword()));
                         if(user_filter.getPassword().equals(User.CurrentUser.getPassword())){
                             JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Settings_Panel.this), "新密码不能与旧密码相同!"
                                     , "错误", JOptionPane.ERROR_MESSAGE);
                         }
                         else {
                             int result = JOptionPane.showConfirmDialog(SwingUtilities.getWindowAncestor(Settings_Panel.this),
                                      "是否要修改密码？", "提示", JOptionPane.YES_NO_OPTION);
                             if(result == JOptionPane.YES_OPTION){
                                 user_filter.setId(User.CurrentUser.getId());
                                 User.updateUser(user_filter);
                                 JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Settings_Panel.this),
                                         "修改成功,请重新登录!", "成功", JOptionPane.INFORMATION_MESSAGE);
                             }
                         }
                     }
                } catch (UnsupportedEncodingException | NoSuchAlgorithmException | SQLException |
                         FileNotFoundException | ClassNotFoundException ex) {
                    SqlError.quit(Settings_Panel.this, "密码修改失败!" + ex.getMessage());
                }
            }
        });
        separator.setForeground(new Color(10, 29, 121));

        add(panel_label, new Margin(10, 10, -1, -1));
        add(separator, new Margin(50, 0, -1, 0));
        int left1 = (int) (getPreferredSize().getWidth() / 3);
        int top1 = (int) (getPreferredSize().getWidth() / 3);
        add(old_password_label, new Margin(top1, left1, -1, -1));
        add(old_password_text, new Margin(top1, left1 + 100, -1, -1));
        add(new_password_label, new Margin(top1 + 50, left1, -1, -1));
        add(new_password_text, new Margin(top1 + 50, left1 + 100, -1, -1));
        add(confirm_password_label, new Margin(top1 + 100, left1, -1, -1));
        add(confirm_password_text, new Margin(top1 + 100, left1 + 100, -1, -1));
        add(confirm, new Margin(top1 + 150, (int) (getPreferredSize().getWidth() / 2), -1, -1));
    }

    public void UpdatedynamicUI() {

    }

    public void ThreadStart() {
        isRunning = true;
        updateThread.start();
    }

    public void ThreadCreate() {
        updateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning) {
                    UpdatedynamicUI();
                    try {
                        Thread.sleep(100);
                        ThreadInfo.printThreadInfo("Settings_Panel");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void ThreadClose() {
        isRunning = false;
    }

    public boolean getThreadState() {
        return isRunning;
    }
}
