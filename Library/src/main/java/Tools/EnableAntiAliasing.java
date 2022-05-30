package Tools;

public class EnableAntiAliasing {
    //全局抗锯齿
    public static void enableAntiAliasing() {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
    }
}
