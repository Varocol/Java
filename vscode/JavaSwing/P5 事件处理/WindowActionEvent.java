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
        // ���ڳ�ʼ��
        {
            setTitle(s);
            setBounds(x, y, width, height);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        // ���ò���
        {
            setLayout(new FlowLayout());
        }
        // ������
        {
            textField = new JTextField(10);
            textArea = new JTextArea(5, 18);
            button = new JButton("ȷ��");

            add(textField);
            add(button);
            add(new JScrollPane(textArea));
        }
        // ��Ӽ�����
        {
            textField.addActionListener(e->{
                    textArea.setText(
                        textArea.getText()+
                        textField.getText()+
                        "�ĳ���:"+
                        textField.getText().length()+
                        "\n"
                        );
                });
            button.addActionListener(e->{
                textArea.setText(
                    textArea.getText()+
                    textField.getText()+
                    "�ĳ���:"+
                    textField.getText().length()+
                    "\n"
                    );
            });
        }
    }
}
