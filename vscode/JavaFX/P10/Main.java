import javax.swing.Action;

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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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

public class Main extends Application{
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
        b.setTextFill(Paint.valueOf( "#FFFFFF"));

        BackgroundFill RGB = new BackgroundFill(Paint.valueOf("#15F574"), new CornerRadii(10), new Insets(3));
        Background bg = new Background(RGB);
        b.setBackground(bg);

        b.setCursor(Cursor.HAND);
        
        BorderStroke bos = new BorderStroke(Paint.valueOf("#15F574"), BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(2));
        Border bo = new Border(bos);
        b.setBorder(bo);
 
        // b.setOnAction(new EventHandler<ActionEvent>() {
        //     @Override
        //     public void handle(ActionEvent event) {
        //         Button bu = (Button)event.getSource();
        //         bu.setPrefHeight(100);
        //         HostServices hostServices = getHostServices();
        //         hostServices.showDocument("www.baidu.com");
        //     }
        // });
        b.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Button bu = (Button)event.getSource();
                bu.setPrefHeight(100);
                System.out.println("鼠标名字 = " + event.getButton().name());
                if(event.getClickCount() == 2 && event.getButton() == MouseButton.PRIMARY)
                //双击事件
                //五种写法
                //1 event.getButton().name().equals(MouseButton.PRIMARY.name())字符串匹配
                //2 event.getButton().name().equals("PRIMARY");直接比较名字
                //3 event.getButton().name() == "PRIMARY";
                //4 event.getButton().name() == MouseButton.PRIMARY.name();间接比较
                //5 event.getButton() == MouseButton.SECONDARY 直接比较对象
                {
                     HostServices hostServices = getHostServices();
                     hostServices.showDocument("www.baidu.com");
                }
            }
        });
        //程序里面推荐使用clicked
        b.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.A)
                //五种写法
                //1 event.getCode().getName() == KeyCode.A.getName();
                //2 event.getCode().getName().equals(KeyCode.A.getName());
                //3 event.getCode().getName().equals("A");
                //4 event.getCode() == KeyCode.A;
                //5 event.getCode().getName()=="A" ;
                System.out.println("press = "+event.getCode().getName());
            }
        });

        b.setOnKeyReleased(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.A)
                System.out.println("release = "+event.getCode().getName());
            }
        });

        b.addEventHandler(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.B)
                System.out.println(event.getCode().getName());
            }
        });


        Group group = new Group();
        // group.setAutoSizeChildren(false);
        group.getChildren().add(b);
        Scene scene = new Scene(group);

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
