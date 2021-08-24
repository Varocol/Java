import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Platform.setImplicitExit(true);
        // 将implicitExit属性设置为指定的值。如果此属性为true，则当最后一个窗口关闭时，JavaFX运行时将隐式关闭；
        // JavaFX启动程序将调用Application.stop方法并终止JavaFX应用程序线程。
        // 如果此属性为false，则即使在最后一个窗口关闭之后，应用程序仍将继续正常运行，直到应用程序调用exit为止。默认值为true。
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                // System.out.println(Platform.isSupported(ConditionalFeature.SCENE3D));
                // System.out.println(Platform.isSupported(ConditionalFeature.EFFECT));
            }
        });
        primaryStage.getIcons().add(new Image("http://image.campus.xbud.run/logo-img/logo_round.png"));
        primaryStage.setOpacity(1);
        primaryStage.show();
        Thread.sleep(1000);
        // Platform.exit();
    }
}
