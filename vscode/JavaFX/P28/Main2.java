import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main2 extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        CustomMenuItem cmi1 = new CustomMenuItem();
        CustomMenuItem cmi2 = new CustomMenuItem();
        MenuButton mb = new MenuButton("MenuButton");
        ProgressBar progressBar = new ProgressBar();
        Text text = new Text("lalal");
        Scene scene = new Scene(anchorPane);

        
        cmi1.setContent(text);
        cmi2.setContent(progressBar);
        
        mb.getItems().addAll(cmi1,cmi2);
        mb.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
    
        anchorPane.getChildren().addAll(mb);

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