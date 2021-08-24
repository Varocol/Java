import javafx.Group.group;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");

        b1.setPrefHeight(50);
        b1.setPrefWidth(50);
        b2.setPrefHeight(50);
        b2.setPrefWidth(50);
        b3.setPrefHeight(50);
        b3.setPrefWidth(50);
        b1.setLayoutX(0);
        b2.setLayoutX(100);
        b3.setLayoutX(200);
        b1.setCursor(Cursor.HAND);
        b2.setCursor(Cursor.HAND);
        b3.setCursor(Cursor.HAND);

        Group group = new Group();
        group.getChildren().addAll(b1, b2, b3);
        // group.getChildren().remove(b3);
        // group.getChildren().clear();
        // group.setAutoSizeChildren(false);
        // group.setOpacity(0.5);
        // System.out.println(group.contains(0,0));
        // System.out.println(obj.length);

        group.getChildren().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> c) {
                Object[] obj = group.getChildren().toArray();
                for (Object o : obj) {
                    Button B = (Button) o;
                    B.setPrefHeight(B.getPrefHeight() + 10);
                    B.setPrefWidth(B.getPrefWidth() + 10);
                }
                System.out.println(c.getList().size());
            }
        });

        
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button b4 = new Button("b4");
                b4.setLayoutX(300);
                b4.setPrefHeight(50);
                b4.setPrefWidth(50);
                b4.setCursor(Cursor.HAND);
                group.getChildren().add(b4);
                HostServices host = getHostServices();
                host.showDocument("www.baidu.com");
            }
        });

        Scene scene = new Scene(group);

        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.setX(400);
        primaryStage.setY(150);
        primaryStage.setTitle("Application");
        primaryStage.getIcons().add(new Image("http://image.campus.xbud.run/logo-img/logo_round.png"));
        primaryStage.show();
    }
}