package Controls;

import Datas.Operation;
import Datas.User;
import Tools.Resources;
import Tools.Str2NumCheck;
import af.swing.layout.FreeLayout;
import af.swing.layout.Margin;
import com.eltima.components.ui.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class BookRent_Dialog extends JDialog {
    MyButton1 confirm = new MyButton1(60, 30, 5, Color.white, "确认", 18,
            Color.BLACK);
    MyButton1 cancel = new MyButton1(60, 30, 5, Color.white, "取消", 18,
            Color.BLACK);
    MyLabel rent_info = new MyLabel("借阅书籍信息", new Font("Arial, sans-serif;",
            Font.BOLD, 25), Color.BLACK);
    MyLabel user_name1 = new MyLabel("借阅者", new Font("Arial, sans-serif;",
            Font.BOLD, 20), Color.BLACK);
    MyLabel book_name1 = new MyLabel("书名", new Font("Arial, sans-serif;",
            Font.BOLD, 20), Color.BLACK);
    MyLabel book_returntime1 = new MyLabel("应还日期", new Font("Arial, " +
            "sans-serif;",
            Font.BOLD, 20), Color.BLACK);
    MyLabel book_amount1 = new MyLabel("借阅量", new Font("Arial, sans-serif;",
            Font.BOLD, 20), Color.BLACK);
    MyLabel user_name2 = new MyLabel("", new Font("Arial, sans-serif;",
            Font.BOLD, 20), Color.BLACK);
    MyLabel book_name2 = new MyLabel("", new Font("Arial, sans-serif;",
            Font.BOLD, 20), Color.BLACK);
    DatePicker book_returntime2 = new DatePicker(this,
            new Date(new Date().getTime() + 24 * 60 * 60 * 1000));
    MyText book_amount2 = new MyText(new Dimension(200, 30));

    public BookRent_Dialog(Window owner, List<Object> list) {
        super(owner);
        setSize(400, 350);
        setLayout(new FreeLayout());

        setForeground(new Color(240, 243, 249));
        book_returntime2.setPattern("yyyy-MM-dd");
        book_returntime2.setEnabled(true);
        book_returntime2.setEditorable(false);
        book_returntime2.setPreferredSize(new Dimension(200, 30));
        book_returntime2.getField().setBackground(Color.WHITE);
        book_returntime2.getField().setFont(new Font("Arial, sans-serif;",
                Font.PLAIN, 18));
        user_name2.setText(User.CurrentUser.getName());
        book_name2.setText((String) list.get(2));
        book_amount2.setFont(new Font("Arial, sans-serif;", Font.PLAIN, 18));

        confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (book_amount2.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(BookRent_Dialog.this, "请输入借阅量!"
                            , "提示",
                            JOptionPane.WARNING_MESSAGE);
                } else if (!Str2NumCheck.isUnsignedIntValue(book_amount2.getText().trim()) || book_amount2.getText().trim().equals("0")) {
                    JOptionPane.showMessageDialog(BookRent_Dialog.this,
                            "请输入正确的借阅量!"
                            , "提示",
                            JOptionPane.WARNING_MESSAGE);
                } else if (book_returntime2.getValue() == null || ((Date) book_returntime2.getValue()).before(new Date()) || book_returntime2.getValue().equals(new Date())) {
                    JOptionPane.showMessageDialog(BookRent_Dialog.this,
                            "请输入正确的应还日期!"
                            , "提示",
                            JOptionPane.WARNING_MESSAGE);
                } else if (Integer.parseInt(book_amount2.getText().trim()) > (Integer) list.get(7)) {
                    JOptionPane.showMessageDialog(BookRent_Dialog.this,
                            "借阅量不能大于库存量!"
                            , "提示", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        Operation operation = new Operation();
                        operation.setBookName((String) list.get(2));
                        operation.setUserName(User.CurrentUser.getName());
                        operation.setOperation(Operation.BORROWED);
                        operation.setDateReturn((Date) book_returntime2.getValue());
                        operation.setQuantity(Integer.parseInt(book_amount2.getText().trim()));
                        operation.setBookId((Integer) list.get(1));
                        Operation.addOperation(operation);
                        JOptionPane.showMessageDialog(BookRent_Dialog.this,
                                "借阅成功,请联系管理员批准操作!"
                                , "提示",
                                JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(BookRent_Dialog.this,
                                "借阅失败!"+ex.getMessage()
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


        int left1 = 50;
        int left2 = 150;
        add(rent_info,
                new Margin(10,
                        (int) ((getSize().getWidth() - rent_info.getPreferredSize().getWidth()) / 2), -1, -1));
        add(user_name1, new Margin(50, left1, -1, -1));
        add(user_name2, new Margin(50, left2, -1, -1));
        add(book_name1, new Margin(100, left1, -1, -1));
        add(book_name2, new Margin(100, left2, -1, -1));
        add(book_returntime1, new Margin(150, left1, -1, -1));
        add(book_returntime2, new Margin(150, left2, -1, -1));
        add(book_amount1, new Margin(200, left1, -1, -1));
        add(book_amount2, new Margin(200, left2, -1, -1));
        add(confirm, new Margin(-1, 100, 20, -1));
        add(cancel, new Margin(-1, -1, 20, 100));
        setTitle("借阅信息");
        setIconImage(Resources.BOOKICON);
        setLocationRelativeTo(owner);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        setVisible(true);
    }
}
