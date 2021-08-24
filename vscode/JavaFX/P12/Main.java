import javax.swing.ProgressMonitorInputStream;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        TextField text = new TextField();
        PasswordField passwordtext = new PasswordField();
        Label label1 = new Label();
        Label label2 = new Label();
        Group group = new Group();
        Scene scene = new Scene(group);
        
        group.getChildren().addAll(label1,label2,text,passwordtext);

        //组件设置
        {
            //设置标签的基本属性
            {
               //label1
               label1.setText("账号:");
               label1.setLayoutX(150);
               label1.setLayoutY(150);
               label1.setPrefHeight(50);
               label1.setPrefWidth(100);
               label1.setFont(Font.font("KaiTi",FontWeight.BLACK,20));
               label1.setTextFill(Color.BLACK);
               label1.setTextAlignment(TextAlignment.CENTER);

               BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, new CornerRadii(10), new Insets(5, 0, 5, 0));
               Background background = new Background(backgroundFill);
               label1.setBackground(background);

               //label2
               label2.setText("密码:");
               label2.setLayoutX(150);
               label2.setLayoutY(250);
               label2.setPrefHeight(50);
               label2.setPrefWidth(100);
               label2.setFont(Font.font("KaiTi",FontWeight.BLACK,20));
               label2.setTextFill(Color.BLACK);
               label2.setTextAlignment(TextAlignment.CENTER);

               backgroundFill = new BackgroundFill(Color.RED, new CornerRadii(10), new Insets(5, 0, 5, 0));
               background = new Background(backgroundFill);
               label2.setBackground(background);
            }
            //设置文本框基本属性   
            {
                // text.setText("text");
                text.setLayoutX(250);
                text.setLayoutY(150);
                text.setPrefHeight(50);
                text.setPrefWidth(200);
                
                //设置字体
                text.setFont(Font.font("Consolas",FontWeight.BLACK,20));
    
                //设置背景
                BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, new CornerRadii(10), new Insets(5));
                Background background = new Background(backgroundFill);
                text.setBackground(background); 
    
                //设置文本提示
                Tooltip tip = new Tooltip("文本提示");
                tip.setFont(Font.font("KaiTi",FontWeight.BLACK,20));
                text.setTooltip(tip);
    
                //设置输入提示
                text.setPromptText("请输入7个字符");
                text.setFocusTraversable(false);
    
                //设置文本框监听
                text.textProperty().addListener(new ChangeListener<String>(){
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if(newValue.length() > 7)
                        {
                            text.setText(oldValue);
                        }
                    }
                });
    
                //选择监听
                text.selectedTextProperty().addListener(new ChangeListener<String>(){
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        System.out.println(newValue);
                    }
                });
                
                //单击事件
                text.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        System.out.println("1");
                    }
                });

            }
            //设置密码文本框基本属性
            {
                passwordtext.setLayoutX(250);
                passwordtext.setLayoutY(250);
                passwordtext.setPrefHeight(50);
                passwordtext.setPrefWidth(200);
                
                //设置字体
                passwordtext.setFont(Font.font("Consolas",FontWeight.BLACK,20));

                //设置背景
                BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, new CornerRadii(10), new Insets(5));
                Background background = new Background(backgroundFill);
                passwordtext.setBackground(background); 

                //设置文本提示
                Tooltip tip = new Tooltip("密码");
                tip.setFont(Font.font("KaiTi",FontWeight.BLACK,20));
                passwordtext.setTooltip(tip);

                //设置输入提示
                passwordtext.setPromptText("请输入密码");
                passwordtext.setFocusTraversable(false);

                //设置文本监听
                passwordtext.textProperty().addListener(new ChangeListener<String>(){
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if(newValue.length() > 7)
                        {
                            passwordtext.setText(oldValue);
                        }
                    }
                });

                //设置选择监听
                passwordtext.selectedTextProperty().addListener(new ChangeListener<String>(){
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                         System.out.println(newValue);
                    }
                });

            }

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