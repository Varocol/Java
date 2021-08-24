import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Stage stage = new Stage();

        stage.setTitle("JavaFX");// 设置窗口

        stage.getIcons().add(new Image("http://image.campus.xbud.run/logo-img/logo_round.png"));// 设置程序图标

        // stage.setIconified(true);// 设置最小化

        // stage.setMaximized(true);// 设置最大化

        // stage.setResizable(false);// 设置不可拉伸

        stage.setWidth(500);
        stage.setHeight(500);

        // stage.setMaxHeight(700);
        // stage.setMaxWidth(700);

        // stage.setMinHeight(700);
        // stage.setMinWidth(700);

        // System.out.println("宽度 = " + stage.getWidth());
        // System.out.println("高度 = " + stage.getHeight());

        stage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                stage.setHeight(500);
                System.out.println("当前高度：" + newValue.intValue());
            }
        });

        stage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                stage.setWidth(500);
                System.out.println("当前宽度：" + newValue.intValue());
            }
        });
        // stage.setFullScreen(true);
        // stage.setScene(new Scene(new Group()));
        stage.show();
        // stage.close();//关闭窗口
    }
}
