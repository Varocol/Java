
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setOpacity(1); //设置透明度
        // primaryStage.setAlwaysOnTop(false); //设置置顶
        primaryStage.getIcons().add(new Image("file:C:\\Users\\Varocol\\Desktop\\IMG_20210525_062711.jpg"));// 设置程序图标
        primaryStage.setX(500);// 设置窗口横向位置
        primaryStage.setY(300);// 设置窗口纵向位置
        primaryStage.setWidth(500);// 设置窗口宽度
        primaryStage.setHeight(500);// 设置窗口高度

        primaryStage.xProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("窗口x坐标 = " + newValue.intValue());
            }
        });
        primaryStage.yProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("窗口y坐标 = " + newValue.intValue());
            }
        });
        
        primaryStage.setTitle("金辰星大帅逼");
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
    }
}
