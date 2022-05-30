package Tools;

import java.util.regex.Pattern;

public class Judgespchar {
    public static boolean check(String str) {
        String regEx = "\\pP|\\pS|\\s+";
        return Pattern.compile(regEx).matcher(str).find();
    }
    public static boolean check(char[] str) {
        String regEx = "\\pP|\\pS|\\s+";
        return Pattern.compile(regEx).matcher(new String(str)).find();
    }
}
