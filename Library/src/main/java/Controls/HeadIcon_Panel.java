package Controls;

import Datas.User;
import Tools.Resources;
import Tools.SqlError;
import Tools.ThreadInfo;
import af.swing.layout.FreeLayout;
import af.swing.layout.Margin;

import javax.swing.*;
import java.awt.*;

public class HeadIcon_Panel extends JPanel {
    MyLabel username = new MyLabel("", new Font("Arial, " +
            "sans-serif;",
            Font.PLAIN, 26), Color.black);
    MyLabel identity = new MyLabel("", new Font("Arial, sans-serif;",
            Font.BOLD, 22), Color.white);
    MyHeadIcon headIcon = new MyHeadIcon(Resources.DEFAULTHEADICON, 40);

    private Thread updateThread;
    private Boolean isRunning = true;

    public HeadIcon_Panel() {
        Init();
    }

    void Init() {
        ThreadCreate();
        ThreadStart();

        setBackground(new Color(240, 243, 249));
        setOpaque(true);
        setLayout(new FreeLayout());
        //这里一定要用PreferredSize，不然不会自动调整大小
        setPreferredSize(new Dimension(230, 110));
    }

    private void UpdatedynamicUI() {
        if (User.CurrentUser != null) {
            username.setText(User.CurrentUser.getName());
            switch (User.CurrentUser.getState()) {
                case User.UNACTIVATED -> {
                    SqlError.quit(HeadIcon_Panel.this, "请先激活账号!");
                }
                case User.COMMONUSER -> identity.setForeground(Color.GREEN);
                case User.ADMINISTRATOR -> identity.setForeground(Color.RED);
            }
            identity.setText(User.CurrentUser.getState());
            headIcon.setImage(User.CurrentUser.getHeadicon());
            removeAll();
            add(headIcon,
                    new Margin((int) ((getPreferredSize().getHeight() - headIcon.getPreferredSize().getHeight()) / 2), 10, -1, -1));
            int x = (int) (10 + headIcon.getPreferredSize().getWidth());
            add(username,
                    new Margin(
                            (int) (getPreferredSize().getHeight() / 5),
                            (int) ((getPreferredSize().getWidth() - x - username.getPreferredSize().getWidth()) / 2 + x) - 10,
                            -1,
                            -1));
            add(identity,
                    new Margin(
                            -1,
                            (int) ((getPreferredSize().getWidth() - x - identity.getPreferredSize().getWidth()) / 2 + x) - 10,
                            (int) (getPreferredSize().getHeight() / 5),
                            -1));
            this.repaint();
            this.revalidate();
        } else {
            SqlError.quit(HeadIcon_Panel.this, "请先登录!");
        }
    }

    public void ThreadClose() {
        isRunning = false;
    }

    public void ThreadCreate() {
        isRunning = true;
        updateThread = new Thread(() -> {
            while (isRunning) {
                UpdatedynamicUI();
                try {
                    ThreadInfo.printThreadInfo("HeadIcon_Panel");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void ThreadStart() {
        updateThread.start();
        isRunning = true;
    }

    public boolean getThreadState() {
        return isRunning;
    }
}
