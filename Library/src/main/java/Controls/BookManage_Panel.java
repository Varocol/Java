package Controls;

import Datas.Book;
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
import java.util.Objects;

public class BookManage_Panel extends JPanel {
    Font font = new Font("Arial,sans-serif;", Font.BOLD, 18);
    MyLabel help_label = new MyLabel("<html" +
            ">请输入需要查询的书籍信息，并点击查询按钮进行查询，未填写的条件不加入查询范围内。</html>",
            new Font(
                    "Arial, " +
                            "sans-serif;", Font.BOLD, 17), Color.blue);
    MyLabel panel_label = new MyLabel("图书管理", new Font("Arial, " +
            "sans-serif;", Font.BOLD, 25), Color.black);
    MyLabel bookid_label = new MyLabel("编号", font, Color.black);
    MyLabel bookname_label = new MyLabel("书名", font, Color.black);
    MyLabel bookauthor_label = new MyLabel("作者", font, Color.black);
    MyLabel bookpublisher_label = new MyLabel("出版社", font, Color.black);
    MyLabel bookpublishdate_label = new MyLabel("出版日期", font, Color.black);
    MyLabel bookstock_label = new MyLabel("库存", font, Color.black);
    MyLabel bookprice_label = new MyLabel("价格", font, Color.black);
    MyLabel sortkey_label = new MyLabel("排序关键字", font, Color.black);
    MyLabel sortorder_label = new MyLabel("排序方式", font, Color.black);
    MyLabel range1_label = new MyLabel("～", font, Color.black);
    MyLabel range2_label = new MyLabel("～", font, Color.black);
    MyLabel range3_label = new MyLabel("～", font, Color.black);
    MyLabel countitem = new MyLabel("", font, Color.black);
    MyButton1 search_button = new MyButton1(80, 25, 5, Color.white, "查 询", 18,
            Color.BLACK);
    MyButton1 add_button = new MyButton1(100, 25, 5, Color.white, "新增图书", 18,
            Color.BLACK);
    MyButton1 delete_button = new MyButton1(100, 25, 5, Color.white, "删除图书", 18,
            Color.BLACK);
    MyButton1 alter_button = new MyButton1(100, 25, 5, Color.white, "修改图书", 18,
            Color.BLACK);
    MyText bookid_text = new MyText(new Dimension(180, 25), 20);
    MyText bookname_text = new MyText(new Dimension(180, 25), 255);
    MyText bookauthor_text = new MyText(new Dimension(180, 25), 255);
    MyText bookpublisher_text = new MyText(new Dimension(180, 25), 255);
    DatePicker bookpublishdate1 = new DatePicker(this, null);
    DatePicker bookpublishdate2 = new DatePicker(this, null);
    MyText bookstock1_text = new MyText(new Dimension(180, 25), 10);
    MyText bookstock2_text = new MyText(new Dimension(180, 25), 10);
    MyText bookprice1_text = new MyText(new Dimension(180, 25), 10);
    MyText bookprice2_text = new MyText(new Dimension(180, 25), 10);

    JComboBox<String> sortkey_combo = new JComboBox<String>();
    JComboBox<String> sortorder_combo = new JComboBox<String>();
    JSeparator separator1 = new JSeparator();
    JSeparator separator2 = new JSeparator();

    String[] table_keys = {"选择", "编号", "书名", "作者", "出版社", "出版日期", "价格", "库存"};
    BooksTable booksTable = new BooksTable(table_keys);
    Datas.Book book_filter = new Book();
    String sql;
    Thread updateThread;
    boolean isRunning = true;

    public BookManage_Panel() {
        Init();
    }

