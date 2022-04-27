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
        // 窗口初始化
        {
            setTitle(s);
            setBounds(x1, y1, width, height);
            setLayout(new FlowLayout());
        }
        // 添加组件
        {
            add(new JLabel("文本框:"));
            text = new JTextField(10);
            add(text);

            add(new JLabel("按钮:"));
            button = new JButton("确定");
            add(button);

            add(new JLabel("选择框:"));
            checkBox1 = new JCheckBox("喜欢音乐");
            checkBox1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            checkBox2 = new JCheckBox("喜欢旅游");
            checkBox2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            checkBox3 = new JCheckBox("喜欢篮球");
            checkBox3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            add(checkBox1);
            add(checkBox2);
            add(checkBox3);

            add(new JLabel("单选按钮:"));
            radio1 = new JRadioButton("男");
            radio2 = new JRadioButton("女");
            group = new ButtonGroup();
            group.add(radio1);
            group.add(radio2);
            add(radio1);
            add(radio2);

            add(new JLabel("下拉列表:"));
            comboBox = new JComboBox<String>();
            comboBox.addItem("音乐天地");
            comboBox.addItem("武术天地");
            comboBox.addItem("象棋乐园");
            add(comboBox);

            add(new JLabel("文本区:"));
            area = new JTextArea(12, 24);
            add(new JScrollPane(area));
        }
        // 添加监视器
        {
            button.addActionListener(e -> {
                String str;
                str = "文本框:" + text.getText() + "\n";
                str += "选择框:";
                if (checkBox1.isSelected()) {
                    str += checkBox1.getText() + " ";
                }
                if (checkBox2.isSelected()) {
                    str += checkBox2.getText() + " ";
                }
                if (checkBox3.isSelected()) {
                    str += checkBox3.getText() + " ";
                }
                str += "\n";
                str += "单选框:";
                if (radio1.isSelected()) {
                    str += radio1.getText() + "\n";
                } else {
                    str += radio2.getText() + "\n";
                }
                str += "下拉列表:"+comboBox.getItemAt(comboBox.getSelectedIndex());
                area.setText(str);   
            });
        }
    }
}
