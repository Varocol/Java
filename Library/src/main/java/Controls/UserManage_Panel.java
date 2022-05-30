package Controls;

import Datas.User;
import Tools.Connect;
import Tools.Judgespchar;
import Tools.SqlError;
import Tools.ThreadInfo;
import af.swing.layout.FreeLayout;
import af.swing.layout.Margin;
import com.eltima.components.ui.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

public class UserManage_Panel extends JPanel {
    Font font = new Font("Arial,sans-serif;", Font.BOLD, 18);
    MyLabel help_label = new MyLabel("<html" +
            ">请输入需要查询的借阅信息，并点击查询按钮进行查询，未填写的条件不加入查询范围内。</html>",
            new Font(
                    "Arial, " +
                            "sans-serif;", Font.BOLD, 17), Color.MAGENTA);
    MyLabel panel_label = new MyLabel("用户管理", new Font("Arial, " +
            "sans-serif;", Font.BOLD, 25), Color.black);
    MyLabel username_label = new MyLabel("用户名", font, Color.black);
    MyLabel userphone_label = new MyLabel("电话", font, Color.black);
    MyLabel usersex_label = new MyLabel("性别", font, Color.black);
    MyLabel userstate_label = new MyLabel("账号状态", font, Color.black);
    MyLabel userregistertime_label = new MyLabel("注册时间", font, Color.black);
    MyLabel userbirthday_label = new MyLabel("出生日期", font, Color.black);
    MyLabel sortkey_label = new MyLabel("排序关键字", font, Color.black);
    MyLabel sortorder_label = new MyLabel("排序方式", font, Color.black);
    MyLabel range1_label = new MyLabel("～", font, Color.black);
    MyLabel range2_label = new MyLabel("～", font, Color.black);
    MyLabel countitem = new MyLabel("", font, Color.black);
    MyButton1 search_button = new MyButton1(80, 25, 5, Color.white, "查 询", 18,
            Color.BLACK);
    MyButton1 add_user = new MyButton1(100, 25, 5, Color.white, "新增用户", 18,
            Color.BLACK);
    MyButton1 delete_user = new MyButton1(100, 25, 5, Color.white, "删除用户", 18,
            Color.BLACK);
    MyButton1 alter_user = new MyButton1(100, 25, 5, Color.white, "修改用户", 18,
            Color.BLACK);
    MyText username_text = new MyText(new Dimension(180, 25), 255);
    MyText userphone_text = new MyText(new Dimension(180, 25), 10);
    DatePicker userbirthday1 = new DatePicker(this, null);
    DatePicker userbirthday2 = new DatePicker(this, null);
    DatePicker userregistertime1 = new DatePicker(this, null);
    DatePicker userregistertime2 = new DatePicker(this, null);

    JComboBox<String> sortkey_combo = new JComboBox<String>();
    JComboBox<String> sortorder_combo = new JComboBox<String>();
    JComboBox<String> usersex_combo = new JComboBox<String>();
    JComboBox<String> userstate_combo = new JComboBox<String>();
    JSeparator separator1 = new JSeparator();
    JSeparator separator2 = new JSeparator();

    String[] table_keys = {"选择", "用户ID", "用户名", "性别", "电话号码", "账号状态", "出生日期", "注册时间"};
    UsersTable usersTable = new UsersTable(table_keys);
    User user_filter = new User();
    String sql;
    Thread updateThread;
    boolean isRunning = true;

    public UserManage_Panel() {
        Init();
    }

