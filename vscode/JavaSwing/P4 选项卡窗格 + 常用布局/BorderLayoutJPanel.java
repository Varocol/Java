import javax.swing.*;
import java.awt.*;


public class BorderLayoutJPanel extends JPanel {
    public BorderLayoutJPanel() {
        JButton bSouth, bNorth, bEast, bWest;
        JTextArea bCenter;
        setLayout(new BorderLayout());
        bSouth = new JButton("��");
        bNorth = new JButton("��");
        bEast  = new JButton("��");
        bWest  = new JButton("��");
        bCenter= new JTextArea("����");
        add(bSouth,BorderLayout.SOUTH);
        add(bNorth,BorderLayout.NORTH);
        add(bEast,BorderLayout.EAST);
        add(bWest,BorderLayout.WEST);
        add(bCenter,BorderLayout.CENTER);
        validate();
    }
}
