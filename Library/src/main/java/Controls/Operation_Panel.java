package Controls;

import Datas.Operation;
import Datas.User;
import Tools.*;
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

public class Operation_Panel extends JPanel {
    Font font = new Font("Arial,sans-serif;", Font.BOLD, 18);
    MyLabel help_label = new MyLabel("<html" +
            ">请输入需要查询的借阅信息，并点击查询按钮进行查询，未填写的条件不加入查询范围内。</html>",
            new Font(
                    "Arial, " +
                            "sans-serif;", Font.BOLD, 17), Color.red);
    MyLabel panel_label = new MyLabel("借阅记录", new Font("Arial, " +
            "sans-serif;", Font.BOLD, 25), Color.black);
    MyLabel bookname_label = new MyLabel("书名", font, Color.black);
    MyLabel bookoperation_label = new MyLabel("操作", font, Color.black);
    MyLabel bookisaccept_label = new MyLabel("是否批准", font, Color.black);
    MyLabel bookoperationdate_label = new MyLabel("操作时间", font, Color.black);
    MyLabel bookreturndate_label = new MyLabel("应还时间", font, Color.black);
    MyLabel bookfine_label = new MyLabel("罚款", font, Color.black);
    MyLabel bookquantity_label = new MyLabel("借阅量", font, Color.black);
    MyLabel sortkey_label = new MyLabel("排序关键字", font, Color.black);
    MyLabel sortorder_label = new MyLabel("排序方式", font, Color.black);
    MyLabel range1_label = new MyLabel("～", font, Color.black);
    MyLabel range2_label = new MyLabel("～", font, Color.black);
    MyLabel range3_label = new MyLabel("～", font, Color.black);
    MyLabel countitem = new MyLabel("", font, Color.black);
    MyButton1 search_button = new MyButton1(80, 25, 5, Color.white, "查 询", 18,
            Color.BLACK);
    MyText bookname_text = new MyText(new Dimension(180, 25), 255);
    MyText bookfine_text = new MyText(new Dimension(180, 25), 10);
    MyText bookquantity1_text = new MyText(new Dimension(180, 25), 10);
    MyText bookquantity2_text = new MyText(new Dimension(180, 25), 10);
    DatePicker bookreturndate1 = new DatePicker(this, null);
    DatePicker bookreturndate2 = new DatePicker(this, null);
    DatePicker bookoperatedate1 = new DatePicker(this, null);
    DatePicker bookoperatedate2 = new DatePicker(this, null);

    JComboBox<String> sortkey_combo = new JComboBox<String>();
    JComboBox<String> sortorder_combo = new JComboBox<String>();
    JComboBox<String> bookoperation_combo = new JComboBox<String>();
    JComboBox<String> bookisaccept_combo = new JComboBox<String>();
    JSeparator separator1 = new JSeparator();
    JSeparator separator2 = new JSeparator();

    String[] table_keys = {"借用者", "书名", "操作", "操作时间", "应还时间", "罚款", "借阅量/归还量",
            "批准"};
    OperationsTable operationsTable = new OperationsTable(table_keys);
    Thread updateThread;
    boolean isRunning = true;

    public Operation_Panel() {
        Init();
    }

