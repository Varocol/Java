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
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UserUpdate_Dialog extends JDialog {
    MyButton1 confirm = new MyButton1(60, 30, 5, Color.white, "确认", 15,
            Color.BLACK);
    MyButton1 cancel = new MyButton1(60, 30, 5, Color.white, "取消", 15,
            Color.BLACK);
    MyText username_text = new MyText(new Dimension(200, 30));
    MyPasswordText password_text = new MyPasswordText(new Dimension(300, 30), 11);
    MyPasswordText repeatpassword_text = new MyPasswordText(new Dimension(300,
            30), 11);
    JComboBox<String> user_status = new JComboBox<>();
    MyLabel tip = new MyLabel("未填写的内容将不会被更改！", new Font("Arial, sans-serif;",
            Font.BOLD, 16), Color.BLACK);
    MyLabel username_label = new MyLabel("用户名:", new Font("Arial, sans-serif;",
            Font.BOLD, 16), Color.BLACK);
    MyLabel password_label = new MyLabel("密码:", new Font("Arial, sans-serif;",
            Font.BOLD, 16), Color.BLACK);
    MyLabel repeatpassword_label = new MyLabel("重复密码:", new Font("Arial," +
            "sans-serif;",
            Font.BOLD, 16), Color.BLACK);
    MyLabel user_status_label = new MyLabel("用户状态:", new Font("Arial, sans-serif;",
            Font.BOLD, 16), Color.BLACK);

    public UserUpdate_Dialog(Window owner, List<Object> user) {
        super(owner);

        setLayout(new FreeLayout());
        setSize(400, 350);

        user_status.setFont(new Font("Arial,sans-serif;", Font.BOLD, 18));
        user_status.setBackground(Color.white);
        user_status.setPreferredSize(new Dimension(120, 25));

        add(tip, new Margin(10, (int) ((getSize().getWidth() - tip.getPreferredSize().getWidth())/2), -1, -1));
        add(username_label, new Margin(40, 30, -1, -1));
        add(username_text, new Margin(35, 110, -1, 50));
        add(password_label, new Margin(90, 30, -1, -1));
        add(password_text, new Margin(85, 110, -1, 50));
        add(repeatpassword_label, new Margin(140, 30, -1, -1));
        add(repeatpassword_text, new Margin(135, 110, -1, 50));
        add(user_status_label, new Margin(190, 30, -1, -1));
        add(user_status, new Margin(187, 110, -1, 50));
        add(confirm, new Margin(-1, 100, 30, -1));
        add(cancel, new Margin(-1, -1, 30, 100));

        username_text.setText((String) user.get(2));
        user_status.addItem("未激活");
        user_status.addItem("普通用户");
        if ((user.get(5)).equals("未激活")) {
            user_status.setSelectedIndex(0);
        } else if ((user.get(5)).equals("普通用户")) {
            user_status.setSelectedIndex(1);
        }
        confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (username_text.getText().trim().length() < 6 && username_text.getText().trim().length() > 0) {
                    JOptionPane.showMessageDialog(UserUpdate_Dialog.this, "用户名不能少于6个字符", "提示",
                            JOptionPane.WARNING_MESSAGE);
                } else if (Judgespchar.check(username_text.getText().trim())) {
                    JOptionPane.showMessageDialog(UserUpdate_Dialog.this, "用户名不能包含特殊字符", "提示",
                            JOptionPane.WARNING_MESSAGE);
                } else if (password_text.getPassword().length < 6 && password_text.getPassword().length > 0) {
                    JOptionPane.showMessageDialog(UserUpdate_Dialog.this, "密码不能少于6个字符", "提示",
                            JOptionPane.WARNING_MESSAGE);
                } else if (Judgespchar.check(password_text.getPassword())) {
                    JOptionPane.showMessageDialog(UserUpdate_Dialog.this, "密码不能包含特殊字符", "提示",
                            JOptionPane.WARNING_MESSAGE);
                } else if (Arrays.equals(password_text.getPassword(), repeatpassword_text.getPassword())) {
                    try {
                        User user_filter = new User();
                        user_filter.setId((Integer) user.get(1));
                        //查询用户名是否存在
                        if (username_text.getText().trim().length() > 0) {
                            user_filter.setName(username_text.getText().trim());
                            User user1 = null;
                            List<User> users = User.getUsers(user_filter);
                            if (users.size() != 0) {
                                user1 = users.get(0);
                            }
                            if (user1 != null && !Objects.equals(user1.getId(), user.get(1))) {
                                JOptionPane.showMessageDialog(UserUpdate_Dialog.this, "用户名已存在", "错误",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        //用户密码是否为空
                        else if (password_text.getPassword().length > 0) {
                            user_filter.setPassword(new String(password_text.getPassword()));
                        }
                        if (user_status.getSelectedIndex() == 0) {
                            user_filter.setState(User.UNACTIVATED);
                        } else if (user_status.getSelectedIndex() == 1) {
                            user_filter.setState(User.COMMONUSER);
                        }
                        try {
                            User.updateUser(user_filter);
                            JOptionPane.showMessageDialog(UserUpdate_Dialog.this, "用户修改成功！", "提示",
                                    JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                        } catch (SQLException | FileNotFoundException ex) {
                            SqlError.quit(UserUpdate_Dialog.this,
                                    "修改用户失败!" + ex.getMessage());
                        }

                    } catch (SQLException | IOException |
                             ClassNotFoundException |
                             NoSuchAlgorithmException ex) {
                        SqlError.quit(UserUpdate_Dialog.this, "查询用户列表失败!" + ex.getMessage());
                    }

                } else {
                    JOptionPane.showMessageDialog(UserUpdate_Dialog.this,
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


        setTitle("修改用户");
        setIconImage(Resources.BOOKICON);
        setLocationRelativeTo(owner);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        setVisible(true);
    }
}

