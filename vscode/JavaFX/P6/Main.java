import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Screen screen = Screen.getPrimary();
        Rectangle2D rec1 = screen.getBounds();
        Rectangle2D rec2 = screen.getVisualBounds();
        
        
        //全屏宽高和坐标
        System.out.println("全部屏幕的信息");
        System.out.println("左上角x = "+ rec1.getMinX());
        System.out.println("右下角x = "+ rec1.getMaxX());
        System.out.println("左上角y = "+ rec1.getMinY());
        System.out.println("右下角y = "+ rec1.getMaxY());
        System.out.println("----------------------------");
        System.out.println("宽度 = "+rec1.getWidth());
        System.out.println("高度 = "+rec1.getHeight());
        System.out.println("----------------------------------------------------");
        System.out.println("可见屏幕的信息");
        System.out.println("左上角x = "+ rec2.getMinX());
        System.out.println("右下角x = "+ rec2.getMaxX());
        System.out.println("左上角y = "+ rec2.getMinY());
        System.out.println("右下角y = "+ rec2.getMaxY());
        System.out.println("----------------------------");
        System.out.println("宽度 = "+rec2.getWidth());
        System.out.println("高度 = "+rec2.getHeight());
        System.out.println("----------------------------------------------------");
        System.out.println("当前系统DPI = "+screen.getDpi());
        Platform.exit();
    }
}