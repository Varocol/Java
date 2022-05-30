package org.example.Learn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mydialog extends JDialog {
    JTextField textField = new JTextField(10);
    JButton button1 = new JButton("确定");
    JButton button2 = new JButton("取消");

    boolean isOk = false;

    public mydialog(Window owner) {
        super(owner);
        JPanel panel = new JPanel();
        this.setContentPane(panel);
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Hello World");

        JPanel panel1 = new JPanel();
        panel1.add(label);
        panel1.add(textField);

        JPanel panel2 = new JPanel();
        panel2.add(button1);
        panel2.add(button2);
        panel.add(panel2, BorderLayout.SOUTH);
        panel.add(panel1, BorderLayout.CENTER);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //关闭对话框
                isOk = true;
                setVisible(false);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isOk = false;
                setVisible(false);
            }
        });
    }

    public String get_text() {
        return textField.getText();
    }

    public boolean exec() {
        Window window = getOwner();
        setTitle("提示信息");
        setModal(true);
        setSize(300, 200);
        setLocation(window.getX() + (window.getWidth() - getWidth()) / 2,
                window.getY() + (window.getHeight() - getHeight()) / 2);
        // 1.显示对话框，并处于阻塞状态
        setVisible(true);
        return isOk;
    }
}
