import javax.swing.*;
import java.awt.*;


public class BorderLayoutJPanel extends JPanel {
    public BorderLayoutJPanel() {
        JButton bSouth, bNorth, bEast, bWest;
        JTextArea bCenter;
        setLayout(new BorderLayout());
        bSouth = new JButton("南");
        bNorth = new JButton("北");
        bEast  = new JButton("东");
        bWest  = new JButton("西");
        bCenter= new JTextArea("中心");
        add(bSouth,BorderLayout.SOUTH);
        add(bNorth,BorderLayout.NORTH);
        add(bEast,BorderLayout.EAST);
        add(bWest,BorderLayout.WEST);
        add(bCenter,BorderLayout.CENTER);
        validate();
    }
}
