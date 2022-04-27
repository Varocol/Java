import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowActionEvent extends JFrame {
    public WindowActionEvent() {

    }

    public WindowActionEvent(String s, int x, int y, int width, int height) {
        init(s, x, y, width, height);
        setVisible(true);
    }

    void init(String s, int x, int y, int width, int height) {
        JTextField textField;
        JTextArea textArea;
        JButton button;
        // 窗口初始化
        {
            setTitle(s);
            setBounds(x, y, width, height);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        // 设置布局
        {
            setLayout(new FlowLayout());
        }
        // 添加组件
        {
            textField = new JTextField(10);
            textArea = new JTextArea(5, 18);
            button = new JButton("确定");

            add(textField);
            add(button);
            add(new JScrollPane(textArea));
        }
        // 添加监视器
        {
            textField.addActionListener(e->{
                    textArea.setText(
                        textArea.getText()+
                        textField.getText()+
                        "的长度:"+
                        textField.getText().length()+
                        "\n"
                        );
                });
            button.addActionListener(e->{
                textArea.setText(
                    textArea.getText()+
                    textField.getText()+
                    "的长度:"+
                    textField.getText().length()+
                    "\n"
                    );
            });
        }
    }
}
