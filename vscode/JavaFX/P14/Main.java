import org.graalvm.compiler.nodeinfo.StructuralInput.Anchor;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{
      public static void main(String[] args) {
          launch(args);
      }
      @Override
      public void start(Stage primaryStage) throws Exception {
          
          AnchorPane ap  = new AnchorPane();
          AnchorPane ap1 = new AnchorPane();
          ap.getChildren().addAll(ap1);
          
          ap.setStyle("-fx-background-color:#FF3E96");
          ap1.setStyle("-fx-background-color:#9BCD9B");

          ap1.setPrefHeight(300);
          ap1.setPrefWidth(500);

          ap.setTopAnchor(ap1, 0.0);
          ap.setLeftAnchor(ap1, 100.0);
          ap.setBottomAnchor(ap1, 200.0);
          ap.setRightAnchor(ap1, 500.0);


          Scene scene = new Scene(ap);

          primaryStage.setScene(scene);
          primaryStage.setHeight(500);
          primaryStage.setWidth(500);
          primaryStage.getIcons().add(new Image("http://image.campus.xbud.run/logo-img/logo_round.png"));
          primaryStage.setTitle("Application");
          primaryStage.setX(350);
          primaryStage.setY(200);
          primaryStage.show();
      }
}