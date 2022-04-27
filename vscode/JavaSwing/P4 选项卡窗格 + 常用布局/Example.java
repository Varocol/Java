import javax.swing.*;
import java.awt.*;

public class Example extends JFrame {
    public Example() {
        JTabbedPane p = new JTabbedPane(JTabbedPane.LEFT);
        BorderLayout border = new BorderLayout();
        setBounds(100, 100, 500, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p.add("�ۿ� FlowLayout", new FlowLayoutJPanel());
        p.add("�ۿ� GridLayout", new GridLayoutJPanel());
        p.add("�ۿ� BorderLayout", new BorderLayoutJPanel());
        p.validate();
        setLayout(border);
        add(p, BorderLayout.CENTER);
        validate();
    }

    public static void main(String[] args) {
        new Example();
    }
}