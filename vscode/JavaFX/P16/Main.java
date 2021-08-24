import org.graalvm.compiler.asm.amd64.AMD64Assembler.AMD64MOp;
import org.graalvm.compiler.nodeinfo.StructuralInput.Anchor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.AmbientLight;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Button b  = new Button("Button");
        AnchorPane  ap1 = new AnchorPane();
        AnchorPane  ap2 = new AnchorPane();
        AnchorPane  ap3 = new AnchorPane();
        AnchorPane  ap4 = new AnchorPane();
        AnchorPane  ap5 = new AnchorPane();
        BorderPane  bor = new BorderPane();
        HBox  hbox = new HBox();
        Scene scene = new Scene(bor);
        ap1.setStyle(
            "-fx-background-color:#EE6AA7;"+
            "-fx-pref-height:100;"+
            "-fx-pref-width:200"
        );
        ap2.setStyle(
            "-fx-background-color:#98FB98;"+
            "-fx-pref-height:100;"+
            "-fx-pref-width:200"
        );
        ap3.setStyle(
            "-fx-background-color:#A0522D;"+
            "-fx-pref-height:100;"+
            "-fx-pref-width:200"
        );
        ap4.setStyle(
            "-fx-background-color:#1E90FF;"+
            "-fx-pref-height:100;"+
            "-fx-pref-width:200"
        );
        ap5.setStyle(
            "-fx-background-color:#EEEE00;"+
            "-fx-pref-height:100;"+
            "-fx-pref-width:200"
        );
        bor.setStyle(
            "-fx-background-color:#B23AEE;"+
            "-fx-pref-height:100;"+
            "-fx-pref-width:200"
        );
        hbox.setStyle(
            "-fx-background-color:#000000;"+
            "-fx-pref-height:100;"+
            "-fx-pref-width:200"
        );
        bor.setTop(ap1);
        // bor.setBottom(ap2);
        bor.setLeft(ap3);
        bor.setRight(ap4);
        bor.setCenter(ap5);
        ap1.getChildren().add(hbox);
        hbox.getChildren().add(b);
        ap1.setLeftAnchor(hbox, 100.0);
        ap1.setRightAnchor(hbox, 100.0);
        hbox.setAlignment(Pos.CENTER);
        
        ap5.getChildren().add(ap2);
        ap5.setRightAnchor(ap2, 0.0);
        ap5.setBottomAnchor(ap2, 0.0);
        ap5.setLeftAnchor(ap2, 0.0);
        // bor.setPadding(new Insets(10));
        // bor.setMargin(ap1, new  Insets(10));
        // bor.setAlignment(b, Pos.BOTTOM_RIGHT);

        // Button bu = (Button)bor.getTop();
        // System.out.println(bu.getText());

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