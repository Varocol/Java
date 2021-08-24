import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Main extends Application{
     public static void main(String[] args) {
         launch(args);
     }
     @Override
     public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane);
        Button b1 =new Button("Button1");
        Button b2 =new Button("Button2");
        Button b3 =new Button("Button3");
        Button b4 =new Button("Button4");
        Button b5 =new Button("Button5");
        Button b6 =new Button("Button6");
        Button b7 =new Button("Button7");
        Button b8 =new Button("Button8");
        
        gridPane.setStyle("-fx-background-color:#EE6AA7");

        gridPane.add(b1, 0, 0);
        // gridPane.setConstraints(b1, 0, 0);
        // gridPane.getChildren().addAll(b1);
        // gridPane.setRowIndex(b1, 0);
        // gridPane.setColumnIndex(b1, 0);
        // gridPane.getChildren().addAll(b1);
        gridPane.add(b2, 1, 0);
        gridPane.add(b3, 0, 1);
        gridPane.add(b4, 1, 1);
        gridPane.add(b5, 0, 2);
        gridPane.add(b6, 1, 2);
        gridPane.add(b7, 0, 3);
        gridPane.add(b8, 1, 3);

        // gridPane.setHgap(10);
        // gridPane.setVgap(10);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10));
        // gridPane.setMargin(b1, new Insets(10));

        gridPane.getColumnConstraints().add(new ColumnConstraints(100));
        gridPane.getRowConstraints().add(new RowConstraints(200));
        

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