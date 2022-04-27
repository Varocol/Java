package test.sinline;

import af.swing.layout.FreeLayout;
import af.swing.layout.Margin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Myframe extends JFrame {

    //底层容器
    JPanel panel1 = new JPanel();
    //坐标系
    Coordinate_system coordinate_system = new Coordinate_system();
    //正弦曲线
    Sin_curve sin_curve = new Sin_curve();
    //坐标系像素标签
    Mylabel pixel_label = new Mylabel("像素大小:");
    //A标签
    Mylabel A_label = new Mylabel("A:");
    //omega标签
    Mylabel omega_label = new Mylabel("ω:");
    //phi标签
    Mylabel phi_label = new Mylabel("φ:");
    //scale标签
    Mylabel scale_label = new Mylabel("放大比例:");
    //图线笔触颜色标签
    Mylabel color_label = new Mylabel("图线笔触颜色:");
    //图线笔触粗细
    Mylabel width_label = new Mylabel("图线笔触粗细:");

    //放大
    Mytextfield setpixelWidth =
            new Mytextfield(String.valueOf(coordinate_system.pixelWidth).
                    substring(0,
                            Math.min(String.valueOf(coordinate_system.pixelWidth).length(), 7)));
    Mytextfield setA = new Mytextfield(String.valueOf(sin_curve.A));
    Mytextfield setomega = new Mytextfield(String.valueOf(sin_curve.omega));
    Mytextfield setphi = new Mytextfield(String.valueOf(sin_curve.phi));
    Mytextfield setscale = new Mytextfield(String.valueOf(sin_curve.scale));
    Mytextfield setcolor = new Mytextfield(Color2String(sin_curve.color));
    Mytextfield setlinewidth = new Mytextfield(String.valueOf(sin_curve.line_width));

    //公式标签
    JLabel formula_label = new JLabel(Parameters2Formula(sin_curve.A, sin_curve.omega, sin_curve.phi));

    //开关
    JButton switch_button = new JButton("相对静止");

    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    public Myframe(String title) {
        super(title);
        Init();
    }

    public Myframe() {
        Init();
    }

    public static String Color2String(Color color) {
        String R = Integer.toHexString(color.getRed());
        R = R.length() < 2 ? ('0' + R) : R;
        String B = Integer.toHexString(color.getBlue());
        B = B.length() < 2 ? ('0' + B) : B;
        String G = Integer.toHexString(color.getGreen());
        G = G.length() < 2 ? ('0' + G) : G;
        return '#' + R + B + G;
    }

    void Init() {
        //设置布局
        panel1.setLayout(new FreeLayout());
        //添加按钮
        panel1.add(switch_button, new Margin(100, -1, -1, 50));
        //添加标签
        panel1.add(pixel_label, new Margin(20, 20, -1, -1));
        panel1.add(A_label, new Margin(60, 20, -1, -1));
        panel1.add(omega_label, new Margin(100, 20, -1, -1));
        panel1.add(phi_label, new Margin(140, 20, -1, -1));
        panel1.add(scale_label, new Margin(180, 20, -1, -1));
        panel1.add(color_label, new Margin(220, 20, -1, -1));
        panel1.add(width_label, new Margin(260, 20, -1, -1));
        panel1.add(formula_label, new Margin(30, -1, -1, 30));
        //添加文本框
        panel1.add(setpixelWidth, new Margin(20, 150, -1, -1));
        panel1.add(setA, new Margin(60, 150, -1, -1));
        panel1.add(setomega, new Margin(100, 150, -1, -1));
        panel1.add(setphi, new Margin(140, 150, -1, -1));
        panel1.add(setscale, new Margin(180, 150, -1, -1));
        panel1.add(setcolor, new Margin(220, 150, -1, -1));
        panel1.add(setlinewidth, new Margin(260, 150, -1, -1));
        //设置公式标签
        formula_label.setFont(new Font("Consolas", Font.PLAIN, 30));
        formula_label.setForeground(Color.BLACK);
        //添加坐标系
        panel1.add(coordinate_system, new Margin(0, 0, 0, 0));
        //添加正弦曲线
        panel1.add(sin_curve, new Margin(0, 0, 0, 0));
        //给文本框添加自己定义的监听器
        setpixelWidth.addKeyListener(new Mykeylistener());
        setA.addKeyListener(new Mykeylistener());
        setomega.addKeyListener(new Mykeylistener());
        setphi.addKeyListener(new Mykeylistener());
        setscale.addKeyListener(new Mykeylistener());
        setcolor.addKeyListener(new Mykeylistener());
        setlinewidth.addKeyListener(new Mykeylistener());
        panel1.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                //获取鼠标相对坐标原点的偏移量
                int x = e.getX();
                int y = e.getY();
                System.out.println(x + " " + y);
                if (e.getPreciseWheelRotation() > 0) {
                    if (coordinate_system.pixelWidth - coordinate_system.pixelWidth / sin_curve.scale < 5) {
                        coordinate_system.pixelWidth = 5;
                    } else {
                        coordinate_system.pixelWidth -= coordinate_system.pixelWidth / sin_curve.scale;
                        sin_curve.scale = Math.max(sin_curve.scale - 1, 0);
                        if (switch_button.getText().equals("相对移动")) {
                            coordinate_system.x_offset =
                                    coordinate_system.getWidth() / 2.0 - x + (x - coordinate_system.getWidth() / 2.0 + coordinate_system.x_offset) * ((sin_curve.scale - 1) * 1.0 / sin_curve.scale);
                            coordinate_system.y_offset =
                                    coordinate_system.getHeight() / 2.0 - y + (y - coordinate_system.getHeight() / 2.0 + coordinate_system.y_offset) * ((sin_curve.scale - 1) * 1.0 / sin_curve.scale);
                            sin_curve.x_offset =
                                    sin_curve.getWidth() / 2.0 - x + (x - sin_curve.getWidth() / 2.0 + sin_curve.x_offset) * ((sin_curve.scale - 1) * 1.0 / sin_curve.scale);
                            sin_curve.y_offset =
                                    sin_curve.getHeight() / 2.0 - y + (y - sin_curve.getHeight() / 2.0 + sin_curve.y_offset) * ((sin_curve.scale - 1) * 1.0 / sin_curve.scale);
                        }
                    }
                } else {
                    if (switch_button.getText().equals("相对移动")) {
                        coordinate_system.x_offset =
                                coordinate_system.getWidth() / 2.0 - x + (x - coordinate_system.getWidth() / 2.0 + coordinate_system.x_offset) * ((sin_curve.scale + 1) * 1.0 / sin_curve.scale);
                        coordinate_system.y_offset =
                                coordinate_system.getHeight() / 2.0 - y + (y - coordinate_system.getHeight() / 2.0 + coordinate_system.y_offset) * ((sin_curve.scale + 1) * 1.0 / sin_curve.scale);
                        sin_curve.x_offset =
                                sin_curve.getWidth() / 2.0 - x + (x - sin_curve.getWidth() / 2.0 + sin_curve.x_offset) * ((sin_curve.scale + 1) * 1.0 / sin_curve.scale);
                        sin_curve.y_offset =
                                sin_curve.getHeight() / 2.0 - y + (y - sin_curve.getHeight() / 2.0 + sin_curve.y_offset) * ((sin_curve.scale + 1) * 1.0 / sin_curve.scale);
                    }
                    coordinate_system.pixelWidth += coordinate_system.pixelWidth / sin_curve.scale;
                    sin_curve.scale += 1;
                }
                setscale.setText(String.valueOf(sin_curve.scale));
                setpixelWidth.setText(String.valueOf(coordinate_system.pixelWidth));
                Img_update();
            }
        });

        //按钮设置
        switch_button.setFont(new Font("宋体", Font.PLAIN, 20));
        switch_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (switch_button.getText().equals("相对移动")) {
                    switch_button.setText("相对静止");
                } else {
                    switch_button.setText("相对移动");
                }
            }
        });
        switch_button.setOpaque(true);

        //设置布局
        setLayout(new FreeLayout());
        setContentPane(panel1);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(dimension.width / 2 - getSize().width / 2,
                dimension.height / 2 - getSize().height / 2);
        setVisible(true);
    }

    void Img_update() {
        coordinate_system.pixelWidth =
                Math.max(Double.parseDouble(setpixelWidth.getText()), 5);
        sin_curve.A = Math.max(Integer.parseInt(setA.getText()), 0);
        sin_curve.omega =
                Math.max(Integer.parseInt(setomega.getText()), 0);
        sin_curve.phi = Math.max(Integer.parseInt(setphi.getText()), 0);
        sin_curve.scale = Math.max(Integer.parseInt(setscale.getText()), 1);
        sin_curve.color = Color.decode(setcolor.getText());
        sin_curve.line_width =
                Math.max(Integer.parseInt(setlinewidth.getText()), 1);
        repaint();
        setpixelWidth.setText(String.valueOf(coordinate_system.pixelWidth).substring(0,
                Math.min(String.valueOf(coordinate_system.pixelWidth).length(), 7)));
        setA.setText(String.valueOf(sin_curve.A));
        setomega.setText(String.valueOf(sin_curve.omega));
        setphi.setText(String.valueOf(sin_curve.phi));
        setscale.setText(String.valueOf(sin_curve.scale));
        setcolor.setText(Color2String(sin_curve.color));
        setlinewidth.setText(String.valueOf(sin_curve.line_width));
        formula_label.setText(Parameters2Formula(sin_curve.A, sin_curve.omega, sin_curve.phi));
    }

    String Parameters2Formula(int A, int omega, int phi) {
        String s = "y=";
        if (sin_curve.A != 1) {
            s += sin_curve.A;
        }
        s += "sin(";
        if (sin_curve.omega != 1) {
            s += sin_curve.omega;
        }
        s += "x";
        if (sin_curve.phi != 0) {
            s += "+" + sin_curve.phi;
        }
        s += ")";
        if (sin_curve.A == 0) {
            s = "0";
        }
        return s;
    }

    class Mykeylistener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == '\n') {
                System.out.println("enter");
                Img_update();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}



