package Controls;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {

    public MyLabel() {
        super();
    }

    public MyLabel(String text, Font font, Color foregroundColor) {
        this(text, font, foregroundColor, SwingConstants.LEFT,
                SwingConstants.CENTER);
    }

    public MyLabel(String text, Font font, Color foregroundColor, int horizontalAlignment, int verticalAlignment) {
        super(text);
        setHorizontalAlignment(horizontalAlignment);
        setVerticalAlignment(verticalAlignment);
        setFont(font);
        setForeground(foregroundColor);
        setOpaque(false);
    }
}
