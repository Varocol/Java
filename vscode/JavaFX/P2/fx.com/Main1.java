
import javafx.application.Application;
import javafx.stage.Stage;

public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("hello world");
        primaryStage.setTitle("我的第二个JavaFX程序");
        primaryStage.show();
    }
}
