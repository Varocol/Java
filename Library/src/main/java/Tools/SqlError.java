package Tools;

import javax.swing.*;
import java.awt.*;

public class SqlError {
    public static void quit(Component component, String message) {
        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(component), message, "错误", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
}
