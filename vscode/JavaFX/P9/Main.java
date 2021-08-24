import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.regexp.joni.ast.BackRefNode;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.event.ActionEvent;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button b = new Button();
        b.setText("b1");
        b.setPrefHeight(50);
        b.setPrefWidth(80);
        // b.setLayoutX(100);
        // b.setLayoutY(100);
        
        b.setFont(Font.font("Consolas",FontWeight.THIN,30));
        b.setTextFill(Paint.valueOf("#FFFFFF"));

        BackgroundFill RGB = new BackgroundFill(Paint.valueOf("#15F574"), new CornerRadii(10), new Insets(3));
        Background bg = new Background(RGB);
        b.setBackground(bg);

        b.setCursor(Cursor.HAND);
        
        BorderStroke bos = new BorderStroke(Paint.valueOf("#15F574"), BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(2));
        Border bo = new Border(bos);
        b.setBorder(bo);

        
        // String css = new String();
        // css = "-fx-text:\"b1\";"+
            //   "-fx-prefheight:60;"+
            //   "-fx-prefwidth:60;"+
            //   "-fx-layoutx:100;"+
            //   "-fx-layouty:100;"+
            //   "-fx-font-family:Consolas;"+
            //   "-fx-font-size:50;"+
            //   "-fx-text-fill:#B4B4B4;"+
            //   "-fx-border-color:#B4B4B4;"+
            //   "-fx-border-insets:5;"+
            //   "-fx-border-style:solid;"+
            //   "-fx-border-radius:5"+
            //   "-fx-"
        // ;
        // b.setStyle(css);

        
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button bu = (Button)event.getSource();
                bu.setPrefHeight(100);
                HostServices hostServices = getHostServices();
                hostServices.showDocument("www.baidu.com");
            }
        });
        
        Group group = new Group();
        // group.setAutoSizeChildren(false);
        group.getChildren().add(b);

        
        Scene scene = new Scene(group);
        // scene.setFill(Paint.valueOf("#111111"));

        // primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.setX(400);
        primaryStage.setY(150);
        primaryStage.setTitle("Application");
        primaryStage.getIcons().add(new Image("http://image.campus.xbud.run/logo-img/logo_round.png"));
        primaryStage.show();
    }
}