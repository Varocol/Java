package test.sinline;

import javax.swing.*;
import java.awt.*;

public class Mytextfield extends JTextField {
    public Mytextfield() {
        super();
    }
    public Mytextfield(String text) {
        super(text);
        setColumns(10);
        setFont(new Font("Consolas", Font.BOLD, 20));
        setForeground(Color.red);
        setPreferredSize(new Dimension(100, 30));
        setOpaque(false);
    }
}
