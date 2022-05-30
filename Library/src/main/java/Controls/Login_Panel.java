package Controls;

import af.swing.layout.FreeLayout;
import af.swing.layout.Margin;

import javax.swing.*;


public class Login_Panel extends JPanel {


    Login_LittlePanel1 littlePanel1 = new Login_LittlePanel1();
    Login_LittlePanel2 littlePanel2 = new Login_LittlePanel2();
    DropShadow_Panel dropShadowPanel1 = new DropShadow_Panel(5);
    DropShadow_Panel dropShadowPanel2 = new DropShadow_Panel(5);

    public Login_Panel() {
        Init();
    }

    void Init() {
        setSize(600, 700);
        dropShadowPanel1.add(littlePanel1);
        dropShadowPanel2.add(littlePanel2);

        setLayout(new FreeLayout());

        add(dropShadowPanel1, new Margin(150,
                (int) ((getWidth() - littlePanel1.getPreferredSize().getWidth()) / 2),
                -1, -1));
        add(dropShadowPanel2, new Margin(50,
                (int) ((getWidth() - littlePanel1.getPreferredSize().getWidth()) / 2),
                -1,-1));
    }
}
