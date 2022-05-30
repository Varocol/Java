package Controls;

import Datas.User;
import Tools.Judgespchar;
import Tools.Resources;
import Tools.SqlError;
import af.swing.layout.FreeLayout;
import af.swing.layout.Margin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;

public class Register_Dialog extends JDialog {

    MyButton1 confirm = new MyButton1(60, 30, 5, Color.white, "确认", 15,
            Color.BLACK);
    MyButton1 cancel = new MyButton1(60, 30, 5, Color.white, "取消", 15,
            Color.BLACK);
    MyText username_text = new MyText(new Dimension(200, 30));
    MyPasswordText password_text = new MyPasswordText(new Dimension(300, 30), 11);
    MyPasswordText repeatpassword_text = new MyPasswordText(new Dimension(300,
            30), 11);
    MyLabel username_label = new MyLabel("用户名:", new Font("Arial, sans-serif;",
            Font.BOLD, 16), Color.BLACK);
    MyLabel password_label = new MyLabel("密码:", new Font("Arial, sans-serif;",
            Font.BOLD, 16), Color.BLACK);
    MyLabel repeatpassword_label = new MyLabel("重复密码:", new Font("Arial," +
            "sans-serif;",
            Font.BOLD, 16), Color.BLACK);

    public Register_Dialog(Window parentWindow) {
        super(parentWindow);

        setLayout(new FreeLayout());
        setSize(400, 300);


        add(username_label, new Margin(40, 30, -1, -1));
        add(username_text, new Margin(35, 110, -1, 50));
        add(password_label, new Margin(90, 30, -1, -1));
        add(password_text, new Margin(85, 110, -1, 50));
        add(repeatpassword_label, new Margin(140, 30, -1, -1));
        add(repeatpassword_text, new Margin(135, 110, -1, 50));
        add(confirm, new Margin(-1, 100, 30, -1));
        add(cancel, new Margin(-1, -1, 30, 100));

        confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (username_text.getText().length() < 6) {
                    JOptionPane.showMessageDialog(Register_Dialog.this, "用户名不能少于6个字符", "提示",
                            JOptionPane.WARNING_MESSAGE);
                } else if (Judgespchar.check(username_text.getText())) {
                    JOptionPane.showMessageDialog(Register_Dialog.this, "用户名不能包含特殊字符", "提示",
                            JOptionPane.WARNING_MESSAGE);
                } else if (new String(password_text.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(Register_Dialog.this, "密码不能为空", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (new String(password_text.getPassword()).length() < 6) {
                    JOptionPane.showMessageDialog(Register_Dialog.this, "密码不能少于6个字符", "提示",
                            JOptionPane.WARNING_MESSAGE);
                } else if (Judgespchar.check(password_text.getPassword())) {
                    JOptionPane.showMessageDialog(Register_Dialog.this, "密码不能包含特殊字符", "提示",
                            JOptionPane.WARNING_MESSAGE);
                } else if (Arrays.equals(password_text.getPassword(), repeatpassword_text.getPassword())) {
                    try {
                        User user_filter = new User();
                        user_filter.setName(username_text.getText());
                        if (User.getUsers(user_filter, User.sql_default).size() > 0) {
                            JOptionPane.showMessageDialog(Register_Dialog.this, "用户名已存在", "错误",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            User user = new User();
                            user.setName(username_text.getText());
                            try {
                                user.setPassword(new String(password_text.getPassword()));
                            } catch (UnsupportedEncodingException |
                                     NoSuchAlgorithmException ex) {
                                throw new RuntimeException(ex);
                            }
                            //0 表示未激活 1表示激活 2表示管理员
                            user.setState(User.UNACTIVATED);
                            user.setHeadiconPath(Resources.RESOURCES_PATH + Resources.DEFAULTHEADICONPATH);
                            try {
                                User.addUser(user);
                                JOptionPane.showMessageDialog(Register_Dialog.this, "注册成功,请联系管理员激活账号", "提示",
                                        JOptionPane.INFORMATION_MESSAGE);
                                dispose();
                            } catch (SQLException | FileNotFoundException ex) {
                                SqlError.quit(Register_Dialog.this,
                                        "用户注册失败!" + ex.getMessage());
                            }
                        }
                    } catch (SQLException | IOException |
                             ClassNotFoundException |
                             NoSuchAlgorithmException ex) {
                        SqlError.quit(Register_Dialog.this, "查询用户列表失败!" + ex.getMessage());
                    }

                } else {
                    JOptionPane.showMessageDialog(Register_Dialog.this,
                            "两次密码不一致!", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });


        setTitle("注册账号");
        setIconImage(Resources.BOOKICON);
        setLocationRelativeTo(parentWindow);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        setVisible(true);
    }
}
