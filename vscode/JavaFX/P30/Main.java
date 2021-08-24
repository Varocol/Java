import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        TabPane tabPane  = new TabPane();
        Tab tab1 = new Tab("tab1",new Button("button"));
        Tab tab2 = new Tab("tab2");
        Tab tab3 = new Tab("tab3");
        HBox hBox = new HBox();
        VBox vBox = new VBox();
        Scene scene = new Scene(anchorPane);
 
        hBox.getChildren().addAll(new Button("button1"),new Button("buttton2"));
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-background-color:orange");

        vBox.getChildren().addAll(new Button("button3"),new Button("buttton4"));
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color:blue");


        tab1.setText("tab1");
        // tab1.setClosable(false);
        tab1.setContent(hBox);
        tab1.setDisable(false);

        tab2.setContent(vBox);
        // tab1.setGraphic(new Button("button3"));
        // tabPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        tabPane.setRotateGraphic(false);
        // tabPane.setSide(Side.LEFT);
        tabPane.getTabs().addAll(tab1,tab2,tab3);
        tabPane.setStyle("-fx-background-color:green");
        anchorPane.getChildren().addAll(tabPane);
        AnchorPane.setTopAnchor(tabPane, 100.0);
        AnchorPane.setBottomAnchor(tabPane, 100.0);
        AnchorPane.setRightAnchor(tabPane, 350.0);
        AnchorPane.setLeftAnchor(tabPane, 100.0);
        
        tabPane.getSelectionModel().select(tab2);
        tabPane.getSelectionModel().selectLast();
        tabPane.getSelectionModel().selectPrevious();

        // tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        // tabPane.setTabClosingPolicy(TabClosingPolicy.SELECTED_TAB);

        tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>(){
           @Override
           public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
               System.out.println(newValue.getText() + " selected");
           }
        });

        tab1.setOnSelectionChanged(e->{
            System.out.println(tab1.getText() + "选择");
        });

        tab1.setOnClosed(e->{
            System.out.println("tab1.setonClosed()");
        });

        tab1.setOnCloseRequest(e->{
            System.out.println("tab1.setonClosedRequest()");
            e.consume();
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