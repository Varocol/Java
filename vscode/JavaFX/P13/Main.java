import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane ap = new AnchorPane();
        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
        Button button4 = new Button();
        Group  group1  = new Group();
        Group  group2  = new Group();
        Scene scene = new Scene(ap);
        ap.getChildren().addAll(group1,group2);
        group1.getChildren().addAll(button1,button2);
        group2.getChildren().addAll(button3,button4);

        //固定窗格设置
        {
            ap.setStyle("-fx-background-color:#ff3e96");
            ap.setPadding(new Insets(10));
            AnchorPane.setTopAnchor(group1, 100.0);
            AnchorPane.setLeftAnchor(group1, 100.0);
            AnchorPane.setBottomAnchor(group1, 0.0);
            AnchorPane.setRightAnchor(group1, 0.0);
            AnchorPane.setTopAnchor(group2, 100.0);
            AnchorPane.setLeftAnchor(group2, 300.0);
            AnchorPane.setBottomAnchor(group2, 200.0);
            AnchorPane.setRightAnchor(group2, 500.0);
            group1.setCursor(Cursor.cursor("http://image.campus.xbud.run/logo-img/logo_round.png"));
            // ap.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            // @Overrided
            // public void handle(MouseEvent event) {
            //     System.out.println("1");
            // }
            // });
        }
        
        //组件设置
        {
            //button1
            button1.setText("Button1");
            button1.setPrefHeight(50);
            button1.setPrefWidth(150);
            button1.setLayoutX(10);
            button1.setLayoutY(10);
            button1.setFont(Font.font("Consolas",FontWeight.BLACK,20));
            button1.setTextFill(Color.BLACK);
            Background background = new Background(new BackgroundFill(Color.BLUE,new CornerRadii(10),new Insets(5, 0, 5, 0)));
            button1.setBackground(background);
            // AnchorPane.setTopAnchor(button1, 10.0);
            // AnchorPane.setLeftAnchor(button1, 10.0);
            // AnchorPane.setBottomAnchor(button1, 10.0);
            // AnchorPane.setRightAnchor(button1, 10.0);
            //1.layout不如setanchor厉害
            //2.setheight和setwidth 不如setanchor厉害
            
            //button2
            button2.setText("Button2");
            button2.setPrefHeight(50);
            button2.setPrefWidth(150);
            button2.setLayoutX(10);
            button2.setLayoutY(50);
            button2.setFont(Font.font("Consolas",FontWeight.BLACK,20));
            button2.setTextFill(Color.BLACK);
            background = new Background(new BackgroundFill(Color.YELLOW,new CornerRadii(10),new Insets(5, 0, 5, 0)));
            button2.setBackground(background); 
            // AnchorPane.setTopAnchor(button2, 250.0);
            // AnchorPane.setLeftAnchor(button2, 300.0);

            //button3
            button3.setText("Button3");
            button3.setPrefHeight(50);
            button3.setPrefWidth(150);
            button3.setLayoutX(30);
            button3.setLayoutY(10);
            button3.setFont(Font.font("Consolas",FontWeight.BLACK,20));
            button3.setTextFill(Color.BLACK);
            background = new Background(new BackgroundFill(Color.GREEN,new CornerRadii(10),new Insets(5, 0, 5, 0)));
            button3.setBackground(background);

            // button4
            button4.setText("Button4");
            button4.setPrefHeight(50);
            button4.setPrefWidth(150);
            button4.setLayoutX(30);
            button4.setLayoutY(50);
            button4.setFont(Font.font("Consolas",FontWeight.BLACK,20));
            button4.setTextFill(Color.BLACK);
            background = new Background(new BackgroundFill(Color.RED,new CornerRadii(10),new Insets(5, 0, 5, 0)));
            button4.setBackground(background);
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