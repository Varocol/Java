package org.example.Learn;

import javax.swing.*;

public class model {
    public static void main(String[] args) {
        Myframe myframe = new Myframe();
    }
}

class Myframe extends JFrame {

    public Myframe(String title) {
        super(title);
        Init();
    }

    public Myframe() {
        Init();
    }

    void Init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocation(800, 400);
        setVisible(true);
    }
}
