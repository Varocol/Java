import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.Mnemonic;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Button b = new Button();        
        Group group = new Group();
        Scene scene = new Scene(group);
        group.getChildren().add(b);
        //按钮属性设置
        {
            b.setText("Button");
            b.setPrefHeight(100);
            b.setPrefWidth(250);
            b.setLayoutX(280);
            b.setLayoutY(180);
            b.setFont(Font.font("Consolas",FontWeight.BLACK,30));
            b.setCursor(Cursor.HAND);
            b.setTextFill(Color.WHITE);
            
            //设置按钮背景
            BackgroundFill RGB = new BackgroundFill(Color.GREEN, new CornerRadii(10), new Insets(3));
            Background bg = new Background(RGB);
            b.setBackground(bg);
            
            //设置边框
            BorderStroke borderStroke = 
            new BorderStroke(Color.valueOf("#ffffff00"), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(5));
            Border border = new Border(borderStroke);
            b.setBorder(border);
        }

        //按钮事件设置
        {
           //鼠标进入按钮区域
           b.addEventHandler(MouseEvent.MOUSE_ENTERED,new EventHandler<MouseEvent>(){
               @Override
               public void handle(MouseEvent event) {
                   b.setText("Entered");
               }
           });
           //鼠标离开按钮区域
           b.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
               @Override
               public void handle(MouseEvent event) {
                   b.setText("Button");
               }
           });
           //鼠标离开文本
        //    b.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, new EventHandler<MouseEvent>(){
        //     @Override
        //     public void handle(MouseEvent event) {
        //            b.setText("Button Away");
        //     }
        //    });
           //鼠标单击按钮区域
           b.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
               @Override
               public void handle(MouseEvent event) {
                   b.setText("MousePressed");
               }
           });
           //鼠标事件
           b.setOnAction(new EventHandler<ActionEvent>(){
               @Override
               public void handle(ActionEvent event) {
                   b.setText("KeyPressed");
               }
           });
           //setonAction 和 eventhandler 两个都会响应按键，但前者先响应，并且快捷键只认前者
        }

        //快捷键设置
        {
            //SHORT_CUT是快捷键
            //第一种
            KeyCombination kc1 = 
            new KeyCodeCombination(KeyCode.C, KeyCombination.ALT_DOWN,KeyCombination.CONTROL_DOWN);
            Mnemonic mnemonic1= new Mnemonic(b, kc1);
            scene.addMnemonic(mnemonic1);

            //第二种
            KeyCombination kc2 = 
            new KeyCharacterCombination("O", KeyCombination.ALT_DOWN);
            Mnemonic mnemonic2= new Mnemonic(b, kc2);
            scene.addMnemonic(mnemonic2);
  
            //第三种(不推荐使用)
            KeyCombination kc3 = 
            new KeyCodeCombination(KeyCode.K, KeyCombination.CONTROL_DOWN, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN, KeyCombination.META_DOWN, KeyCombination.SHORTCUT_DOWN);
            Mnemonic mnemonic3= new Mnemonic(b, kc3);
            scene.addMnemonic(mnemonic3);

            //第四种
            KeyCombination kc4 = 
            new KeyCodeCombination(KeyCode.K, KeyCombination.SHORTCUT_DOWN);
            scene.getAccelerators().put(kc4, new Runnable(){
                @Override
                public void run() {

                    b.setText("SHORTCUT");  

                    // b.fire();
                }
            });

            //第五种
            KeyCombination kc5 = KeyCombination.valueOf("alt+k");
            Mnemonic mnemonic5 = new Mnemonic(b, kc5);
            scene.addMnemonic(mnemonic5);

        }

        //场景设置
        {
            scene.setFill(Color.DODGERBLUE);
        }


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