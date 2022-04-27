package test.sinline;

import javax.swing.*;
import java.awt.*;

public class Mylabel extends JLabel {
    public Mylabel() {
        super();
    }
    public Mylabel(String text) {
        super(text);
        setFont(new Font("Serif", Font.BOLD, 17));
        setForeground(Color.BLUE);
    }
}
