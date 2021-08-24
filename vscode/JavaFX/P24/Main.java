import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane);
        Label name = new Label();
        Label password = new Label();
        TextField textField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button login = new Button();
        Button clear = new Button();

        name.setText("账号:");
        name.setFont(Font.font("华文楷体",FontWeight.BLACK,20));
    
        password.setText("密码:");
        password.setFont(Font.font("华文楷体",FontWeight.BLACK,20));

        login.setText("登录");
        login.setFont(Font.font("SongTi",15));
        clear.setText("清除");
        clear.setFont(Font.font("SongTi",15));
        gridPane.getChildren().addAll(name,password,textField,passwordField,login,clear);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHalignment(login, HPos.RIGHT);
        gridPane.setConstraints(name, 0,0);
        gridPane.setConstraints(textField, 1, 0);
        gridPane.setConstraints(password, 0, 1);
        gridPane.setConstraints(passwordField, 1, 1);
        gridPane.setConstraints(clear, 0, 2);
        gridPane.setConstraints(login, 1, 2);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setStyle("-fx-background-color:pink");
        name.setUserData("oyjjyyds");
        password.setUserData("lalala");

        clear.setOnMouseClicked(MouseEvent->{
             textField.clear();
             passwordField.clear();
        });
        login.setOnMouseClicked(MouseEvent->{
            DialogPane dialogPane = new DialogPane();
            Scene sc = new Scene(dialogPane);
            Stage stage = new Stage();
            Label  text = new Label();
            if(textField.getText().equals(name.getUserData()) && passwordField.getText().equals(password.getUserData()))
            {
                text.setText("恭喜你登录成功");
                stage.setTitle("登录成功");
            }
            else
            {
                text.setText("密码或者账号输入错误");
                stage.setTitle("登录失败");
            }
            
            text.setAlignment(Pos.CENTER_LEFT);
            text.setFont(Font.font("SongTi",15));
            text.setPrefWidth(300);
            // text.setPrefHeight(100);一定不要设置高度
            text.setAlignment(Pos.CENTER);
            dialogPane.setContent(text);
            dialogPane.getButtonTypes().add(ButtonType.OK);
            Button bu = (Button)dialogPane.lookupButton(ButtonType.OK);
            bu.setOnMouseClicked(e->{
                stage.close();
            });
            
            
            stage.initOwner(primaryStage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initStyle(StageStyle.UNIFIED);
            stage.setScene(sc);
            stage.show();
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