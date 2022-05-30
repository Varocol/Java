package Controls;

import Tools.ThreadInfo;
import af.swing.layout.FreeLayout;
import af.swing.layout.Margin;

import javax.swing.*;
import java.awt.*;

public class User_Panel extends JPanel {
    public static final int SELFINFO_SELECT = 0;
    public static final int SEARCH_SELECT = 1;
    public static final int OPERATIONS_SELECT = 2;
    public static final int SETTINGS_SELECT = 3;
    public static final int BOOKMANAGE_SELECT = 4;
    public static final int USERMANAGE_SELECT = 5;
    public static final int BORROWMANAGE_SELECT = 6;
    public static int select = SELFINFO_SELECT;
    Boolean isRunning = true;
    HeadIcon_Panel headIconpanel = new HeadIcon_Panel();
    SelfInfo_Panel selfInfoPanel = new SelfInfo_Panel();
    BookSearch_Panel searchPanel = new BookSearch_Panel();
    Operation_Panel operationsPanel = new Operation_Panel();
    Settings_Panel settingsPanel = new Settings_Panel(this);
    BookManage_Panel bookManagePanel = new BookManage_Panel();
    UserManage_Panel userManagePanel = new UserManage_Panel();
    BorrowManage_Panel borrowManagePanel = new BorrowManage_Panel();
    Buttons_Panel buttonsPanel = new Buttons_Panel();
    DropShadow_Panel dropShadowPanel1 = new DropShadow_Panel(8);
    DropShadow_Panel dropShadowPanel2 = new DropShadow_Panel(8);
    DropShadow_Panel dropShadowPanel3 = new DropShadow_Panel(8);
    Thread updateThread;
    private int select_old = -1;

    public User_Panel() {
        Init();
    }

    public void Init() {

        ThreadCreate();
        ThreadStart();

        setBackground(Color.WHITE);
        dropShadowPanel1.add(headIconpanel);
        dropShadowPanel2.add(buttonsPanel);
        setSize(1100, 800);
        setLayout(new FreeLayout());
        add(dropShadowPanel1, new Margin(1, 1, -1, -1));
        add(dropShadowPanel2, new Margin(127, 1, 1, -1));
        add(dropShadowPanel3, new Margin(1, 245, 1, 1));

    }

    private void UpdatedynamicUI() {
        if (select != select_old) {
            dropShadowPanel3.removeAll();
            switch (select) {
                case SELFINFO_SELECT -> {
                    dropShadowPanel3.add(selfInfoPanel);
                    //线程优化
                    CloseAllThread();
                    selfInfoPanel.ThreadCreate();
                    selfInfoPanel.ThreadStart();
                    System.out.println("个人信息面板");
                }
                case SEARCH_SELECT -> {
                    dropShadowPanel3.add(searchPanel);
                    //默认刷新
                    searchPanel.search_button.doClick();
                    //线程优化
                    CloseAllThread();
                    searchPanel.ThreadCreate();
                    searchPanel.ThreadStart();
                    System.out.println("图书查询面板");
                }
                case OPERATIONS_SELECT -> {
                    dropShadowPanel3.add(operationsPanel);
                    //默认刷新
                    operationsPanel.search_button.doClick();
                    //线程优化
                    CloseAllThread();
                    operationsPanel.ThreadCreate();
                    operationsPanel.ThreadStart();
                    System.out.println("借阅记录面板");
                }
                case SETTINGS_SELECT -> {
                    dropShadowPanel3.add(settingsPanel);
                    //线程优化
                    CloseAllThread();
                    settingsPanel.ThreadCreate();
                    settingsPanel.ThreadStart();
                    System.out.println("修改密码面板");
                }
                case BOOKMANAGE_SELECT -> {
                    dropShadowPanel3.add(bookManagePanel);
                    //默认刷新
                    bookManagePanel.search_button.doClick();
                    //线程优化
                    CloseAllThread();
                    bookManagePanel.ThreadCreate();
                    bookManagePanel.ThreadStart();
                    System.out.println("图书管理面板");
                }
                case USERMANAGE_SELECT -> {
                    dropShadowPanel3.add(userManagePanel);
                    //默认刷新
                    userManagePanel.search_button.doClick();
                    //线程优化
                    CloseAllThread();
                    userManagePanel.ThreadCreate();
                    userManagePanel.ThreadStart();
                    System.out.println("用户管理面板");
                }
                case BORROWMANAGE_SELECT -> {
                    dropShadowPanel3.add(borrowManagePanel);
                    //默认刷新
                    borrowManagePanel.search_button.doClick();
                    //线程优化
                    CloseAllThread();
                    borrowManagePanel.ThreadCreate();
                    borrowManagePanel.ThreadStart();
                    System.out.println("借阅管理面板");
                }

            }
            select_old = select;
            dropShadowPanel3.revalidate();
            dropShadowPanel3.repaint();
        }
    }

    public void CloseAllThread() {
        selfInfoPanel.ThreadClose();
        searchPanel.ThreadClose();
        operationsPanel.ThreadClose();
        settingsPanel.ThreadClose();
        bookManagePanel.ThreadClose();
        userManagePanel.ThreadClose();
        borrowManagePanel.ThreadClose();
    }

    public void ThreadClose() {
        isRunning = false;
    }

    public void ThreadCreate() {
        updateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning) {
                    UpdatedynamicUI();
                    try {
                        Thread.sleep(100);
                        ThreadInfo.printThreadInfo("User_Panel");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
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
