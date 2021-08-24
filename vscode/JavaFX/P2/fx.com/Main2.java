
import javafx.application.Application;
import javafx.stage.Stage;

public class Main2 extends Application {
    public static void main(String[] args) {
        Application.launch(Main1.class,args);  //
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("hello world");
        primaryStage.setTitle("我的第三个JavaFX程序");
        primaryStage.show();
    }
}
