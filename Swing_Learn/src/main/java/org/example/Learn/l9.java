package org.example.Learn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class l9 {
    public static void main(String[] args) {
        l9_Myframe myframe1 = new l9_Myframe("mf1");
    }
}

class l9_Myframe extends JFrame {

    JButton button1 = new JButton("b1");
    JPanel panel1 = new JPanel();
    JTextField textField1 = new JTextField(20);
    JCheckBox checkBox1 = new JCheckBox("cb1");
    JComboBox<String> comboBox1 = new JComboBox<String>();

    public l9_Myframe() {
        Init();
    }

    public l9_Myframe(String title) {
        super(title);
        Init();
    }

    void Init() {
        panel1.add(textField1);
        panel1.add(button1);
        panel1.add(checkBox1);
        panel1.add(comboBox1);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField1.getText());
                int i = comboBox1.getSelectedIndex();
                String str = comboBox1.getItemAt(comboBox1.getSelectedIndex());
                System.out.println(i + ":" + str);
            }
        });
        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(checkBox1.isSelected());
            }
        });

        comboBox1.addItem("红色");
        comboBox1.addItem("蓝色");
        comboBox1.addItem("绿色");

        checkBox1.setSelected(false);
        button1.setEnabled(false);
        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setEnabled(checkBox1.isSelected());
            }
        });


        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(800, 400);
        this.setSize(300, 400);
        this.setVisible(true);
    }
}