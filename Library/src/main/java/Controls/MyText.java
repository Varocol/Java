package Controls;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MyText extends JTextField {
    static Border border1 = BorderFactory.createLineBorder(new Color(0, 0, 0,
            50), 1, true);
    static Border border2 = BorderFactory.createLineBorder(Color.blue, 1, true);

    public MyText(Dimension d) {
        this(d, 11);
    }

    public MyText(Dimension d, int i) {
        super();
        Init(d, i);
    }

    void Init(Dimension d, int i) {

        setFont(new Font("Arial, sans-serif;", Font.BOLD, 20));
        setBorder(BorderFactory.createCompoundBorder(border1,
                BorderFactory.createEmptyBorder(0, 5, 0, 0)));
        setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a)
                    throws BadLocationException {
                if (str == null)
                    return;
                if (getText(0, getLength()).length() + str.length() > i) {
                    Toolkit.getDefaultToolkit().beep();
                    return;
                }
                super.insertString(offs, str, a);
            }
        });
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                setBorder(BorderFactory.createCompoundBorder(border2,
                        BorderFactory.createEmptyBorder(0, 5, 0, 0)));
                repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                setBorder(BorderFactory.createCompoundBorder(border1,
                        BorderFactory.createEmptyBorder(0, 5, 0, 0)));
                repaint();
            }
        });
        setPreferredSize(d);
        setOpaque(true);
    }
}
