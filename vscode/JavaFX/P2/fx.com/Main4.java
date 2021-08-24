
import javafx.application.Application;
import javafx.stage.Stage;

public class Main4 extends Application {
    public static void main(String[] args) {
        System.out.println("main() = " + Thread.currentThread().getName());
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init() = " + Thread.currentThread().getName());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start() = " + Thread.currentThread().getName());
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop() = " + Thread.currentThread().getName());
    }

}
