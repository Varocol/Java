import java.awt.*;
import javax.swing.*;

public class ComponentInWindow extends JFrame {
    JTextField text;
    JButton button;
    JCheckBox checkBox1, checkBox2, checkBox3;
    JRadioButton radio1, radio2;
    ButtonGroup group;
    JComboBox<String> comboBox;
    JTextArea area;

    public ComponentInWindow() {

    }

    public ComponentInWindow(String s, int x, int y, int width, int height) {
        init(s, x, y, width, height);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void init(String s, int x1, int y1, int width, int height) {
        setTitle(s);
        setBounds(x1, y1, width, height);
        setLayout(new FlowLayout());

        add(new JLabel("�ı���:"));
        text = new JTextField(10);
        add(text);

        add(new JLabel("��ť:"));
        button = new JButton("ȷ��");
        add(button);

        add(new JLabel("ѡ���:"));
        checkBox1 = new JCheckBox("ϲ������");
        checkBox1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        checkBox2 = new JCheckBox("ϲ������");
        checkBox2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        checkBox3 = new JCheckBox("ϲ������");
        checkBox3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        add(checkBox1);
        add(checkBox2);
        add(checkBox3);

        add(new JLabel("��ѡ��ť:"));
        radio1 = new JRadioButton("��");
        radio2 = new JRadioButton("Ů");
        group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        add(radio1);
        add(radio2);

        add(new JLabel("�����б�:"));
        comboBox = new JComboBox<String>();
        comboBox.addItem("�������");
        comboBox.addItem("�������");
        comboBox.addItem("������԰");
        add(comboBox);

        add(new JLabel("�ı���:"));
        area = new JTextArea(6, 12);
        add(new JScrollPane(area));
    }
}
