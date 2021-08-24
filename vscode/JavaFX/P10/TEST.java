import java.security.Key;

import javax.swing.Action;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.event.ActionEvent;

public class TEST extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button Left  = new Button();
        Button Right = new Button();
        Button Up    = new Button();
        Button Down  = new Button();
        Button key   = new Button();
        Label  imageLabel = new Label();
        Group  group = new Group();
        Scene  scene = new Scene(group);
        //设置按钮相关属性
        {
        Left.setCursor(Cursor.HAND);
        Right.setCursor(Cursor.HAND);
        Up.setCursor(Cursor.HAND);
        Down.setCursor(Cursor.HAND);
        key.setCursor(Cursor.HAND);

        Left.setPrefHeight(60);
        Right.setPrefHeight(60);
        Up.setPrefHeight(60);
        Down.setPrefHeight(60);
        key.setPrefHeight(60);

        Left.setPrefWidth(100);
        Right.setPrefWidth(100);
        Up.setPrefWidth(100);
        Down.setPrefWidth(100);
        key.setPrefWidth(100);

        Left.setLayoutX(0);
        Right.setLayoutX(0);
        Up.setLayoutX(0);
        Down.setLayoutX(0);
        key.setLayoutX(700);

        Left.setLayoutY(44);
        Right.setLayoutY(148);
        Up.setLayoutY(252);
        Down.setLayoutY(356);
        key.setLayoutY(400);

        Left.setText("Left");
        Right.setText("Right");
        Up.setText("Up");
        Down.setText("Down");
        key.setText("Key");

        Left.setFont(Font.font("Consolas",FontWeight.THIN,20));
        Right.setFont(Font.font("Consolas",FontWeight.THIN,20));
        Up.setFont(Font.font("Consolas",FontWeight.THIN,20));
        Down.setFont(Font.font("Consolas",FontWeight.THIN,20));
        key.setFont(Font.font("Consolas",FontWeight.THIN,20));

        Left.setTextFill(Color.WHITE);
        Right.setTextFill(Color.WHITE);
        Up.setTextFill(Color.WHITE);
        Down.setTextFill(Color.WHITE);
        key.setTextFill(Color.WHITE);

        BackgroundFill RGB = new BackgroundFill(Color.GREEN, new CornerRadii(10), new Insets(3));
        Background bg = new Background(RGB);
        Left.setBackground(bg);
 
        RGB = new BackgroundFill(Color.RED, new CornerRadii(10), new Insets(3));
        bg = new Background(RGB);
        Right.setBackground(bg);

        RGB = new BackgroundFill(Color.PURPLE, new CornerRadii(10), new Insets(3));
        bg = new Background(RGB);
        Up.setBackground(bg);

        RGB = new BackgroundFill(Color.ORANGE, new CornerRadii(10), new Insets(3));
        bg = new Background(RGB);
        Down.setBackground(bg);

        RGB = new BackgroundFill(Color.ORANGE, new CornerRadii(10), new Insets(3));
        bg = new Background(RGB);
        key.setBackground(bg);
        }
        //设置被控制的对象
        {
        //    imageLabel.setText("Picture");
           imageLabel.setFont(Font.font("Consolas",FontWeight.THIN,20));
           imageLabel.setTextFill(Color.BLACK);
           imageLabel.setPrefHeight(100);
           imageLabel.setPrefWidth(100);
           imageLabel.setLayoutX(350);
           imageLabel.setLayoutY(230);
           imageLabel.setCursor(Cursor.HAND);
           BackgroundImage image = 
           new BackgroundImage(new Image("http://image.campus.xbud.run/logo-img/logo_round.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
           Background picture = new Background(image);
           imageLabel.setBackground(picture);
        }
        //设置按键事件
        {
            Left.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    if(imageLabel.getLayoutX()>0)
                    imageLabel.setLayoutX(imageLabel.getLayoutX()-10);
                }
            });
            Right.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    if(imageLabel.getLayoutX()<800)
                    imageLabel.setLayoutX(imageLabel.getLayoutX()+10);
                }
            });
            Up.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    if(imageLabel.getLayoutY()>0)
                    imageLabel.setLayoutY(imageLabel.getLayoutY()-10);
                }
            });
            Down.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    if(imageLabel.getLayoutY()<500)
                    imageLabel.setLayoutY(imageLabel.getLayoutY()+10);
                }
            });
            key.addEventHandler(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>(){
                @Override
                public void handle(KeyEvent event) {
                    System.out.println(event.getCode().getName()); 
                    if(event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT)
                    {
                        if(imageLabel.getLayoutX()>0)
                        imageLabel.setLayoutX(imageLabel.getLayoutX()-10);
                    }
                    else if(event.getCode() == KeyCode.D ||event.getCode() == KeyCode.RIGHT)
                    {
                        if(imageLabel.getLayoutX()<800)
                        imageLabel.setLayoutX(imageLabel.getLayoutX()+10);
                    }
                    else if(event.getCode() == KeyCode.W ||event.getCode() == KeyCode.UP)
                    {
                        if(imageLabel.getLayoutY()>0)
                        imageLabel.setLayoutY(imageLabel.getLayoutY()-10);
                    }
                    else if(event.getCode() == KeyCode.S ||event.getCode() == KeyCode.DOWN)
                    {
                        if(imageLabel.getLayoutY()<500)
                        imageLabel.setLayoutY(imageLabel.getLayoutY()+10);
                    }
                }
            });
            imageLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    HostServices host = getHostServices();
                    host.showDocument("http://image.campus.xbud.run/logo-img/logo_round.png");
                }
            });
        }
        

        group.getChildren().addAll(key,Left,Right,Up,Down,imageLabel); //要将key放在最前面才能不需要按下直接响应
        scene.setFill(Color.BURLYWOOD);
    
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
