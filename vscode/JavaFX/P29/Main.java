import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        VBox vBox = new VBox();
        Accordion accordion = new Accordion();
        TitledPane titledPane = new TitledPane("titledpane", new Button("button"));
        TitledPane titledPane2 = new TitledPane();
        Button button = new Button("button", new ImageView("file:C:\\Users\\Varocol\\Desktop\\错误.png"));
        Scene scene = new Scene(anchorPane);

        button.setText("button");
        titledPane2.setText("titledpane2");
        titledPane2.setContent(button);
        titledPane.setGraphic(new Button("bbbbb")); // 这里放图片比较好
        titledPane.setDisable(false);
        titledPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        titledPane2.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT); //设置摆放方向

        // titledPane.setAnimated(false);

        // titledPane.setExpanded(true);

        // titledPane.setCollapsible(false);

        accordion.getPanes().addAll(titledPane, titledPane2);

        vBox.getChildren().addAll(titledPane, titledPane2);
        anchorPane.getChildren().addAll(accordion);

        accordion.expandedPaneProperty().addListener(new ChangeListener<TitledPane>() {
            @Override
            public void changed(ObservableValue<? extends TitledPane> observable, TitledPane oldValue,
                    TitledPane newValue) {
                if(newValue == null)
                {
                    System.out.println(oldValue.getText() + "折叠");
                    return;
                }
                System.out.println(newValue.getText() + "展开");
                
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
