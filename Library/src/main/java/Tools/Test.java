package Tools;

import javax.swing.*;
import java.awt.*;

public class Test {
    public static boolean test = true;

    public static void test(JComponent c) {
        if (test) {
            c.setBorder(BorderFactory.createDashedBorder(Color.BLACK, 1, 1, 1,
                    true));
        }
    }
}
