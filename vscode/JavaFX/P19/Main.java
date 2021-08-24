import java.util.function.Consumer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{
     public static void main(String[] args) {
         launch(args);
     }
     @Override
     public void start(Stage primaryStage) throws Exception {
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane);
        Button b1 =new Button("Button1");
        Button b2 =new Button("Button2");
        Button b3 =new Button("Button3");
        Button b4 =new Button("Button4");

        
        stackPane.getChildren().addAll(b1,b2,b3,b4);
        stackPane.setStyle("-fx-background-color:#EE6AA7");

        stackPane.setAlignment(Pos.BOTTOM_LEFT);
        stackPane.setPadding(new Insets(10));
        stackPane.setMargin(b1, new Insets(10));

        stackPane.getChildren().forEach(new Consumer<Node>(){
            @Override
            public void accept(Node t) {
                Button bu = (Button)t;
                bu.setCursor(Cursor.HAND);
                System.out.println(bu.getText());
            }
        });

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