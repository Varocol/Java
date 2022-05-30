package Controls;

import Datas.Operation;
import Datas.User;
import Tools.Connect;
import Tools.Resources;
import Tools.SqlError;
import Tools.Str2NumCheck;
import af.swing.layout.FreeLayout;
import af.swing.layout.Margin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class BookReturn_Dialog extends JDialog {
    MyButton1 confirm = new MyButton1(60, 30, 5, Color.white, "确认", 18,
            Color.BLACK);
    MyButton1 cancel = new MyButton1(60, 30, 5, Color.white, "取消", 18,
            Color.BLACK);
    MyLabel rent_info = new MyLabel("归还书籍信息", new Font("Arial, sans-serif;",
            Font.BOLD, 25), Color.BLACK);
    MyLabel user_name1 = new MyLabel("归还者", new Font("Arial, sans-serif;",
            Font.BOLD, 20), Color.BLACK);
    MyLabel book_name1 = new MyLabel("书名", new Font("Arial, sans-serif;",
            Font.BOLD, 20), Color.BLACK);
    MyLabel book_returntime1 = new MyLabel("应还日期", new Font("Arial, " +
            "sans-serif;",
            Font.BOLD, 20), Color.BLACK);
    MyLabel book_returntime2 = new MyLabel("", new Font("Arial, " +
            "sans-serif;",
            Font.BOLD, 20), Color.BLACK);
    MyLabel book_totalrent1 = new MyLabel("总借阅量", new Font("Arial, " +
            "sans-serif;",
            Font.BOLD, 20), Color.BLACK);
    MyLabel book_totalrent2 = new MyLabel("", new Font("Arial, " +
            "sans-serif;",
            Font.BOLD, 20), Color.BLACK);
    MyLabel book_amount1 = new MyLabel("归还量", new Font("Arial, sans-serif;",
            Font.BOLD, 20), Color.BLACK);
    MyLabel user_name2 = new MyLabel("", new Font("Arial, sans-serif;",
            Font.BOLD, 20), Color.BLACK);
    MyLabel book_name2 = new MyLabel("", new Font("Arial, sans-serif;",
            Font.BOLD, 20), Color.BLACK);
    MyText book_amount2 = new MyText(new Dimension(200, 30));

    Integer totalrent;
    Date returntime = new Date();

    public BookReturn_Dialog(Window owner, List<Object> list) {
        super(owner);
        user_name2.setText(User.CurrentUser.getName());
        book_name2.setText((String) list.get(2));
        book_amount2.setFont(new Font("Arial, sans-serif;", Font.PLAIN, 18));
        //查询总借阅量
        try {
            String sql = "select sum(quantity) as sum from operation where " +
                    "bookname = ? and username = ? and operation = ? and status = ? and bookid = ?";
            PreparedStatement stmt = Connect.conn.prepareStatement(sql);
            int index = 1;
            stmt.setString(index++, (String) list.get(2));
            stmt.setString(index++, User.CurrentUser.getName());
            stmt.setString(index++, Operation.BORROWED);
            stmt.setString(index++, Operation.ACCEPTED);
            stmt.setInt(index, (Integer) list.get(1));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalrent = rs.getInt("sum");
            }
            index = 1;
            stmt.setString(index++, (String) list.get(2));
            stmt.setString(index++, User.CurrentUser.getName());
            stmt.setString(index++, Operation.RETURNED);
            stmt.setString(index, Operation.ACCEPTED);
            stmt.setInt(index, (Integer) list.get(1));
            rs = stmt.executeQuery();
            if (rs.next()) {
                totalrent -= rs.getInt("sum");
            }
            if (totalrent < 0) {
                SqlError.quit(BookReturn_Dialog.this, "总借阅量错误,请联系管理员检查数据!");
            } else if (totalrent == 0) {
                JOptionPane.showMessageDialog(BookReturn_Dialog.this,
                        "您未借阅此书，无需归还!", "提示", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        } catch (SQLException e) {
            SqlError.quit(BookReturn_Dialog.this, "查询总借阅量失败" + e.getMessage());
        }
        book_totalrent2.setText(String.valueOf(totalrent));
        //查询归还时间
        try {
            Operation operation_filter = new Operation();
            operation_filter.setBookName(book_name2.getText());
            operation_filter.setUserName(user_name2.getText());
            operation_filter.setOperation(Operation.BORROWED);
            operation_filter.setStatus(Operation.ACCEPTED);
            String sql = Operation.operationinfo_user_sql_default;
            //查询最后一次借阅时间
            sql += "ORDER BY date DESC LIMIT 1";
            Operation operation = Operation.getOperationinfo_User(operation_filter, sql).get(0);
            if (operation != null) {
                returntime = operation.getDateReturn();
                book_returntime2.setText(operation.getDateReturn().toString());
            }
        } catch (SQLException e) {
            SqlError.quit(BookReturn_Dialog.this, "查询归还时间失败" + e.getMessage());
        }

        confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!Str2NumCheck.isUnsignedIntValue(book_amount2.getText().trim()) || Integer.parseInt(book_amount2.getText().trim()) == 0) {
                    JOptionPane.showMessageDialog(BookReturn_Dialog.this,
                            "请输入正确的归还数量!", "提示", JOptionPane.INFORMATION_MESSAGE);
                } else if (Integer.parseInt(book_amount2.getText().trim()) > totalrent) {
                    JOptionPane.showMessageDialog(BookReturn_Dialog.this,
                            "归还数量不能大于总借阅量!", "提示", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    try {
                        Operation operation = new Operation();
                        operation.setBookName((String) list.get(2));
                        operation.setUserName(User.CurrentUser.getName());
                        operation.setOperation(Operation.RETURNED);
                        operation.setDateReturn(returntime);
                        operation.setQuantity(Integer.parseInt(book_amount2.getText().trim()));
                        operation.setBookId((Integer) list.get(1));
                        Operation.addOperation(operation);
                        JOptionPane.showMessageDialog(BookReturn_Dialog.this,
                                "归还成功,请联系管理员批准操作!"
                                , "提示",
                                JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(BookReturn_Dialog.this,
                                "归还失败!" + ex.getMessage()
                                , "提示", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });

        setSize(400, 400);
        setLayout(new FreeLayout());

        setForeground(new Color(240, 243, 249));
        int left1 = 50;
        int left2 = 150;
        add(rent_info,
                new Margin(10,
                        (int) ((getSize().getWidth() - rent_info.getPreferredSize().getWidth()) / 2), -1, -1));
        add(user_name1, new Margin(50, left1, -1, -1));
        add(user_name2, new Margin(50, left2, -1, -1));
        add(book_name1, new Margin(100, left1, -1, -1));
        add(book_name2, new Margin(100, left2, -1, -1));
        add(book_totalrent1, new Margin(150, left1, -1, -1));
        add(book_totalrent2, new Margin(150, left2, -1, -1));
        add(book_returntime1, new Margin(200, left1, -1, -1));
        add(book_returntime2, new Margin(200, left2, -1, -1));
        add(book_amount1, new Margin(250, left1, -1, -1));
        add(book_amount2, new Margin(250, left2, -1, -1));
        add(confirm, new Margin(-1, 100, 20, -1));
        add(cancel, new Margin(-1, -1, 20, 100));
        setTitle("归还信息");
        setIconImage(Resources.BOOKICON);
        setLocationRelativeTo(owner);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        setVisible(true);
    }
}
