package Controls;

import Datas.User;
import Tools.CheckLargeImg;
import Tools.Resources;
import Tools.SqlError;
import Tools.ThreadInfo;
import af.swing.layout.FreeLayout;
import af.swing.layout.Margin;
import com.eltima.components.ui.DatePicker;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Date;

//设计一个个人信息面板
public class SelfInfo_Panel extends JPanel {
    MyLabel panel_label = new MyLabel("个人信息", new Font("Arial, " +
            "sans-serif;",
            Font.BOLD, 25), Color.black);
    MyHeadIcon myHeadIcon = new MyHeadIcon(Resources.DEFAULTHEADICON, 50);
    MyLabel username_label1 = new MyLabel("用户名", new Font("Arial, " +
            "sans-serif;",
            Font.BOLD, 22), Color.black);
    MyLabel sex_label = new MyLabel("性别", new Font("Arial, sans-serif;",
            Font.BOLD, 22), Color.black);

    MyLabel birthday_label = new MyLabel("出生日期", new Font("Arial, sans-serif;",
            Font.BOLD, 22), Color.black);
    MyLabel phone_label1 = new MyLabel("电话", new Font("Arial, sans-serif;",
            Font.BOLD, 22), Color.black);
    MyLabel phone_label2 = new MyLabel("", new Font("Arial, " +
            "sans-serif;",
            Font.PLAIN, 20), Color.black);
    MyLabel registertime1_label = new MyLabel("注册时间", new Font("Arial, " +
            "sans-serif;",
            Font.BOLD, 22), Color.black);
    MyLabel username_label2 = new MyLabel("", new Font("Arial, " +
            "sans-serif;",
            Font.PLAIN, 22), Color.black);
    JSeparator separator = new JSeparator();
    JRadioButton sex_man = new JRadioButton("男");
    JRadioButton sex_woman = new JRadioButton("女");
    ButtonGroup buttons = new ButtonGroup();
    DatePicker datePicker = new DatePicker(this, new Date());
    MyText phone_text = new MyText(new Dimension(200, 30));
    MyLabel registertime2_label = new MyLabel("", new Font("Arial," +
            " sans-serif;", Font.PLAIN, 20), Color.black);
    MyButton1 edit_button = new MyButton1(100, 30, 5, Color.white, "编辑资料", 18,
            Color.BLACK);
    MyButton1 cancel_button = new MyButton1(100, 30, 5, Color.white, "取  消", 18,
            Color.BLACK);
    MyButton1 upload_button = new MyButton1(80, 25, 5, Color.white, "上传头像", 16,
            Color.BLACK);
    private Thread updateThread;
    private Boolean isRunning = true;
    private Boolean isEditing = false;

    public SelfInfo_Panel() {
        Init();
    }

