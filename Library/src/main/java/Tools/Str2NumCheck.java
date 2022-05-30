package Tools;

public class Str2NumCheck {
    public static boolean isDoubleValue(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isIntValue(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isUnsignedIntValue(String str) {
        try {
            return Integer.parseInt(str) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isUnsignedDoubleValue(String str) {
        try {
            return Double.parseDouble(str) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