    void Init() {

        setBackground(new Color(240, 243, 249));
        setPreferredSize(new Dimension(700, 550));
        setOpaque(true);
        setLayout(new FreeLayout());
        separator1.setForeground(Color.RED);
        separator2.setForeground(new Color(0, 0, 0, 50));

        sortkey_combo.setFont(font);
        sortorder_combo.setFont(font);
        sortkey_combo.setBackground(Color.WHITE);
        sortorder_combo.setBackground(Color.WHITE);
        sortkey_combo.setPreferredSize(new Dimension(120, 25));
        sortorder_combo.setPreferredSize(new Dimension(120, 25));
        sortkey_combo.addItem("--请选择--");
        sortkey_combo.addItem("编号");
        sortkey_combo.addItem("书名");
        sortkey_combo.addItem("作者");
        sortkey_combo.addItem("出版社");
        sortkey_combo.addItem("出版日期");
        sortkey_combo.addItem("库存");
        sortkey_combo.addItem("价格");

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

        bookid_text.setFont(font);
        bookname_text.setFont(font);
        bookauthor_text.setFont(font);
        bookpublisher_text.setFont(font);
        bookprice1_text.setFont(font);
        bookprice2_text.setFont(font);
        bookstock1_text.setFont(font);
        bookstock2_text.setFont(font);

        bookpublishdate1.setPattern("yyyy-MM-dd");
        bookpublishdate1.setEditorable(false);
        bookpublishdate1.setPreferredSize(new Dimension(180, 25));
        bookpublishdate1.getField().setBackground(Color.WHITE);
        bookpublishdate1.getField().setFont(new Font("Arial, sans-serif;",
                Font.PLAIN, 18));
        bookpublishdate2.setPattern("yyyy-MM-dd");
        bookpublishdate2.setEditorable(false);
        bookpublishdate2.setPreferredSize(new Dimension(180, 25));
        bookpublishdate2.getField().setBackground(Color.WHITE);
        bookpublishdate2.getField().setFont(new Font("Arial, sans-serif;",
                Font.PLAIN, 18));

        search_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Str2NumCheck.isIntValue(bookid_text.getText().trim()) && bookid_text.getText().trim().length() != 0) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(BookManage_Panel.this),
                            "请输入正确的编号!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (Judgespchar.check(bookname_text.getText().trim()) && bookname_text.getText().trim().length() != 0) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(BookManage_Panel.this),
                            "书名包含特殊字符!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (Judgespchar.check(bookauthor_text.getText().trim()) && bookauthor_text.getText().trim().length() != 0) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(BookManage_Panel.this),
                            "作者包含特殊字符!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (Judgespchar.check(bookpublisher_text.getText().trim()) && bookpublisher_text.getText().trim().length() != 0) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(BookManage_Panel.this),
                            "出版社包含特殊字符!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (!((bookprice1_text.getText().trim().isEmpty() && bookprice2_text.getText().trim().isEmpty()) ||
                        (Str2NumCheck.isUnsignedDoubleValue(bookprice1_text.getText().trim()) && Str2NumCheck.isUnsignedDoubleValue(bookprice2_text.getText().trim())
                                && Double.parseDouble(bookprice1_text.getText().trim()) <= Double.parseDouble(bookprice2_text.getText().trim())))) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(BookManage_Panel.this),
                            "请输入正确的价格!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (!((bookstock1_text.getText().trim().isEmpty() && bookstock2_text.getText().trim().isEmpty()) ||
                        (Str2NumCheck.isIntValue(bookstock1_text.getText().trim()) && Str2NumCheck.isIntValue(bookstock2_text.getText().trim())
                                && Integer.parseInt(bookstock1_text.getText().trim()) <= Integer.parseInt(bookstock2_text.getText().trim())))) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(BookManage_Panel.this),
                            "请输入正确的库存!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (!((bookpublishdate1.getValue() == null && bookpublishdate2.getValue() == null) ||
                        (bookpublishdate1.getValue() != null && bookpublishdate2.getValue() != null &&
                                (((Date) bookpublishdate1.getValue()).before((Date) bookpublishdate2.getValue()) || bookpublishdate1.getValue().equals(bookpublishdate2.getValue()))))) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(BookManage_Panel.this),
                            "请输入正确的出版日期!", "提示", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (bookid_text.getText().trim().isEmpty()) {
                        book_filter.setId(null);
                    } else if (Str2NumCheck.isIntValue(bookid_text.getText().trim())) {
                        book_filter.setId(Integer.parseInt(bookid_text.getText().trim()));
                    }
                    if (bookname_text.getText().trim().isEmpty()) {
                        book_filter.setName(null);
                    } else {
                        book_filter.setName("%" + bookname_text.getText().trim() + "%");
                    }
                    if (bookauthor_text.getText().trim().isEmpty()) {
                        book_filter.setAuthor(null);
                    } else {
                        book_filter.setAuthor("%" + bookauthor_text.getText().trim() + "%");
                    }
                    if (bookpublisher_text.getText().trim().isEmpty()) {
                        book_filter.setPublisher(null);
                    } else {
                        book_filter.setPublisher("%" + bookpublisher_text.getText().trim() + "%");
                    }
                    String sql1 = "SELECT * FROM book WHERE " +
                            "(id = ? OR ? IS NULL) AND " +
                            "(name LIKE ? OR ? IS NULL) AND " +
                            "(author LIKE ? OR ? IS NULL) AND " +
                            "(publisher LIKE ? OR ? IS NULL) AND " +
                            "(publishdate = ? OR ? IS NULL) AND " +
                            "(stock = ? OR ? IS NULL) AND " +
                            "(price = ? OR ? IS NULL) ";
                    String sql2 = "AND (publishdate BETWEEN IFNULL(?,publishdate)" +
                            " AND IFNULL(?,publishdate) OR publishdate IS NULL) AND (stock BETWEEN " +
                            "IFNULL(?,stock) AND IFNULL(?,stock) OR stock IS NULL) AND (price " +
                            "BETWEEN IFNULL(?,price) AND IFNULL(?,price) OR price IS NULL)";
                    String sql3 = "";
                    if (sortkey_combo.getSelectedIndex() != 0) {
                        sql3 = "ORDER BY ";
                        switch (sortkey_combo.getSelectedIndex()) {
                            case 1 -> sql3 += "id";
                            case 2 -> sql3 += "name";
                            case 3 -> sql3 += "author";
                            case 4 -> sql3 += "publisher";
                            case 5 -> sql3 += "publishdate";
                            case 6 -> sql3 += "stock";
                            case 7 -> sql3 += "price";
                        }
                        if (Objects.equals(sortorder_combo.getSelectedItem(), "升序")) {
                            sql3 += " ASC";
                        } else if (Objects.equals(sortorder_combo.getSelectedItem(), "降序")) {
                            sql3 += " DESC";
                        }
                    }
                    try {
                        PreparedStatement stmt = Connect.conn.prepareStatement(sql2);
                        Date date1 = (Date) bookpublishdate1.getValue();
                        Date date2 = (Date) bookpublishdate2.getValue();
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
                        if (bookstock1_text.getText().trim().isEmpty()) {
                            stmt.setNull(index++, Types.INTEGER);
                        } else {
                            stmt.setInt(index++, Integer.parseInt(bookstock1_text.getText().trim()));
                        }
                        if (bookstock2_text.getText().trim().isEmpty()) {
                            stmt.setNull(index++, Types.INTEGER);
                        } else {
                            stmt.setInt(index++, Integer.parseInt(bookstock2_text.getText().trim()));
                        }
                        if (bookprice1_text.getText().trim().isEmpty()) {
                            stmt.setNull(index++, Types.DOUBLE);
                        } else {
                            stmt.setDouble(index++, Double.parseDouble(bookprice1_text.getText().trim()));
                        }
                        if (bookprice2_text.getText().trim().isEmpty()) {
                            stmt.setNull(index, Types.DOUBLE);
                        } else {
                            stmt.setDouble(index, Double.parseDouble(bookprice2_text.getText().trim()));
                        }
                        sql2 = stmt.toString().substring(stmt.toString().indexOf(":") + 1);
                        sql = sql1 + sql2 + sql3;
                        Table_update();
                    } catch (SQLException ex) {
                        SqlError.quit(BookManage_Panel.this, "数据库错误!" + ex.getMessage());
                    }
                }
            }
        });

        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookAdd_Dialog(SwingUtilities.getWindowAncestor(BookManage_Panel.this));
                try {
                    Table_update();
                } catch (SQLException ex) {
                    SqlError.quit(BookManage_Panel.this,
                            "表格信息更新失败!" + ex.getMessage());
                }
            }
        });
        delete_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (booksTable.getSelectedRows().size() == 0) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(BookManage_Panel.this),
                            "请选择要删除的图书!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (JOptionPane.showConfirmDialog(SwingUtilities.getWindowAncestor(BookManage_Panel.this),
                            "确定要删除选中的" + booksTable.getSelectedRows().size() + "本图书吗?", "提示",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        int count = 0;
                        for (String str : booksTable.getSelectedRows()) {
                            int index = Integer.parseInt(str);
                            Book book_filter = new Book();
                            book_filter.setId((Integer) booksTable.model.getRowData().get(index).get(1));
                            try {
                                Book.deleteBook(book_filter);
                                count++;
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(BookManage_Panel.this),
                                        "删除" + booksTable.model.getRowData().get(index).get(2) + "失败!" + ex.getMessage(),
                                        "提示",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(BookManage_Panel.this),
                                "共删除" + count + "/" + booksTable.getSelectedRows().size() + "项!", "提示",
                                JOptionPane.INFORMATION_MESSAGE);
                }
                try {
                    Table_update();
                } catch (SQLException ex) {
                    SqlError.quit(BookManage_Panel.this,
                            "表格信息更新失败!" + ex.getMessage());
                }
            }
        });
        alter_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (booksTable.getSelectedRows().size() == 0) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(BookManage_Panel.this),
                            "请选择要修改的图书!", "提示", JOptionPane.WARNING_MESSAGE);
                } else {
                    for (String str : booksTable.getSelectedRows()) {
                        int index = Integer.parseInt(str);
                        new BookUpdate_Dialog(SwingUtilities.getWindowAncestor(BookManage_Panel.this),
                                booksTable.model.getRowData().get(index));
                    }
                    try {
                        Table_update();
                    } catch (SQLException ex) {
                        SqlError.quit(BookManage_Panel.this,
                                "表格信息更新失败!" + ex.getMessage());
                    }
                }
            }
        });


        add(panel_label, new Margin(10, 10, -1, -1));
        add(separator1, new Margin(50, 0, -1, 0));
        add(help_label, new Margin(60, 10, -1, 0));
        add(bookid_label, new Margin(100, 10, -1, -1));
        add(bookname_label, new Margin(140, 10, -1, -1));
        add(bookauthor_label, new Margin(180, 10, -1, -1));
        add(bookpublisher_label, new Margin(220, 10, -1, -1));
        add(bookpublishdate_label, new Margin(100, 340, -1, -1));
        add(bookstock_label, new Margin(140, 340, -1, -1));
        add(bookprice_label, new Margin(180, 340, -1, -1));
        add(sortkey_label, new Margin(220, 340, -1, -1));
        add(sortorder_label, new Margin(220, 600, -1, -1));
        add(range1_label, new Margin(100, 615, -1, -1));
        add(range2_label, new Margin(140, 615, -1, -1));
        add(range3_label, new Margin(180, 615, -1, -1));
        int left1 = (int) (bookpublisher_label.getPreferredSize().getWidth() + 20);
        int left2 = (int) (bookpublishdate_label.getPreferredSize().getWidth() + 355);
        int left3 = (int) (range1_label.getPreferredSize().getWidth() + 605);
        add(bookid_text, new Margin(100, left1, -1, -1));
        add(bookname_text, new Margin(140, left1, -1, -1));
        add(bookauthor_text, new Margin(180, left1, -1, -1));
        add(bookpublisher_text, new Margin(220, left1, -1, -1));
        add(bookpublishdate1, new Margin(100, left2, -1, -1));
        add(bookpublishdate2, new Margin(100, -1, -1, 5));
        add(bookstock1_text, new Margin(140, left2, -1, -1));
        add(bookstock2_text, new Margin(140, -1, -1, 5));
        add(bookprice1_text, new Margin(180, left2, -1, -1));
        add(bookprice2_text, new Margin(180, -1, -1, 5));
        add(sortkey_combo, new Margin(220, left2 + 20, -1, -1));
        add(sortorder_combo, new Margin(220, left3 + 70, -1, -1));
        add(search_button, new Margin(253, -1, -1, 5));
        add(add_button, new Margin(253, 5, -1, -1));
        add(delete_button, new Margin(253, 110, -1, -1));
        add(alter_button, new Margin(253, 215, -1, -1));
        add(separator2, new Margin(250, 0, -1, 0));
        add(booksTable, new Margin(280, 5, 32, 5));
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
                        ThreadInfo.printThreadInfo("BookManage_Panel");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void Table_update() throws SQLException {
        booksTable.setData(Datas.Book.getBook_View(book_filter, sql));
        countitem.setText("共 " + booksTable.table.getRowCount() + " 项");
    }

    public void ThreadClose() {
        isRunning = false;
    }

    public boolean getThreadState() {
        return isRunning;
    }
}
