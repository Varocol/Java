import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main2 extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        AnchorPane ap = new AnchorPane();
        AnchorPane ap1 = new AnchorPane();
        Button b1 = new Button("B1");
        Button b2 = new Button("B2");
        Button b3 = new Button("B3");
        Button b4 = new Button("B4");
        Scene scene = new Scene(ap); 

        ap.setStyle("-fx-background-color:#91CD30");
        ap1.setStyle("-fx-background-color:#E79127");

        

        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.setX(400);
        primaryStage.setY(150);
        primaryStage.setTitle("Application");
        primaryStage.getIcons().add(new Image("http://image.campus.xbud.run/logo-img/logo_round.png"));
        primaryStage.show();

        
        ap.getChildren().addAll(ap1);
        AnchorPane.setTopAnchor(ap1, 0.0);
        AnchorPane.setLeftAnchor(ap1, 0.0);
        AnchorPane.setBottomAnchor(ap1, ap.getHeight()/2.0);
        AnchorPane.setRightAnchor(ap1, ap.getWidth()/2.0);

        ap.heightProperty().addListener(new ChangeListener<Number>(){
             @Override
             public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                AnchorPane.setBottomAnchor(ap1, ap.getHeight()/2.0);
             }
        });

        ap.widthProperty().addListener(new ChangeListener<Number>(){
            @Override
             public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                AnchorPane.setRightAnchor(ap1, ap.getWidth()/2.0);
             }
        });
        //不能用窗体的宽高来监听，因为加了阴影部分和边框部分
        
        AnchorPane.setBottomAnchor(b1, 0.0);
        AnchorPane.setRightAnchor(b1, 0.0);
        ap1.getChildren().addAll(b1,b2,b3,b4);

        // b1.setManaged(false);

        // b1.setVisible(false);

        b1.setOpacity(1);

    }
}
