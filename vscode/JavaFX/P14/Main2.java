import org.graalvm.compiler.nodeinfo.StructuralInput.Anchor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main2 extends Application{
      public static void main(String[] args) {
          launch(args);
      }
      @Override
      public void start(Stage primaryStage) throws Exception {
          
          Button b1 = new Button("B1");
          Button b2 = new Button("B2");
          Button b3 = new Button("B3");
          Button b4 = new Button("B4");
          HBox  box1 = new HBox(); //VBox 同理
          AnchorPane ap = new AnchorPane();
          Scene scene = new Scene(ap);
          ap.getChildren().addAll(box1);
          box1.getChildren().addAll(b1,b2,b3,b4);

          box1.setStyle(
              "-fx-background-color:#E066FF;"+
              "-fx-pref-height:200;"+
              "-fx-pref-width:200;"
          );

          box1.setPadding(new Insets(10));  //设置box1的内边距
          box1.setSpacing(10);              //设置控件之间的横向距离
          box1.setMargin(b1,new Insets(10));//设置单个子控件的外边距
          box1.setAlignment(Pos.CENTER);

          ap.setStyle(
              "-fx-background-color:#AEEEEE;"+
              "-fx-pref-height:200;"+
              "-fx-pref-width:200;"
          );

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