    void Init() {

        setBackground(new Color(240, 243, 249));
        setPreferredSize(new Dimension(700, 550));
        setOpaque(true);
        setLayout(new FreeLayout());
        separator1.setForeground(Color.MAGENTA);
        separator2.setForeground(new Color(0, 0, 0, 50));

        usersex_combo.setFont(font);
        usersex_combo.setBackground(Color.white);
        usersex_combo.setPreferredSize(new Dimension(120, 25));
        usersex_combo.addItem("--请选择--");
        usersex_combo.addItem(User.MALE);
        usersex_combo.addItem(User.FEMALE);

        userstate_combo.setFont(font);
        userstate_combo.setBackground(Color.white);
        userstate_combo.setPreferredSize(new Dimension(120, 25));
        userstate_combo.addItem("--请选择--");
        userstate_combo.addItem(User.UNACTIVATED);
        userstate_combo.addItem(User.COMMONUSER);

        sortkey_combo.setFont(font);
        sortorder_combo.setFont(font);
        sortkey_combo.setBackground(Color.WHITE);
        sortorder_combo.setBackground(Color.WHITE);
        sortkey_combo.setPreferredSize(new Dimension(120, 25));
        sortorder_combo.setPreferredSize(new Dimension(120, 25));
        sortkey_combo.addItem("--请选择--");
        sortkey_combo.addItem("用户ID");
        sortkey_combo.addItem("用户名");
        sortkey_combo.addItem("性别");
        sortkey_combo.addItem("账号状态");
        sortkey_combo.addItem("手机号");
        sortkey_combo.addItem("注册时间");
        sortkey_combo.addItem("出生日期");

        sortorder_combo.addItem("--请选择--");
        sortorder_combo.addItem("升序");
        sortorder_combo.addItem("降序");

        sortorder_combo.setEnabled(false);
        sortkey_combo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (sortkey_combo.getSelectedIndex() == 0) {
                    sortorder_combo.setEnabled(false);
                    sortorder_combo.setSelectedIndex(0);
                } else {
                    sortorder_combo.setEnabled(true);
                }
            }
        });

        username_text.setFont(font);
        userphone_text.setFont(font);

        userbirthday1.setPattern("yyyy-MM-dd");
        userbirthday1.setEditorable(false);
        userbirthday1.setPreferredSize(new Dimension(180, 25));
        userbirthday1.getField().setBackground(Color.WHITE);
        userbirthday1.getField().setFont(new Font("Arial, sans-serif;",
                Font.PLAIN, 18));
        userbirthday2.setPattern("yyyy-MM-dd");
        userbirthday2.setEditorable(false);
        userbirthday2.setPreferredSize(new Dimension(180, 25));
        userbirthday2.getField().setBackground(Color.WHITE);
        userbirthday2.getField().setFont(new Font("Arial, sans-serif;",
                Font.PLAIN, 18));
        userregistertime1.setPattern("yyyy-MM-dd");
        userregistertime1.setEditorable(false);
        userregistertime1.setPreferredSize(new Dimension(180, 25));
        userregistertime1.getField().setBackground(Color.WHITE);
        userregistertime1.getField().setFont(new Font("Arial, sans-serif;",
                Font.PLAIN, 18));
        userregistertime2.setPattern("yyyy-MM-dd");
        userregistertime2.setEditorable(false);
        userregistertime2.setPreferredSize(new Dimension(180, 25));
        userregistertime2.getField().setBackground(Color.WHITE);
        userregistertime2.getField().setFont(new Font("Arial, sans-serif;",
                Font.PLAIN, 18));


        search_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Judgespchar.check(username_text.getText().trim()) && username_text.getText().trim().length() != 0) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(UserManage_Panel.this),
                            "用户名包含特殊字符!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (!userphone_text.getText().trim().isEmpty() && !(userphone_text.getText().trim().length() == 11 && userphone_text.getText().trim().matches("[0" +
                        "-9]+"))) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(UserManage_Panel.this),
                            "手机号格式错误!");
                } else if (!((userbirthday1.getValue() == null && userbirthday2.getValue() == null) ||
                        (userbirthday1.getValue() != null && userbirthday2.getValue() != null &&
                                (((Date) userbirthday1.getValue()).before((Date) userbirthday2.getValue()) || userbirthday1.getValue().equals(userbirthday2.getValue()))))) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(UserManage_Panel.this),
                            "请输入正确的出生日期!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (!((userregistertime1.getValue() == null && userregistertime2.getValue() == null) ||
                        (userregistertime1.getValue() != null && userregistertime2.getValue() != null &&
                                (((Date) userregistertime1.getValue()).before((Date) userregistertime2.getValue()) || userregistertime1.getValue().equals(userregistertime2.getValue()))))) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(UserManage_Panel.this),
                            "请输入正确的注册时间!", "提示", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (!username_text.getText().trim().isEmpty()) {
                        user_filter.setName("%" + username_text.getText().trim() + "%");
                    } else {
                        user_filter.setName(null);
                    }
                    if (!userphone_text.getText().trim().isEmpty()) {
                        user_filter.setPhoneNumber(userphone_text.getText().trim());
                    } else {
                        user_filter.setPhoneNumber(null);
                    }
                    if (usersex_combo.getSelectedIndex() != 0) {
                        if (usersex_combo.getSelectedIndex() == 1) {
                            user_filter.setSex(User.MALE);
                        } else if (usersex_combo.getSelectedIndex() == 2) {
                            user_filter.setSex(User.FEMALE);
                        }
                    } else {
                        user_filter.setSex(null);
                    }
                    if (userstate_combo.getSelectedIndex() != 0) {
                        if (userstate_combo.getSelectedIndex() == 1) {
                            user_filter.setState(User.UNACTIVATED);
                        } else if (userstate_combo.getSelectedIndex() == 2) {
                            user_filter.setState(User.COMMONUSER);
                        }
                    } else {
                        user_filter.setState(null);
                    }
                    String sql1 = "SELECT * FROM user_view WHERE " +
                            "(id = ? OR ? IS NULL )AND " +
                            "(name LIKE ? OR ? IS NULL )AND " +
                            "(sex = ? OR ? IS NULL )AND " +
                            "(birthday = ? OR ? IS NULL )AND " +
                            "(phone = ? OR ? IS NULL )AND " +
                            "(registertime = ? OR ? IS NULL )AND " +
                            "(state = ? OR ? IS NULL ) ";
                    String sql2 = "AND (birthday BETWEEN IFNULL(?,birthday) AND IFNULL(?,birthday) OR birthday IS " +
                            "NULL)" +
                            "AND (registertime BETWEEN IFNULL(?,registertime) AND IFNULL(?,registertime) OR " +
                            "registertime IS NULL)" +
                            "AND state <> ? ";
                    String sql3 = "";
                    if (sortkey_combo.getSelectedIndex() != 0) {
                        sql3 = "ORDER BY ";
                        switch (sortkey_combo.getSelectedIndex()) {
                            case 1 -> sql3 += "id";
                            case 2 -> sql3 += "name";
                            case 3 -> sql3 += "sex";
                            case 4 -> sql3 += "state";
                            case 5 -> sql3 += "phone";
                            case 6 -> sql3 += "registertime";
                            case 7 -> sql3 += "birthday";
                        }
                        if (sortorder_combo.getSelectedIndex() == 1) {
                            sql3 += " ASC";
                        } else if (sortorder_combo.getSelectedIndex() == 2) {
                            sql3 += " DESC";
                        }
                    }
                    try {
                        PreparedStatement stmt = Connect.conn.prepareStatement(sql2);
                        Date date1 = (Date) userbirthday1.getValue();
                        Date date2 = (Date) userbirthday2.getValue();
                        Date date3 = (Date) userregistertime1.getValue();
                        Date date4 = (Date) userregistertime2.getValue();
                        int index = 1;
                        if (date1 == null) {
                            stmt.setNull(index++, Types.DATE);
                        } else {
                            stmt.setDate(index++, new java.sql.Date(date1.getTime()));
                        }
                        if (date2 == null) {
                            stmt.setNull(index++, Types.DATE);
                        } else {
                            stmt.setDate(index++, new java.sql.Date(date2.getTime()));
                        }
                        if (date3 == null) {
                            stmt.setNull(index++, Types.DATE);
                        } else {
                            stmt.setDate(index++, new java.sql.Date(date3.getTime()));
                        }
                        if (date4 == null) {
                            stmt.setNull(index++, Types.DATE);
                        } else {
                            stmt.setDate(index++, new java.sql.Date(date4.getTime()));
                        }
                        stmt.setString(index, User.ADMINISTRATOR);
                        sql2 = stmt.toString().substring(stmt.toString().indexOf(":") + 1);
                        sql = sql1 + sql2 + sql3;
                        Table_update();
                    } catch (SQLException ex) {
                        SqlError.quit(UserManage_Panel.this, "数据库错误!" + ex.getMessage());
                    }
                }
            }
        });
        add_user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserAdd_Dialog(SwingUtilities.getWindowAncestor(UserManage_Panel.this));
                try {
                    Table_update();
                } catch (SQLException ex) {
                    SqlError.quit(UserManage_Panel.this,
                            "表格信息更新失败!" + ex.getMessage());
                }
            }
        });
        delete_user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usersTable.getSelectedRows().size() == 0) {
                    JOptionPane.showMessageDialog(UserManage_Panel.this, "请选择要删除的用户!", "提示",
                            JOptionPane.WARNING_MESSAGE);
                } else if (JOptionPane.showConfirmDialog(SwingUtilities.getWindowAncestor(UserManage_Panel.this),
                        "确定要删除选中的" + usersTable.getSelectedRows().size() + "个用户吗?", "提示",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    int count = 0;
                    for (String str : usersTable.getSelectedRows()) {
                        int index = Integer.parseInt(str);
                        User user_filter = new User();
                        user_filter.setId((Integer) usersTable.model.getRowData().get(index).get(1));
                        try {
                            User.deleteUser(user_filter);
                            count++;
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(UserManage_Panel.this),
                                    "删除" + usersTable.model.getRowData().get(index).get(2) + "失败!" + ex.getMessage(),
                                    "提示",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(UserManage_Panel.this),
                            "共删除" + count + "/" + usersTable.getSelectedRows().size() + "项!", "提示",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                try {
                    Table_update();
                } catch (SQLException ex) {
                    SqlError.quit(UserManage_Panel.this,
                            "表格信息更新失败!" + ex.getMessage());
                }
            }
        });
        alter_user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usersTable.getSelectedRows().size() == 0){
                    JOptionPane.showMessageDialog(UserManage_Panel.this, "请选择要修改的用户!", "提示",
                            JOptionPane.WARNING_MESSAGE);
                }else {
                    for(String str : usersTable.getSelectedRows()){
                        int index = Integer.parseInt(str);
                        new UserUpdate_Dialog(SwingUtilities.getWindowAncestor(UserManage_Panel.this),
                                usersTable.model.getRowData().get(index));
                    }
                    try {
                        Table_update();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        add(panel_label, new Margin(10, 10, -1, -1));
        add(separator1, new Margin(50, 0, -1, 0));
        add(help_label, new Margin(60, 10, -1, 0));
        add(username_label, new Margin(100, 10, -1, -1));
        add(userphone_label, new Margin(140, 10, -1, -1));
        add(usersex_label, new Margin(180, 10, -1, -1));
        add(userstate_label, new Margin(220, 10, -1, -1));
        add(userregistertime_label, new Margin(100, 340, -1, -1));
        add(userbirthday_label, new Margin(140, 340, -1, -1));
        add(sortkey_label, new Margin(220, 340, -1, -1));
        add(sortorder_label, new Margin(220, 600, -1, -1));
        add(range1_label, new Margin(100, 615, -1, -1));
        add(range2_label, new Margin(140, 615, -1, -1));
        int left1 = (int) (userbirthday_label.getPreferredSize().getWidth() + 20);
        int left2 = (int) (userbirthday_label.getPreferredSize().getWidth() + 355);
        int left3 = (int) (range1_label.getPreferredSize().getWidth() + 605);
        add(username_text, new Margin(100, left1, -1, -1));
        add(userphone_text, new Margin(140, left1, -1, -1));
        add(usersex_combo, new Margin(180, left1, -1, -1));
        add(userstate_combo, new Margin(220, left1, -1, -1));
        add(userbirthday1, new Margin(100, left2, -1, -1));
        add(userbirthday2, new Margin(100, -1, -1, 5));
        add(userregistertime1, new Margin(140, left2, -1, -1));
        add(userregistertime2, new Margin(140, -1, -1, 5));
        add(sortkey_combo, new Margin(220, left2 + 20, -1, -1));
        add(sortorder_combo, new Margin(220, left3 + 70, -1, -1));
        add(search_button, new Margin(253, -1, -1, 5));
        add(add_user, new Margin(253, 5, -1, -1));
        add(delete_user, new Margin(253, 110, -1, -1));
        add(alter_user, new Margin(253, 215, -1, -1));
        add(separator2, new Margin(250, 0, -1, 0));
        add(usersTable, new Margin(280, 5, 32, 5));
        add(countitem, new Margin(-1, 5, 5, -1));
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
                        Thread.sleep(1000);
                        ThreadInfo.printThreadInfo("Operation_Panel");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void Table_update() throws SQLException {
        usersTable.setData(User.getUser_View(user_filter, sql));
        countitem.setText("共 " + usersTable.table.getRowCount() + " 项");
    }

    public void ThreadClose() {
        isRunning = false;
    }

    public boolean getThreadState() {
        return isRunning;
    }
}
