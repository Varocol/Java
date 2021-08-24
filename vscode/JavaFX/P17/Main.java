

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application{
     public static void main(String[] args) {
         launch(args);
     }
     @Override
     public void start(Stage primaryStage) throws Exception {
        FlowPane flowPane = new FlowPane();
        Scene scene = new Scene(flowPane);
        Button b1 =new Button("Button1");
        Button b2 =new Button("Button2");
        Button b3 =new Button("Button3");
        Button b4 =new Button("Button4");
        Button b5 =new Button("Button5");
        Button b6 =new Button("Button6");
        Button b7 =new Button("Button7");
        Button b8 =new Button("Button8");
        Label label = new Label();
        flowPane.getChildren().addAll(b1,b2,b3,b4,b5,b6,b7,b8);
        
        flowPane.setStyle("-fx-background-color:#EE6AA7");
        flowPane.setPadding(new Insets(10));
        // flowPane.setMargin(b1, new Insets(10));
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        flowPane.setOrientation(Orientation.HORIZONTAL);
        flowPane.setAlignment(Pos.CENTER);


        

        primaryStage.setScene(scene);
        primaryStage.setTitle("Application");
        primaryStage.setHeight(500);
        primaryStage.setWidth(800);
        primaryStage.setX(350);
        primaryStage.setY(200);
        primaryStage.getIcons().add(new Image("http://image.campus.xbud.run/logo-img/logo_round.png"));
        primaryStage.show();
     }
}