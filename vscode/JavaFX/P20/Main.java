import java.util.function.Consumer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Main extends Application{
     public static void main(String[] args) {
         launch(args);
     }
     @Override
     public void start(Stage primaryStage) throws Exception {

        AnchorPane a  = new AnchorPane();
        Text text1 = new Text("Application\n");
        Text text2 = new Text("JavaFX\n");
        Text text3 = new Text("Powered by 7510\n");
        Text text4 = new Text("dddd");
        TextField textField = new TextField();
        TextFlow textFlow = new TextFlow();
        TextFlow textFlow2= new TextFlow();
        Scene scene = new Scene(a);
        
        a.getChildren().addAll(textFlow,textFlow2);
        a.setTopAnchor(textFlow, 100.0);
        a.setBottomAnchor(textFlow, 0.0);
        a.setLeftAnchor(textFlow, 100.0);
        a.setRightAnchor(textFlow, 0.0);

        // textFlow.setStyle("-fx-background-color:#EECFA1");
        textFlow.getChildren().addAll(text1,text2,text3,textField);
        // textFlow.setPadding(new Insets(10));
        // textFlow.setTextAlignment(TextAlignment.CENTER);                         
        textFlow.setLineSpacing(20); 
        textFlow2.getChildren().addAll(text4); 

        text2.setFont(Font.font("Consolas",FontWeight.BLACK,20));
        text2.setFill(Color.RED);
        text2.setBoundsType(TextBoundsType.LOGICAL);
        text2.setStyle("-fx-fill:blue");
        text2.setWrappingWidth(300);
        text2.setUnderline(true);
        text2.setTextOrigin(VPos.BOTTOM);
 

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