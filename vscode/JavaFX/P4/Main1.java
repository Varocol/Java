
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//窗口类型
public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage s1 = new Stage();
        s1.setTitle("S1");
        s1.initStyle(StageStyle.DECORATED);
        s1.show();

        Stage s2 = new Stage();
        s2.setTitle("S2");
        s2.initStyle(StageStyle.TRANSPARENT);
        s2.show();

        Stage s3 = new Stage();
        s3.setTitle("S3");
        s3.initStyle(StageStyle.UNDECORATED);
        s3.show();

        Stage s4 = new Stage();
        s4.setTitle("S4");
        s4.initStyle(StageStyle.UNIFIED);
        s4.show();

        Stage s5 = new Stage();
        s5.setTitle("S5");
        s5.initStyle(StageStyle.UTILITY);
        s5.show();
        
        Platform.exit();
         
    }
}