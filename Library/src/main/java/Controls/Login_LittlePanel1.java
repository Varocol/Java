package Controls;

import Datas.User;
import Frames.MainFrame;
import Tools.Judgespchar;
import Tools.Resources;
import Tools.SqlError;
import Tools.ThreadInfo;
import af.swing.layout.FreeLayout;
import af.swing.layout.Margin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

;

public class Login_LittlePanel1 extends JPanel {
    MyLabel username_label = new MyLabel("账号", new Font(
            "Arial, sans-serif;", Font.BOLD, 20), Color.BLACK);
    MyLabel password_label = new MyLabel("密码", new Font(
            "Arial, sans-serif;", Font.BOLD, 20), Color.BLACK);
    MyPicture username_picture =
            new MyPicture(Resources.USERNAME, new Dimension(25, 25));
    MyPicture password_picture =
            new MyPicture(Resources.PASSWORD, new Dimension(25, 25));
    MyLabel forget_label = new MyLabel("忘记密码？", new Font(
            "Arial, sans-serif;", Font.PLAIN, 18), Color.BLUE);
    MyLabel register_label = new MyLabel("注册账号", new Font(
            "Arial, sans-serif;", Font.PLAIN, 18), Color.BLUE);
    MyText username_textField = new MyText(new Dimension(200, 35));
    MyPasswordText password_textField = new MyPasswordText(new Dimension(200, 35));
    MyButton1 login_button = new MyButton1(260, 50, 10,
            new Color(0, 131, 245), "登 录", 20, Color.white);
    JSeparator separator1 = new JSeparator();
    JSeparator separator2 = new JSeparator();
    DropShadow_Panel dropShadowPanel1 = new DropShadow_Panel(3);
    DropShadow_Panel dropShadowPanel2 = new DropShadow_Panel(3);
    DropShadow_Panel dropShadowPanel3 = new DropShadow_Panel(10);


    public Login_LittlePanel1() {
        super();
        Init();
    }

    void Init() {

        setPreferredSize(new Dimension(300, 400));
        setBackground(new Color(240, 243, 249));
        separator1.setPreferredSize(new Dimension(260, 2));
        separator1.setForeground(new Color(0, 0, 0, 50));
        separator2.setPreferredSize(new Dimension(260, 2));
        separator2.setForeground(new Color(0, 0, 0, 50));

        dropShadowPanel1.add(username_textField);
        dropShadowPanel2.add(password_textField);
        dropShadowPanel3.add(login_button);


        username_textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    login_button.doClick();
                }
            }
        });
        password_textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    login_button.doClick();
                }
            }
        });

        login_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 检测账号和密码是否正确
                if (username_textField.getText().length() < 6 || Judgespchar.check(username_textField.getText()) ||
                        new String(password_textField.getPassword()).length() < 6 || Judgespchar.check(password_textField.getPassword())) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Login_LittlePanel1.this),
                            "账号或密码错误!");
                } else {
                    try {
                        User user_filter = new User();
                        user_filter.setName(username_textField.getText());
                        user_filter.setPassword(new String(password_textField.getPassword()));
                        List<User> users = User.getUsers(user_filter, User.sql_default);
                        if (users.size() == 1) {
                            User user = users.get(0);
                            if (user.getState().equals(User.UNACTIVATED)) {
                                JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Login_LittlePanel1.this), "该账号未激活!");
                            } else {
                                User.CurrentUser = user;
                                //创建一个线程用于更新用户信息
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        while (true) {
                                            try {
                                                List<User> users =
                                                        User.getUsers(user_filter, User.sql_default);
                                                if (users.size() == 1) {
                                                    User.CurrentUser = users.get(0);
                                                } else {
                                                    User.CurrentUser = null;
                                                    break;
                                                }
                                                Thread.sleep(10000);
                                                ThreadInfo.printThreadInfo(
                                                        "从数据库更新用户信息");
                                            } catch (SQLException |
                                                     IOException |
                                                     NoSuchAlgorithmException |
                                                     InterruptedException ex) {
                                                SqlError.quit(Login_LittlePanel1.this, "更新用户信息失败!" + ex.getMessage());
                                            }
                                        }
                                    }
                                }).start();
                                new MainFrame();
                                SwingUtilities.getWindowAncestor(Login_LittlePanel1.this).dispose();
                            }
                        } else if (users.size() > 1) {
                            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Login_LittlePanel1.this),
                                    "用户存在多个!");
                        } else {
                            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Login_LittlePanel1.this),
                                    "账号或密码错误!");
                        }
                    } catch (SQLException | IOException | NoSuchAlgorithmException ex) {
                        SqlError.quit(Login_LittlePanel1.this, "获取用户信息失败!" + ex.getMessage());
                    }
                }
            }
        });
        forget_label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Forget_Dialog forgetDialog =
                        new Forget_Dialog(SwingUtilities.getWindowAncestor(Login_LittlePanel1.this));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        register_label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Register_Dialog registerDialog =
                        new Register_Dialog(SwingUtilities.getWindowAncestor(Login_LittlePanel1.this));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 30), 1, true));
        setLayout(new FreeLayout());


        add(dropShadowPanel3, new Margin(310, 10, -1, -1));
        add(username_picture, new Margin(40, 20, -1, -1));
        add(username_label, new Margin(40, 50, -1, 20));
        add(separator1, new Margin(70, 20, -1, -1));
        add(dropShadowPanel1, new Margin(95, 20, -1, 20));
        add(password_picture, new Margin(150, 20, -1, -1));
        add(password_label, new Margin(150, 50, -1, 20));
        add(separator2, new Margin(180, 20, -1, -1));
        add(dropShadowPanel2, new Margin(205, 20, -1, 20));
        add(forget_label, new Margin(260, 20, -1, -1));
        add(register_label, new Margin(260, -1, -1, 20));

    }
}
