import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
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
        Menu son = new Menu("menuson");
        MenuItem menuItem1 =new MenuItem("item1",new ImageView("file:C:\\Users\\Varocol\\Desktop\\感叹号.png"));
        MenuItem menuItem2 =new MenuItem("item2");
        MenuItem menuItem3 =new MenuItem("item3");
        MenuItem menuItem4 =new MenuItem("item4");
        MenuItem menuItem5 =new MenuItem("item5");
        SeparatorMenuItem separatoriItem1 = new SeparatorMenuItem();
        SeparatorMenuItem separatoriItem2 = new SeparatorMenuItem();
        ToggleGroup tg = new ToggleGroup();
        RadioMenuItem rmi1 = new RadioMenuItem("RadioMenuItem1");
        RadioMenuItem rmi2 = new RadioMenuItem("RadioMenuItem2");
        RadioMenuItem rmi3 = new RadioMenuItem("RadioMenuItem3");
        CheckMenuItem cmi1 = new CheckMenuItem("CheckMenuItem1");
        CheckMenuItem cmi2 = new CheckMenuItem("CheckMenuItem2");
        CheckMenuItem cmi3 = new CheckMenuItem("CheckMenuItem3");
        Scene scene = new Scene(anchorPane);

        rmi1.setToggleGroup(tg);
        rmi2.setToggleGroup(tg);
        rmi3.setToggleGroup(tg);

        rmi1.setDisable(true);
        menu2.getItems().addAll(rmi1,rmi2,rmi3);

        rmi1.setOnAction(ActionEvent->
        {
            System.out.println("rmi1选中状态 = " + rmi1.isSelected() );
        });


        
        menu3.getItems().addAll(cmi1,cmi2,cmi3);


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
        menu1.getItems().addAll(menuItem1,separatoriItem1,menuItem2,separatoriItem2,menuItem3,menuItem4,son);
        menu1.setStyle("-fx-border-color:transparent #00000050 transparent #00000050");

        
        son.getItems().addAll(menuItem5);
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