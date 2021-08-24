import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Hyperlink link = new Hyperlink("https://github.com/1628553830?tab=repositories");
        VBox vBox = new VBox();
        Scene scene = new Scene(vBox);
        vBox.getChildren().addAll(link);
        
        link.setOnMouseClicked(MouseEvent->{
            HostServices hostServices = getHostServices();
            hostServices.showDocument(link.getText());
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