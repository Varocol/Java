import java.net.URI;
import java.net.URL;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 初始化窗口

        HostServices host =getHostServices();
        host.showDocument("www.baidu.com");
        // primaryStage.initModality(Modality.WINDOW_MODAL);不能对主窗口进行模态
        // URL url = getClass().getClassLoader().getResource("2.png");
        // String path = url.toExternalForm();
        // getResource 内好像只能用相对路径
        Button button = new Button("press");
        button.setPrefWidth(200);
        button.setPrefHeight(200);
        button.setLayoutX(100);
        button.setLayoutY(100);
        button.setCursor(Cursor.HAND);

        Group group = new Group();
        group.getChildren().add(button);

        Scene scene = new Scene(group);

        // scene.setCursor(Cursor.HAND);
        // scene.setCursor(Cursor.CLOSED_HAND);
        // scene.setCursor(Cursor.CROSSHAIR);
        scene.setCursor(Cursor.DEFAULT);
        // scene.setCursor(Cursor.MOVE);
        // scene.setCursor(Cursor.cursor("http://image.campus.xbud.run/logo-img/logo_round.png"));
        //这里面的地址参数可以直接url地址,也可以是本地路径,用本地路径是要加file:前缀

        primaryStage.setScene(scene);

        //primaryStage.setResizable(false);
        primaryStage.setOpacity(1);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.setX(400);
        primaryStage.setY(200);
        primaryStage.setTitle("Application");
        primaryStage.getIcons().add(new Image("http://image.campus.xbud.run/logo-img/logo_round.png"));
        primaryStage.show();

    }
}