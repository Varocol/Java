import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        TilePane tilePane = new TilePane();
        FlowPane flowPane = new FlowPane();
        Scene scene = new Scene(tilePane);
        Button b1 = new Button("Button1");
        Button b2 = new Button("Button2");
        Button b3 = new Button("Button3");
        Button b4 = new Button("Button4");

        b1.setPrefHeight(200);
        tilePane.getChildren().addAll(b1,b2,b3,b4);
        tilePane.setHgap(10);
        tilePane.setVgap(10);
        tilePane.setPadding(new Insets(10));
        tilePane.setMargin(b1, new Insets(10));
        tilePane.setAlignment(Pos.CENTER);
        tilePane.setOrientation(Orientation.HORIZONTAL);
        tilePane.setAlignment(b2, Pos.BOTTOM_CENTER);

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