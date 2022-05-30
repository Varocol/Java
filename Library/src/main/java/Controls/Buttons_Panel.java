package Controls;

import Datas.User;
import Tools.Resources;
import Tools.SqlError;
import af.swing.layout.FreeLayout;
import af.swing.layout.Margin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons_Panel extends JPanel {
    MyButton2 personaldata = new MyButton2(200, 50, 5,
            new Color(94, 114, 228), "个人信息", 22, Resources.PERSONAL1,
            Resources.PERSONAL2);
    MyButton2 booksearch = new MyButton2(200, 50, 5,
            new Color(94, 114, 228), "图书借阅", 22, Resources.SEARCH1,
            Resources.SEARCH2);
    MyButton2 operationrecord = new MyButton2(200, 50, 5,
            new Color(94, 114, 228), "借阅记录", 22, Resources.OPERATION1,
            Resources.OPERATION2);
    MyButton2 changepassword = new MyButton2(200, 50, 5,
            new Color(94, 114, 228), "修改密码", 22, Resources.CHANGEPASSWORD1,
            Resources.CHANGEPASSWORD2);
    MyButton2 bookmanage = new MyButton2(200, 50, 5,
            new Color(94, 114, 228), "图书管理", 22, Resources.BOOKMANAGER1,
            Resources.BOOKMANAGER2);
    MyButton2 usermanage = new MyButton2(200, 50, 5,
            new Color(94, 114, 228), "用户管理", 22, Resources.USERMANAGER1,
            Resources.USERMANAGER2);
    MyButton2 operationmanage = new MyButton2(200, 50, 5,
            new Color(94, 114, 228), "借阅管理", 22, Resources.BORROWMANAGER1,
            Resources.BORROWMANAGER2);
    DropShadow_Panel dropShadowPanel1 = new DropShadow_Panel(5);
    DropShadow_Panel dropShadowPanel2 = new DropShadow_Panel(5);
    DropShadow_Panel dropShadowPanel3 = new DropShadow_Panel(5);
    DropShadow_Panel dropShadowPanel4 = new DropShadow_Panel(5);
    DropShadow_Panel dropShadowPanel5 = new DropShadow_Panel(5);
    DropShadow_Panel dropShadowPanel6 = new DropShadow_Panel(5);
    DropShadow_Panel dropShadowPanel7 = new DropShadow_Panel(5);
    Thread updateThread;
    boolean isRunning = true;

    public Buttons_Panel() {
        Init();
    }

    void Init() {

        ThreadCreate();
        ThreadStart();

        setBackground(new Color(240, 243, 249));
        setPreferredSize(new Dimension(230, 500));
        setOpaque(true);
        setLayout(new FreeLayout());

        personaldata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User_Panel.select = User_Panel.SELFINFO_SELECT;
            }
        });
        booksearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User_Panel.select = User_Panel.SEARCH_SELECT;
            }
        });
        operationrecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User_Panel.select = User_Panel.OPERATIONS_SELECT;
            }
        });
        changepassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User_Panel.select = User_Panel.SETTINGS_SELECT;
            }
        });
        bookmanage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User_Panel.select = User_Panel.BOOKMANAGE_SELECT;
            }
        });
        usermanage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User_Panel.select = User_Panel.USERMANAGE_SELECT;
            }
        });
        operationmanage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User_Panel.select = User_Panel.BORROWMANAGE_SELECT;
            }
        });

        dropShadowPanel1.add(personaldata);
        dropShadowPanel2.add(booksearch);
        dropShadowPanel3.add(operationrecord);
        dropShadowPanel4.add(changepassword);
        dropShadowPanel5.add(bookmanage);
        dropShadowPanel6.add(usermanage);
        dropShadowPanel7.add(operationmanage);


    }

    public void UpdatedynamicUI() {
        removeAll();
        int width = (int) getPreferredSize().getWidth();
        int height = (int) getPreferredSize().getHeight() - 150;
        int controlwidth = (int) dropShadowPanel1.getPreferredSize().getWidth();
        int controlheight = (int) dropShadowPanel1.getPreferredSize().getHeight();
        if (User.CurrentUser != null) {
            if (User.CurrentUser.getState().equals(User.COMMONUSER)) {
                add(dropShadowPanel1,
                        new Margin(((height - 4 * controlheight) / 5 + controlheight) - controlheight,
                                (width - controlwidth) / 2, -1, -1));
                add(dropShadowPanel2,
                        new Margin(((height - 4 * controlheight) / 5 + controlheight) * 2 - controlheight,
                                (width - controlwidth) / 2, -1, -1));
                add(dropShadowPanel3,
                        new Margin(((height - 4 * controlheight) / 5 + controlheight) * 3 - controlheight,
                                (width - controlwidth) / 2, -1, -1));
                add(dropShadowPanel4,
                        new Margin(((height - 4 * controlheight) / 5 + controlheight) * 4 - controlheight,
                                (width - controlwidth) / 2, -1, -1));
            } else if (User.CurrentUser.getState().equals(User.ADMINISTRATOR)) {
                add(dropShadowPanel1,
                        new Margin(((height - 4 * controlheight) / 5 + controlheight) - controlheight,
                                (width - controlwidth) / 2, -1, -1));
                add(dropShadowPanel5,
                        new Margin(((height - 4 * controlheight) / 5 + controlheight) * 2 - controlheight,
                                (width - controlwidth) / 2, -1, -1));
                add(dropShadowPanel6,
                        new Margin(((height - 4 * controlheight) / 5 + controlheight) * 3 - controlheight,
                                (width - controlwidth) / 2, -1, -1));
                add(dropShadowPanel7,
                        new Margin(((height - 4 * controlheight) / 5 + controlheight) * 4 - controlheight,
                                (width - controlwidth) / 2, -1, -1));
                add(dropShadowPanel4,
                        new Margin(((height - 4 * controlheight) / 5 + controlheight) * 5 - controlheight,
                                (width - controlwidth) / 2, -1, -1));
            }
        }else {
            SqlError.quit(Buttons_Panel.this, "请先登录!");
        }
        revalidate();
        repaint();
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
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void TreadClose() {
        isRunning = false;
    }

    public boolean getTreadState() {
        return isRunning;
    }
}