    void Init() {

        ThreadCreate();
        ThreadStart();

        setBackground(new Color(240, 243, 249));
        setPreferredSize(new Dimension(800, 650));
        setOpaque(true);
        setLayout(new FreeLayout());

        sex_woman.setEnabled(false);
        sex_man.setEnabled(false);
        edit_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (edit_button.getText().equals("编辑资料")) {
                    isEditing = true;
                    edit_button.setText("保  存");
                    sex_man.setEnabled(true);
                    sex_woman.setEnabled(true);
                    phone_text.setVisible(true);
                    phone_text.setEnabled(true);
                    phone_label2.setVisible(false);
                    datePicker.setEnabled(true);
                    cancel_button.setVisible(true);
                } else if (edit_button.getText().equals("保  存")) {
                    int id = User.CurrentUser.getId();
                    String sex = sex_man.isSelected() ? User.MALE : User.FEMALE;
                    Date date = (Date) datePicker.getValue();
                    String phone = phone_text.getText();
                    //检测手机号是否全是数字
                    if (!(phone.trim().length() == 11 && phone.trim().matches("[0-9]+"))) {
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(SelfInfo_Panel.this),
                                "手机号格式错误!");
                        return;
                    }
                    isEditing = false;
                    try {
                        User user_filter = new User();
                        user_filter.setId(id);
                        user_filter.setSex(sex);
                        user_filter.setBirthday(date);
                        user_filter.setPhoneNumber(phone);
                        User.updateUser(user_filter);
                        User.CurrentUser =
                                User.getUsers(user_filter, User.sql_default).get(0);
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(SelfInfo_Panel.this), "修改成功!");
                    } catch (NoSuchAlgorithmException | SQLException |
                             ClassNotFoundException |
                             IOException ex) {
                        SqlError.quit(SelfInfo_Panel.this, "更新用户信息失败!" + ex.getMessage());
                    }
                    edit_button.setText("编辑资料");
                    sex_man.setEnabled(false);
                    sex_woman.setEnabled(false);
                    phone_text.setVisible(false);
                    phone_label2.setVisible(true);
                    datePicker.setEnabled(false);
                    cancel_button.setVisible(false);
                }
            }
        });

        cancel_button.setVisible(false);
        cancel_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isEditing = false;
                edit_button.setText("编辑资料");
                sex_man.setEnabled(false);
                sex_woman.setEnabled(false);
                phone_text.setVisible(false);
                phone_label2.setVisible(true);
                datePicker.setEnabled(false);
                cancel_button.setVisible(false);
            }
        });
        upload_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setFileFilter(new FileNameExtensionFilter("图片文件", "jpg", "png", "jpeg"));
                int result =
                        fileChooser.showOpenDialog(SelfInfo_Panel.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    if (CheckLargeImg.isLargeImg(file)) {
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(SelfInfo_Panel.this),
                                "图片过大，请重新选择!");
                    } else {
                        try {
                            User user_filter = new User();
                            user_filter.setId(User.CurrentUser.getId());
                            user_filter.setHeadiconPath(file.getAbsolutePath());
                            User.updateUser(user_filter);
                            User.CurrentUser =
                                    User.getUsers(user_filter, User.sql_default).get(0);
                            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(SelfInfo_Panel.this),
                                    "上传成功!");
                        } catch (NoSuchAlgorithmException | SQLException |
                                 ClassNotFoundException |
                                 IOException ex) {
                            SqlError.quit(SelfInfo_Panel.this, "上传头像失败!" + ex.getMessage());
                        }
                    }
                }
            }
        });

        datePicker.setPattern("yyyy-MM-dd");
        datePicker.setEnabled(false);
        datePicker.setEditorable(false);
        datePicker.setPreferredSize(new Dimension(200, 30));
        datePicker.getField().setBackground(Color.WHITE);
        datePicker.getField().setFont(new Font("Arial, sans-serif;",
                Font.PLAIN, 18));

        phone_text.setFont(new Font("Arial, sans-serif;", Font.PLAIN, 20));
        sex_man.setOpaque(false);
        sex_woman.setOpaque(false);
        sex_man.setFont(new Font("Arial, sans-serif;", Font.BOLD, 22));
        sex_woman.setFont(new Font("Arial, sans-serif;", Font.BOLD, 22));
        buttons.add(sex_man);
        buttons.add(sex_woman);
        phone_text.setEnabled(false);
        phone_text.setVisible(false);


        separator.setForeground(Color.BLUE);
        int offset_x = 100;
        add(panel_label, new Margin(10, 10, -1, -1));
        add(separator, new Margin(50, 0, -1, 0));
        add(myHeadIcon,
                new Margin((int) (getPreferredSize().getHeight() / 8),
                        (int) ((getPreferredSize().getWidth() - myHeadIcon.getPreferredSize().getWidth()) / 2), -1,
                        -1));
        add(username_label1, new Margin(200, 120 + offset_x, -1, -1));
        add(username_label2, new Margin(200, 250 + offset_x, -1, -1));
        add(sex_label, new Margin(260, 120 + offset_x, -1, -1));
        add(sex_man, new Margin(260, 250 + offset_x, -1, -1));
        add(sex_woman, new Margin(260, 330 + offset_x, -1, -1));
        add(birthday_label, new Margin(320, 120 + offset_x, -1, -1));
        add(datePicker, new Margin(320, 250 + offset_x, -1, -1));
        add(phone_label1, new Margin(380, 120 + offset_x, -1, -1));
        add(phone_text, new Margin(380, 250 + offset_x, -1, -1));
        add(phone_label2, new Margin(380, 250 + offset_x, -1, -1));
        add(registertime1_label, new Margin(440, 120 + offset_x, -1, -1));
        add(registertime2_label, new Margin(440, 250 + offset_x, -1, -1));
        add(edit_button, new Margin(500, 250 + offset_x, -1, -1));
        add(cancel_button, new Margin(500, 380 + offset_x, -1, -1));
        add(upload_button,
                new Margin((int)
                        (getPreferredSize().getHeight() / 8 +
                                (myHeadIcon.getPreferredSize().getHeight() - upload_button.getPreferredSize().getHeight()) / 2),
                        410 + offset_x, -1, -1));
    }

    private void UpdatedynamicUI() {
        if (User.CurrentUser != null) {
            username_label2.setText(User.CurrentUser.getName());

            if (User.CurrentUser.getSex().equals(User.MALE)) {
                sex_man.setSelected(true);
            } else if (User.CurrentUser.getSex().equals(User.FEMALE)) {
                sex_woman.setSelected(true);
            }
            if (User.CurrentUser.getBirthday() != null) {
                datePicker.setDate(User.CurrentUser.getBirthday());
            }
            if (User.CurrentUser.getPhoneNumber() != null) {
                phone_label2.setText(User.CurrentUser.getPhoneNumber());
                phone_text.setText(User.CurrentUser.getPhoneNumber());
            }
            if (User.CurrentUser.getHeadicon() != null) {
                myHeadIcon.setImage(User.CurrentUser.getHeadicon());
            }
            String date =
                    User.CurrentUser.getRegisterDate().toString();
            date = date.substring(0, date.length() - 2);
            registertime2_label.setText(date);
            this.repaint();
        } else {
            SqlError.quit(SelfInfo_Panel.this, "请先登录!");
        }
    }

    public void ThreadClose() {
        isRunning = false;
    }

    public void ThreadCreate() {
        isRunning = true;
        updateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning) {
                    if (!isEditing && !Thread.currentThread().isInterrupted()) {
                        UpdatedynamicUI();
                    }
                    try {
                        ThreadInfo.printThreadInfo("SelfInfo_Panel");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
    }

    public void ThreadStart() {
        isRunning = true;
        updateThread.start();
    }

    public boolean getThreadState() {
        return isRunning;
    }
}
