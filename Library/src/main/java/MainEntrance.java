import Frames.LoginFrame;
import Tools.EnableAntiAliasing;

public class MainEntrance {
    public static void main(String[] args) {
        EnableAntiAliasing.enableAntiAliasing();
        new LoginFrame();
    }
}
