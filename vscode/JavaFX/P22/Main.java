import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane);
        Button b1 = new Button("Button1");

        VBox vBox = new VBox();
        Button b2 = new Button("button2");
        Button b3 = new Button("button3");
        Separator separator =new Separator();
        vBox.getChildren().addAll(b2,separator,b3);
        vBox.setPrefHeight(200);
        vBox.setPrefWidth(200);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color:#4F4F4F");

        anchorPane.setStyle("-fx-background-color:green");
        anchorPane.getChildren().addAll(b1,vBox);
        anchorPane.setTopAnchor(b1, 0.0);
        
        b1.setOnAction(ActionEvent->
           {
               DialogPane dialogPane = new DialogPane();
               HBox hBox = new HBox();
               Stage stage = new Stage();
               Scene sc = new Scene(dialogPane);
               ImageView  imageView = new ImageView(new Image("file:C:\\Users\\Varocol\\Desktop\\感叹号.png"));
               Label label = new Label();

               hBox.getChildren().addAll(imageView,label);
               hBox.setPrefWidth(250);
               hBox.setAlignment(Pos.CENTER);
               hBox.setMargin(imageView, new Insets(20));
               
               
               imageView.setFitHeight(50);
               imageView.setPreserveRatio(true);


               label.setPrefWidth(200);
               label.setPrefHeight(10);
               label.setText("账号或密码错误");
               label.setAlignment(Pos.CENTER_LEFT);
               label.setFont(Font.font("SongTi",15));
               dialogPane.setContent(label);
               dialogPane.getButtonTypes().add(ButtonType.OK);
               dialogPane.setExpandableContent(new Text());
               dialogPane.setExpanded(false);
               dialogPane.lookupButton(ButtonType.OK).setOnMouseClicked(MouseEvent->{
                   stage.close();
               });

               stage.getIcons().add(new Image("file:C:\\Users\\Varocol\\Desktop\\错误.png"));
               stage.setScene(sc);
            //    stage.setResizable(false);
               stage.setTitle("登录失败");
               stage.initStyle(StageStyle.UNIFIED);
               stage.initOwner(primaryStage);
               stage.initModality(Modality.APPLICATION_MODAL);
               stage.show();
               MyScheduledService myScheduledService = new MyScheduledService(dialogPane, stage);
               myScheduledService.setPeriod(Duration.millis(1000));
               myScheduledService.start();
           }
        );
           


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

class MyScheduledService extends ScheduledService<Integer> {
    private DialogPane di = null;
    private Stage stage = null;
    private int i = 0;

    public MyScheduledService(DialogPane di, Stage stage) {
        this.di = di;
        this.stage = stage;
    }

    @Override
    protected Task<Integer> createTask() {
        return new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                i++;
                return i;
            }

            @Override
            protected void updateValue(Integer value) {
                if (value <= 10) {
                    MyScheduledService.this.di.setExpandableContent(new Text(String.valueOf(value)));
                } else {
                    MyScheduledService.this.cancel();
                    MyScheduledService.this.stage.close();
                }
            }
        };
    }
}