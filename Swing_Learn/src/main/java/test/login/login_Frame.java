package test.login;

import af.swing.layout.FreeLayout;
import af.swing.layout.HLayout;
import af.swing.layout.Margin;
import af.swing.layout.VLayout;
import org.example.Learn.LayoutBox;

import javax.swing.*;
import java.awt.*;

public class login_Frame extends JFrame {
    LayoutBox panel =new LayoutBox();
    JTextField userName = new JTextField(20);
    JPasswordField password = new JPasswordField(20);
    JButton login = new JButton("Login");
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public login_Frame() {
        setTitle("Login");
        Init();
    }
    void Init() {

        setContentPane(panel);
        panel.padding(10);
        panel.layout(new VLayout(10));

        LayoutBox box1 = createFormLine("用户名", userName);
        panel.add(box1);
        box1 = createFormLine("密码", password);
        panel.add(box1);
        box1 = new LayoutBox().preferredHeight(60).layout(new FreeLayout());
        box1.add(login,new Margin(10,50,-1,-1));
        panel.add(box1);



        setSize(300, 200);
        setLocation(screenSize.width/2-getWidth()/2, screenSize.height/2-getHeight()/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private LayoutBox createFormLine(String label, JComponent component) {
        LayoutBox box = new LayoutBox();
        box.layout(new HLayout(10));
        box.preferredHeight(30);
        box.add(new JLabel(label),"50px");
        box.add(component,"1w");
        return box;
    }
}
