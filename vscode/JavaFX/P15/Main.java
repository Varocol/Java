import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    static boolean isManaged = false;
    static boolean isVisible = false;
    static double  opacityValue = 0;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Button b1 = new Button("Button1");
        Button b2 = new Button("Button2");
        Button b3 = new Button("Button3");
        Button b4 = new Button("Button4");

        Button b5 = new Button("b3.setManaged(false)");
        Button b6 = new Button("b3.setVisible(false)");
        Button b7 = new Button("b3.setOpacity(0)");

        AnchorPane ap = new AnchorPane();
        Scene scene = new Scene(ap);
        HBox  hbox = new HBox();
        VBox  vbox = new VBox();
        //关联
        hbox.getChildren().addAll(b1,b2,b3,b4);
        vbox.getChildren().addAll(b5,b6,b7);
        ap.getChildren().addAll(hbox,vbox);
        
        //布局属性
        {
            //设置固定窗格属性
            ap.setStyle("-fx-background-color:orange");
            ap.setTopAnchor(vbox, 100.0);
              
            //设置水平布局属性
            hbox.setStyle("-fx-background-color:#ff09fa");
            hbox.setSpacing(10);
            hbox.setPadding(new Insets(10));
            
            //设置垂直布局属性
            vbox.setStyle("-fx-background-color:#adbd13");
            vbox.setPadding(new Insets(10));
            vbox.setSpacing(10);
        }
        //按钮属性
        { 
            b1.setCursor(Cursor.HAND);
            b2.setCursor(Cursor.HAND);
            b3.setCursor(Cursor.HAND);
            b4.setCursor(Cursor.HAND);
            b5.setCursor(Cursor.HAND);
            b6.setCursor(Cursor.HAND);
            b7.setCursor(Cursor.HAND);
            
            b5.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    b3.setManaged(!b3.isManaged());
                    System.out.println("当前组件数量 = " + hbox.getChildren().size());
                    b5.setText("b3.setManaged(" + b3.isManaged() + ")");
                }
            });
            b6.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    b3.setVisible(!b3.isVisible());
                    System.out.println("当前组件数量 = " + hbox.getChildren().size());
                    b6.setText("b3.setVisible(" + b3.isVisible() + ")");
                }
            });
            b7.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    b3.setOpacity(opacityValue); 
                    System.out.println("当前组件数量 = " + hbox.getChildren().size());
                    b7.setText("b3.setOpacity(" + opacityValue + ")");
                    opacityValue = 1-opacityValue;
                }
            });
        }


        


        primaryStage.setScene(scene);
        primaryStage.setTitle("Application");
        primaryStage.setX(350);
        primaryStage.setY(200);
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.getIcons().add(new Image("http://image.campus.xbud.run/logo-img/logo_round.png"));
        primaryStage.show();
    }
}