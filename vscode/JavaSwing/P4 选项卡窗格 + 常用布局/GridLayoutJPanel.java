import javax.swing.*;

import java.awt.*;

public class GridLayoutJPanel extends JPanel {
    public GridLayoutJPanel() {
        GridLayout grid = new GridLayout(12, 12);
        setLayout(grid);
        Label label[][] = new Label[12][12];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                label[i][j] = new Label();
                if ((i + j) % 2 == 0) {
                    label[i][j].setBackground(Color.BLACK);
                } else {
                    label[i][j].setBackground(Color.WHITE);
                }
                add(label[i][j]);
            }
        }
    }
}
