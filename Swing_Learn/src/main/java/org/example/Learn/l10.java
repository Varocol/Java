package org.example.Learn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class l10 {
    public static void main(String[] args) {
        l10_Myframe myframe1 = new l10_Myframe("mf1");
    }
}

class l10_Myframe extends JFrame {

    JButton button1 = new JButton("b1");
    JPanel panel1 = new JPanel();
    JTextField textField1 = new JTextField(20);
    JCheckBox checkBox1 = new JCheckBox("cb1");
    JComboBox<String> comboBox1 = new JComboBox<String>();
    JLabel label1 = new JLabel("lb1");

    public l10_Myframe() {
        Init();
    }

    public l10_Myframe(String title) {
        super(title);
        Init();
    }

    void Init() {
        panel1.add(textField1);
        panel1.add(button1);
        panel1.add(checkBox1);
        panel1.add(comboBox1);
        panel1.add(label1);

        button1.setEnabled(false);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField1.getText());
                int i = comboBox1.getSelectedIndex();
                String str = comboBox1.getItemAt(comboBox1.getSelectedIndex());
                System.out.println(i + ":" + str);
            }
        });
        checkBox1.setSelected(false);
        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setEnabled(checkBox1.isSelected());
                System.out.println(checkBox1.isSelected());
            }
        });

        comboBox1.addItem("红色");
        comboBox1.addItem("蓝色");
        comboBox1.addItem("绿色");

        //BOLD 文字加粗
        //ITALIC 文字倾斜
        //PLAIN 文字普通
        //BOLD + ITALIC 文字加粗倾斜
        //BOLD + ITALIC + PLAIN 文字加粗倾斜普通
        label1.setFont(new Font("宋体", Font.BOLD, 20));
        //设置标签颜色为蓝色
        //白色 255，255，255
        //黑色 0，0，0
        //红色 255，0，0
        //绿色 0，255，0
        //蓝色 0，0，255
        label1.setForeground(Color.BLUE);
        //设置标签背景颜色为红色
        label1.setOpaque(true);
        label1.setBackground(Color.RED);
        //设置标签大小
        label1.setPreferredSize(new Dimension(100, 100));
        //设置文字中心对齐
        label1.setHorizontalAlignment(JLabel.CENTER);


        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(800, 400);
        this.setSize(300, 400);
        this.setVisible(true);
    }
}