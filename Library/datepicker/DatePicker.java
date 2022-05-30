//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.eltima.components.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

public class DatePicker extends a3 {
    private String defaultpattren = "MM/dd/yyyy";
    public static final int CENTER = 0;
    public static final int LEFT = 2;
    public static final int RIGHT = 4;
    private JFormattedTextField field;
    private SimpleDateFormat sdf;
    private String pattern;
    private Object[] options = new Object[]{"OK"};
    private boolean printerror = false;
    private String errormsg;
    private boolean showerrormsg = true;
    private Vector focuslostlisteners = new Vector();
    private Vector focusinlisteners = new Vector();
    private Component comp;

    static {
        Locale.setDefault(Locale.CHINA);
    }

    public void setLocale(Locale locale) {
        super.setLocale(locale);
    }

    public DatePicker(Component comp) {
        this.setComp(comp);
        this.setPattern(this.defaultpattren);
        this.initlisteners();
    }

    public DatePicker(Component comp, Date d) {
        super(d);
        this.setComp(comp);
        this.setPattern(this.defaultpattren);
        this.initlisteners();
    }

    public void initlisteners() {
        if (this.field == null) {
            this.initField();
        }

        this.field.setOpaque(true);
        this.field.setFocusLostBehavior(3);
        KeyListener[] keylist = this.field.getKeyListeners();

        for(int i = 0; i < keylist.length; ++i) {
            this.field.removeKeyListener(keylist[i]);
        }

        this.field.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if (DatePicker.this.getComp() != null) {
                    DatePicker.this.getComp().setCursor(new Cursor(2));
                }

            }

            public void mouseExited(MouseEvent e) {
                if (DatePicker.this.getComp() != null) {
                    DatePicker.this.getComp().setCursor(new Cursor(0));
                }

            }
        });
        this.field.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                FocusGainedListener[] ff = DatePicker.this.getFocusinListeners();

                for(int i = 0; i < ff.length; ++i) {
                    ff[i].Focusin(DatePicker.this.field);
                }

            }

            public void focusLost(FocusEvent e) {
                boolean goon = true;
                if (DatePicker.this.focuslostlisteners.size() != 0) {
                    for(int i = 0; i < DatePicker.this.focuslostlisteners.size(); ++i) {
                        FocusLostListener flstener = (FocusLostListener)DatePicker.this.focuslostlisteners.get(i);
                        goon = flstener.focusLost(DatePicker.this.field);
                        if (!goon) {
                            break;
                        }
                    }
                }

                if (!goon) {
                    DatePicker.this.printerror = !DatePicker.this.printerror;
                    if (DatePicker.this.printerror && DatePicker.this.showerrormsg) {
                        JOptionPane.showOptionDialog((Component)null, DatePicker.this.getErrormsg(), "Error", -1, 2, (Icon)null, DatePicker.this.options, DatePicker.this.options[0]);
                    }

                    DatePicker.this.field.requestFocus();
                } else {
                    String s = DatePicker.this.field.getText();
                    if (!s.equals("")) {
                        try {
                            Date date = DatePicker.this.sdf.parse(s);
                            DatePicker.this.field.setValue(date);
                            DatePicker.this.printerror = false;
                        } catch (ParseException var5) {
                            DatePicker.this.printerror = !DatePicker.this.printerror;
                            if (DatePicker.this.printerror && DatePicker.this.showerrormsg) {
                                JOptionPane.showOptionDialog((Component)null, DatePicker.this.getErrormsg(), "Error", -1, 2, (Icon)null, DatePicker.this.options, DatePicker.this.options[0]);
                            }

                            DatePicker.this.field.requestFocus();
                        }
                    }

                }
            }
        });
    }

    public void addFocusLostListener(FocusLostListener f) {
        this.focuslostlisteners.add(f);
    }

    public void addfocusInListener(FocusGainedListener f) {
        this.focusinlisteners.add(f);
    }

    public FocusGainedListener[] getFocusinListeners() {
        FocusGainedListener[] ff = new FocusGainedListener[this.focusinlisteners.size()];

        for(int i = 0; i < this.focusinlisteners.size(); ++i) {
            ff[i] = (FocusGainedListener)this.focusinlisteners.get(i);
        }

        return ff;
    }

    public FocusLostListener[] getFocusLostListeners() {
        FocusLostListener[] fl = new FocusLostListener[this.focuslostlisteners.size()];

        for(int i = 0; i < fl.length; ++i) {
            fl[i] = (FocusLostListener)this.focuslostlisteners.get(i);
        }

        return fl;
    }

    public void setCalendarVisible(boolean flag) {
        Object[] args = new Object[]{flag ? Boolean.TRUE : Boolean.FALSE};

        try {
            MethodInvoke.execMethod(this, args, "if", new Class[]{Boolean.TYPE});
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public void setTimePanleVisible(boolean flag) {
        Object[] args = new Object[]{flag ? Boolean.TRUE : Boolean.FALSE};

        try {
            MethodInvoke.execMethod(this, args, "do", new Class[]{Boolean.TYPE});
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public void setDisableddays(int[] days) {
        Object[] args = new Object[]{days};

        try {
            MethodInvoke.execMethod(this, args, "a", new Class[]{(new int[0]).getClass()});
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public void setHightlightdays(int[] days, Color color) {
        Object[] args = new Object[]{days, color};

        try {
            MethodInvoke.execMethod(this, args, "a", new Class[]{(new int[0]).getClass(), Color.class});
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    public Object getValue() {
        if (this.field == null) {
            this.initField();
        }

        return this.field.getValue();
    }

    public void setDate(Date d) {
        Object[] args = new Object[]{d};

        try {
            MethodInvoke.execMethod(this, args, "a", new Class[]{Date.class});
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public void setPattern(String pattern) {
        super.a(pattern);
        this.sdf = new SimpleDateFormat(pattern);
        this.pattern = pattern;
        this.errormsg = "InValid Date!\nPattern:(" + pattern + ")";
    }

    public String getText() {
        if (this.field == null) {
            this.initField();
        }

        return this.field.getText();
    }

    public void setText(String value) {
        if (this.field == null) {
            this.initField();
        }

        this.field.setText(value);
    }

    public void setEditorable(boolean flag) {
        if (this.field == null) {
            this.initField();
        }

        this.field.setEditable(flag);
    }

    public void setFieldBackground(Color c) {
        if (this.field == null) {
            this.initField();
        }

        this.field.setBackground(c);
    }

    public void setFieldForeground(Color c) {
        if (this.field == null) {
            this.initField();
        }

        this.field.setForeground(c);
    }

    public void setTextAlign(int align) {
        if (this.field == null) {
            this.initField();
        }

        this.field.setHorizontalAlignment(align);
    }

    private void initField() {
        int count = this.getComponentCount();

        for(int i = 0; i < count; ++i) {
            Component c = this.getComponent(i);
            if (c instanceof JFormattedTextField) {
                this.field = (JFormattedTextField)c;
            }
        }

    }

    public String getPattern() {
        return this.pattern;
    }

    public String getErrormsg() {
        return this.errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public boolean isShowerrormsg() {
        return this.showerrormsg;
    }

    public void setShowerrormsg(boolean showerrormsg) {
        this.showerrormsg = showerrormsg;
    }

    public JFormattedTextField getField() {
        return this.field;
    }

    public Vector getFocusinlisteners() {
        return this.focusinlisteners;
    }

    public void setFocusinlisteners(Vector focusinlisteners) {
        this.focusinlisteners = focusinlisteners;
    }

    public Component getComp() {
        return this.comp;
    }

    public void setComp(Component comp) {
        this.comp = comp;
    }
}