    void Init() {

        setBackground(new Color(240, 243, 249));
        setPreferredSize(new Dimension(700, 550));
        setOpaque(true);
        setLayout(new FreeLayout());
        separator1.setForeground(Color.MAGENTA);
        separator2.setForeground(new Color(0, 0, 0, 50));

        bookoperation_combo.setFont(font);
        bookoperation_combo.setBackground(Color.white);
        bookoperation_combo.setPreferredSize(new Dimension(120, 25));
        bookoperation_combo.addItem("--请选择--");
        bookoperation_combo.addItem(Operation.BORROWED);
        bookoperation_combo.addItem(Operation.RETURNED);

        bookisaccept_combo.setFont(font);
        bookisaccept_combo.setBackground(Color.white);
        bookisaccept_combo.setPreferredSize(new Dimension(120, 25));
        bookisaccept_combo.addItem("--请选择--");
        bookisaccept_combo.addItem(Operation.ACCEPTED);
        bookisaccept_combo.addItem(Operation.REJECTED);

        sortkey_combo.setFont(font);
        sortorder_combo.setFont(font);
        sortkey_combo.setBackground(Color.WHITE);
        sortorder_combo.setBackground(Color.WHITE);
        sortkey_combo.setPreferredSize(new Dimension(120, 25));
        sortorder_combo.setPreferredSize(new Dimension(120, 25));
        sortkey_combo.addItem("--请选择--");
        sortkey_combo.addItem("书名");
        sortkey_combo.addItem("操作");
        sortkey_combo.addItem("是否批准");
        sortkey_combo.addItem("罚款");
        sortkey_combo.addItem("应还时间");
        sortkey_combo.addItem("操作时间");
        sortkey_combo.addItem("借阅量");

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

        bookname_text.setFont(font);
        bookfine_text.setFont(font);
        bookquantity1_text.setFont(font);
        bookquantity2_text.setFont(font);

        bookreturndate1.setPattern("yyyy-MM-dd");
        bookreturndate1.setEditorable(false);
        bookreturndate1.setPreferredSize(new Dimension(180, 25));
        bookreturndate1.getField().setBackground(Color.WHITE);
        bookreturndate1.getField().setFont(new Font("Arial, sans-serif;",
                Font.PLAIN, 18));
        bookreturndate2.setPattern("yyyy-MM-dd");
        bookreturndate2.setEditorable(false);
        bookreturndate2.setPreferredSize(new Dimension(180, 25));
        bookreturndate2.getField().setBackground(Color.WHITE);
        bookreturndate2.getField().setFont(new Font("Arial, sans-serif;",
                Font.PLAIN, 18));
        bookoperatedate1.setPattern("yyyy-MM-dd");
        bookoperatedate1.setEditorable(false);
        bookoperatedate1.setPreferredSize(new Dimension(180, 25));
        bookoperatedate1.getField().setBackground(Color.WHITE);
        bookoperatedate1.getField().setFont(new Font("Arial, sans-serif;",
                Font.PLAIN, 18));
        bookoperatedate2.setPattern("yyyy-MM-dd");
        bookoperatedate2.setEditorable(false);
        bookoperatedate2.setPreferredSize(new Dimension(180, 25));
        bookoperatedate2.getField().setBackground(Color.WHITE);
        bookoperatedate2.getField().setFont(new Font("Arial, sans-serif;",
                Font.PLAIN, 18));


        search_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Judgespchar.check(bookname_text.getText().trim()) && bookname_text.getText().trim().length() != 0) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Operation_Panel.this),
                            "书名包含特殊字符!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (!Str2NumCheck.isUnsignedDoubleValue(bookfine_text.getText().trim()) && bookfine_text.getText().trim().length() != 0) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Operation_Panel.this), "请输入正确的罚款!"
                            , "提示", JOptionPane.WARNING_MESSAGE);
                } else if (!((bookreturndate1.getValue() == null && bookreturndate2.getValue() == null) ||
                        (bookreturndate1.getValue() != null && bookreturndate2.getValue() != null &&
                                (((Date) bookreturndate1.getValue()).before((Date) bookreturndate2.getValue()) || bookreturndate1.getValue().equals(bookreturndate2.getValue()))))) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Operation_Panel.this),
                            "请输入正确的归还日期!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (!((bookoperatedate1.getValue() == null && bookoperatedate2.getValue() == null) ||
                        (bookoperatedate1.getValue() != null && bookoperatedate2.getValue() != null &&
                                (((Date) bookoperatedate1.getValue()).before((Date) bookoperatedate2.getValue()) || bookoperatedate1.getValue().equals(bookoperatedate2.getValue()))))) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Operation_Panel.this),
                            "请输入正确的操作日期!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (!((bookquantity1_text.getText().trim().isEmpty() && bookquantity2_text.getText().trim().isEmpty()) ||
                        (Str2NumCheck.isIntValue(bookquantity1_text.getText().trim()) && Str2NumCheck.isIntValue(bookquantity2_text.getText().trim())
                                && Integer.parseInt(bookquantity1_text.getText().trim()) <= Integer.parseInt(bookquantity2_text.getText().trim())))) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Operation_Panel.this),
                            "请输入正确的借阅量!", "提示", JOptionPane.WARNING_MESSAGE);
                } else {
                    Operation operation_filter = new Operation();
                    operation_filter.setUserName(User.CurrentUser.getName());
                    if (!bookname_text.getText().trim().isEmpty()) {
                        operation_filter.setBookName("%" + bookname_text.getText().trim() + "%");
                    }
                    if (bookoperation_combo.getSelectedIndex() != 0) {
                        if (bookoperation_combo.getSelectedIndex() == 1) {
                            operation_filter.setOperation(Operation.BORROWED);
                        } else if (bookoperation_combo.getSelectedIndex() == 2) {
                            operation_filter.setOperation(Operation.RETURNED);
                        }
                    }
                    if (bookisaccept_combo.getSelectedIndex() != 0) {
                        if (bookisaccept_combo.getSelectedIndex() == 1) {
                            operation_filter.setStatus(Operation.ACCEPTED);
                        } else if (bookisaccept_combo.getSelectedIndex() == 2) {
                            operation_filter.setStatus(Operation.REJECTED);
                        }
                    }
                    if (!bookfine_text.getText().trim().isEmpty()) {
                        operation_filter.setFine(Double.parseDouble(bookfine_text.getText().trim()));
                    }
                    String sql1 = "SELECT * FROM operationinfo_user WHERE " +
                            "(date = ? OR ? IS NULL) AND " +
                            "(bookname LIKE ? OR ? IS NULL) AND " +
                            "(username LIKE ? OR ? IS NULL) AND " +
                            "(operation LIKE ? OR ? IS NULL) AND " +
                            "(returntime = ? OR ? IS NULL) AND " +
                            "(fine = ? OR ? IS NULL) AND " +
                            "(quantity = ? OR ? IS NULL) AND " +
                            "(status = ? OR ? IS NULL) ";
                    String sql2 = "AND (returntime BETWEEN IFNULL(?,returntime) AND IFNULL(?,returntime) OR " +
                            "returntime IS NULL)" +
                            "AND (date BETWEEN IFNULL(?,date) AND IFNULL(?,date) OR date IS NULL)" +
                            "AND (quantity BETWEEN IFNULL(?,quantity) AND IFNULL(?,quantity) OR quantity IS NULL)";
                    String sql3 = "";
                    if (sortkey_combo.getSelectedIndex() != 0) {
                        sql3 = "ORDER BY ";
                        switch (sortkey_combo.getSelectedIndex()) {
                            case 1 -> sql3 += "bookname";
                            case 2 -> sql3 += "operation";
                            case 3 -> sql3 += "status";
                            case 4 -> sql3 += "fine";
                            case 5 -> sql3 += "returntime";
                            case 6 -> sql3 += "date";
                            case 7 -> sql3 += "quantity";
                        }
                        if (sortorder_combo.getSelectedIndex() == 1) {
                            sql3 += " ASC";
                        } else if (sortorder_combo.getSelectedIndex() == 2) {
                            sql3 += " DESC";
                        }
                    }
                    try {
                        PreparedStatement stmt = Connect.conn.prepareStatement(sql2);
                        Date date1 = (Date) bookreturndate1.getValue();
                        Date date2 = (Date) bookreturndate2.getValue();
                        Date date3 = (Date) bookoperatedate1.getValue();
                        Date date4 = (Date) bookoperatedate2.getValue();
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
                        if (bookquantity1_text.getText().trim().isEmpty()) {
                            stmt.setNull(index++, Types.INTEGER);
                        } else {
                            stmt.setInt(index++, Integer.parseInt(bookquantity1_text.getText().trim()));
                        }
                        if (bookquantity2_text.getText().trim().isEmpty()) {
                            stmt.setNull(index, Types.INTEGER);
                        } else {
                            stmt.setInt(index, Integer.parseInt(bookquantity2_text.getText().trim()));
                        }
                        sql2 = stmt.toString().substring(stmt.toString().indexOf(":") + 1);
                        operationsTable.setData(Operation.getOperationinfo_User(operation_filter, sql1 + sql2 + sql3));
                        countitem.setText("共 " + operationsTable.table.getRowCount() + " 项");
                    } catch (SQLException ex) {
                        SqlError.quit(Operation_Panel.this, "数据库错误!" + ex.getMessage());
                    }
                }
            }
        });

        add(panel_label, new Margin(10, 10, -1, -1));
        add(separator1, new Margin(50, 0, -1, 0));
        add(help_label, new Margin(60, 10, -1, 0));
        add(bookname_label, new Margin(100, 10, -1, -1));
        add(bookoperation_label, new Margin(140, 10, -1, -1));
        add(bookisaccept_label, new Margin(180, 10, -1, -1));
        add(bookfine_label, new Margin(220, 10, -1, -1));
        add(bookreturndate_label, new Margin(100, 340, -1, -1));
        add(bookoperationdate_label, new Margin(140, 340, -1, -1));
        add(bookquantity_label, new Margin(180, 340, -1, -1));
        add(sortkey_label, new Margin(220, 340, -1, -1));
        add(sortorder_label, new Margin(220, 600, -1, -1));
        add(range1_label, new Margin(100, 615, -1, -1));
        add(range2_label, new Margin(140, 615, -1, -1));
        add(range3_label, new Margin(180, 615, -1, -1));
        int left1 = (int) (bookoperationdate_label.getPreferredSize().getWidth() + 20);
        int left2 = (int) (bookreturndate_label.getPreferredSize().getWidth() + 355);
        int left3 = (int) (range1_label.getPreferredSize().getWidth() + 605);
        add(bookname_text, new Margin(100, left1, -1, -1));
        add(bookoperation_combo, new Margin(140, left1, -1, -1));
        add(bookisaccept_combo, new Margin(180, left1, -1, -1));
        add(bookfine_text, new Margin(220, left1, -1, -1));
        add(bookreturndate1, new Margin(100, left2, -1, -1));
        add(bookreturndate2, new Margin(100, -1, -1, 5));
        add(bookoperatedate1, new Margin(140, left2, -1, -1));
        add(bookoperatedate2, new Margin(140, -1, -1, 5));
        add(bookquantity1_text, new Margin(180, left2, -1, -1));
        add(bookquantity2_text, new Margin(180, -1, -1, 5));
        add(sortkey_combo, new Margin(220, left2 + 20, -1, -1));
        add(sortorder_combo, new Margin(220, left3 + 70, -1, -1));
        add(search_button, new Margin(253, -1, -1, 5));
        add(separator2, new Margin(250, 0, -1, 0));
        add(operationsTable, new Margin(280, 5, 32, 5));
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
    }

    public void ThreadClose() {
        isRunning = false;
    }

    public boolean getThreadState() {
        return isRunning;
    }
}
