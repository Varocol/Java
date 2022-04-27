import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FlowLayoutJPanel extends JPanel {
    public FlowLayoutJPanel() {
        add(new JLabel("FlowLayout 布局的面板"));
        add(new JButton("确定"));
        add(new JScrollPane(new JTextArea(12, 15)));
    }
}
