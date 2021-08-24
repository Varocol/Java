import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("menu1");
        Menu menu2 = new Menu("menu2");
        Menu menu3 = new Menu("menu3");
        Menu menu4 = new Menu("menu4");
        MenuItem menuItem1 =new MenuItem("item1",new ImageView("file:C:\\Users\\Varocol\\Desktop\\感叹号.png"));
        MenuItem menuItem2 =new MenuItem("item2");
        MenuItem menuItem3 =new MenuItem("item3");
        MenuItem menuItem4 =new MenuItem("item4");
        MenuItem menuItem5 =new MenuItem("item5");
        Scene scene = new Scene(anchorPane);

        menuItem1.setAccelerator(KeyCombination.valueOf("ctrl+i"));
 
        menuItem1.setOnAction(MouseEvent->{
            System.out.println("1");
        });
        menu1.setOnShowing(ActionEvent->{
            System.out.println("onshowing");
        });
        menu1.setOnShown(ActionEvent->{
            System.out.println("onshown");
        });
        menu1.setOnHiding(ActionEvent->{
            System.out.println("onhiding");
        });
        menu1.setOnHidden(ActionEvent->{
            System.out.println("onhidden");
        });
        menu1.getItems().addAll(menuItem1,menuItem2,menuItem3,menuItem4,menuItem5);
        menu1.setStyle("-fx-border-color:transparent #00000050 transparent #00000050");

        menuBar.getMenus().addAll(menu1,menu2,menu3,menu4);

        anchorPane.getChildren().addAll(menuBar);
        anchorPane.setPrefWidth(primaryStage.getWidth());
        anchorPane.setRightAnchor(menuBar, 0.0);
        anchorPane.setLeftAnchor(menuBar, 0.0);


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