import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
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
        MenuItem menuItem1 = new MenuItem("menuItem1");  //相当于一个可自制diy的menuitem
        MenuItem menuItem2 = new MenuItem("menuItem2");
        MenuItem menuItem3 = new MenuItem("menuItem3");
        CustomMenuItem cmi1 = new CustomMenuItem();
        CustomMenuItem cmi2 = new CustomMenuItem();
        ProgressBar progressBar = new ProgressBar();
        Text text = new Text("lalal");
        Scene scene = new Scene(anchorPane);

        
        cmi1.setContent(text);
        cmi2.setContent(progressBar);
        cmi2.setAccelerator(KeyCombination.valueOf("ctrl+k"));//设置快捷键
        cmi2.setOnAction(e->{                                 //设置响应事件
            System.out.println("按下响应事件");
        });
        cmi2.setOnMenuValidation(e->                          //设置只响应快捷键的事件
        {
            System.out.println("专门响应快捷键的事件");
        });

        

        menu1.getItems().addAll(menuItem1,menuItem2,menuItem3,cmi1,cmi2);
        menuBar.getMenus().addAll(menu1,menu2,menu3);

        anchorPane.getChildren().addAll(menuBar);
        anchorPane.setLeftAnchor(menuBar, 0.0);
        anchorPane.setRightAnchor(menuBar, 0.0);


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