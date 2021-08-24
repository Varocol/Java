import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import lib.UI.*;
import lib.User.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;

public class Main extends Application {
    User user;
    Stage mainWindow;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Launch();
    }

    public void Register() {
        Screen screen = Screen.getPrimary();
        Rectangle2D rectangle2D = screen.getVisualBounds();
        ImageView imageView = new ImageView(ImagesPath.App_Cover);
        MyButton1 registerButton = new MyButton1("注  册");
        MyButton1 returnButton = new MyButton1("返  回");
        Text text1 = new Text();
        Text text2 = new Text();
        Text text3 = new Text();
        Text text4 = new Text();
        Text text5 = new Text();
        Text text6 = new Text();
        MyTextField myTextField1 = new MyTextField();
        MyTextField myTextField2 = new MyTextField();
        MyPasswordField myPasswordField1 = new MyPasswordField();
        MyPasswordField myPasswordField2 = new MyPasswordField();
        MyErrorText myErrorText = new MyErrorText();
        MySuccessText mySuccessText = new MySuccessText();
        MenuButton menuButton = new MenuButton("请选择身份");
        MenuItem m1 = new MenuItem("普通管理员                 ");
        MenuItem m2 = new MenuItem("普通员工                   ");
        GridPane gridPane1 = new GridPane();
        GridPane gridPane = new GridPane();
        KeyCombination keyCombination = new KeyCodeCombination(KeyCode.ENTER);
        Scene register = new Scene(gridPane);
        Stage registerStage = new Stage();
        //布局设置
        {
            gridPane.add(imageView, 0, 0);
            gridPane.add(myErrorText, 0, 1);
            gridPane.add(mySuccessText, 0, 1);
            gridPane.add(text1, 0, 2);
            gridPane.add(gridPane1, 0, 3);
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setVgap(5);
            GridPane.setValignment(imageView, VPos.TOP);
            GridPane.setHalignment(imageView, HPos.CENTER);
            GridPane.setValignment(text1, VPos.TOP);
            GridPane.setHalignment(text1, HPos.CENTER);
            gridPane.setStyle("-fx-background-color:white");
        }
        //设置组件
        {
            closeAllText(gridPane);

            imageView.setFitHeight(80);
            imageView.setPreserveRatio(true);

            menuButton.getItems().addAll(m1, m2);
            menuButton.setStyle(
                    "-fx-pref-width: 300;" +
                            "-fx-pref-height: 30;" +
                            "-fx-font-size: 20;" +
                            "-fx-font-family: SimSun-ExtB;"
            );

            text1.setText("用户注册");
            text1.setFont(Font.font("SongTi", FontWeight.BLACK, 25.0));

            text2.setText("身份");
            text2.setFont(Font.font("SongTi", FontWeight.THIN, 18.0));

            text3.setText("工号");
            text3.setFont(Font.font("SongTi", FontWeight.THIN, 18.0));

            text4.setText("账号(至少6位，最多11位)");
            text4.setFont(Font.font("SongTi", FontWeight.THIN, 18.0));

            text5.setText("密码(至少6位，最多11位)");
            text5.setFont(Font.font("SongTi", FontWeight.THIN, 18.0));

            text6.setText("确认密码");
            text6.setFont(Font.font("SongTi", FontWeight.THIN, 18.0));

            myTextField1.setFocusTraversable(true);

            gridPane1.add(text2, 0, 0);
            gridPane1.add(menuButton, 0, 1);
            gridPane1.add(text3, 0, 2);
            gridPane1.add(myTextField1, 0, 3);
            gridPane1.add(text4, 0, 4);
            gridPane1.add(myTextField2, 0, 5);
            gridPane1.add(text5, 0, 6);
            gridPane1.add(myPasswordField1, 0, 7);
            gridPane1.add(text6, 0, 8);
            gridPane1.add(myPasswordField2, 0, 9);
            gridPane1.add(registerButton, 0, 10);
            gridPane1.add(returnButton, 0, 11);
            gridPane1.setAlignment(Pos.CENTER);
            GridPane.setMargin(registerButton, new Insets(15, 0, 15, 0));
            gridPane1.setStyle(
                    "-fx-pref-width: 430;" +
                            "-fx-background-color:#F6F8FA;" +
                            "-fx-background-radius:10.0;" +
                            "-fx-border-radius: 10.0;" +
                            "-fx-border-color: #00000025;" +
                            "-fx-border-width: 1.0;" +
                            "-fx-padding: 20.0;" +
                            "-fx-vgap: 5.0"
            );

        }
        //设置事件
        {
            m1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    menuButton.setText(((MenuItem) event.getSource()).getText().trim());
                }
            });
            m2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    menuButton.setText(((MenuItem) event.getSource()).getText().trim());
                }
            });
            myTextField1.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (newValue.length() > 20) {
                        myTextField1.setText(oldValue);
                    }
                }
            });
            myTextField2.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (newValue.length() > 11) {
                        myTextField2.setText(oldValue);
                    }
                }
            });
            myPasswordField1.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (newValue.length() > 11) {
                        myPasswordField1.setText(oldValue);
                    }
                }
            });
            myPasswordField2.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (newValue.length() > 11) {
                        myPasswordField2.setText(oldValue);
                    }
                }
            });
            register.getAccelerators().put(keyCombination, new Runnable() {
                @Override
                public void run() {
                    registerButton.getOnMouseClicked().handle(null);
                }
            });
            registerButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (myTextField2.getText().length() < 6 || myPasswordField1.getText().length() < 6) {
                        closeAllText(gridPane);
                        myErrorText.setmanaged(true);
                        myErrorText.setText("账号密码格式错误");
                        return;
                    } else if (menuButton.getText().equals("请选择身份")) {
                        closeAllText(gridPane);
                        myErrorText.setmanaged(true);
                        myErrorText.setText("您还未选择身份");
                        return;
                    } else if (!myPasswordField1.getText().equals(myPasswordField2.getText())) {
                        closeAllText(gridPane);
                        myErrorText.setmanaged(true);
                        myErrorText.setText("两次输入密码不一致");
                        return;
                    }
                    String str = User.register(menuButton.getText(), myTextField1.getText(),
                            myTextField2.getText(), myPasswordField1.getText());
                    if (str.equals("注册成功")) {
                        closeAllText(gridPane);
                        mySuccessText.setmanaged(true);
                        mySuccessText.setText(str);
                        returnButton.getOnMouseClicked().handle(null);
                    } else {
                        closeAllText(gridPane);
                        myErrorText.setmanaged(true);
                        myErrorText.setText(str);
                    }

                }
            });
            returnButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    MyScheduledService myScheduledService = new MyScheduledService(registerStage, 1);
                    myScheduledService.setPeriod(Duration.millis(1000));
                    myScheduledService.start();
                    myScheduledService.stateProperty().addListener(new ChangeListener<Worker.State>() {
                        @Override
                        public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                            if (newValue == Worker.State.CANCELLED && oldValue == Worker.State.RUNNING) {
                                Launch();
                            }
                        }
                    });
                }
            });
        }
        //舞台初始化
        {
            registerStage.setScene(register);
            registerStage.setHeight(800);
            registerStage.setWidth(800);
            registerStage.setX((rectangle2D.getWidth() - registerStage.getWidth()) / 2);
            registerStage.setY((rectangle2D.getHeight() - registerStage.getHeight()) / 2);
            registerStage.getIcons().add((new Image(ImagesPath.App_Icon)));
            registerStage.setResizable(false);
            registerStage.setTitle("员工工资管理系统 Written by OYJJ");
            registerStage.show();
        }

    }

    public void Launch() {
        Screen screen = Screen.getPrimary();
        Rectangle2D rectangle2D = screen.getVisualBounds();
        Stage launch = new Stage();
        ImageView imageView = new ImageView(ImagesPath.App_Cover);
        Text text1 = new Text();
        Text text2 = new Text();
        Text text3 = new Text();
        Text text4 = new Text();
        MenuButton mb = new MenuButton("请选择身份");
        MenuItem m1 = new MenuItem("超级管理员     ");
        MenuItem m2 = new MenuItem("普通管理员");
        MenuItem m3 = new MenuItem("普通员工");
        MyErrorText myErrorText = new MyErrorText("用户名或密码错误");
        MyTipText myTipText = new MyTipText("请联系管理员或超级管理员");
        MySuccessText mySuccessText = new MySuccessText("登录成功！");
        MyTextField textField = new MyTextField();
        MyPasswordField passwordField = new MyPasswordField();
        MyButton1 LaunchButton = new MyButton1("登  录");
        MyButton1 RegisterButton = new MyButton1("注  册");
        GridPane gridPane = new GridPane();
        GridPane gridPane1 = new GridPane();
        KeyCombination keyCombination = new KeyCodeCombination(KeyCode.ENTER);
        Scene scene = new Scene(gridPane);


        //布局初始化
        {
            gridPane.add(imageView, 0, 0);
            gridPane.add(myErrorText, 0, 1);
            gridPane.add(mySuccessText, 0, 1);
            gridPane.add(myTipText, 0, 1);
            gridPane.add(text1, 0, 2);
            gridPane.add(gridPane1, 0, 3);
            GridPane.setHalignment(imageView, HPos.CENTER);
            GridPane.setHalignment(text1, HPos.CENTER);
            GridPane.setHalignment(gridPane1, HPos.CENTER);
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setVgap(17);
            gridPane.setStyle("-fx-background-color:white");
        }
        //关闭所有提示窗口,并把焦点给textField(在设置焦点时应把现在的焦点取消)
        {
            closeAllText(gridPane);
            mb.setFocusTraversable(false);
            textField.setFocusTraversable(true);
        }
        //组件初始化
        {
            imageView.setFitHeight(80);
            imageView.setPreserveRatio(true);

            text1.setText("登录到工资系统");
            text1.setFont(Font.font("SongTi", FontWeight.BLACK, 25.0));

            text2.setText("账号/工号");
            text2.setFont(Font.font("SongTi", FontWeight.THIN, 17.0));

            text3.setText("密码");
            text3.setFont(Font.font("SongTi", FontWeight.THIN, 17.0));

            text4.setText("忘记密码?");
            text4.setFont(Font.font("SongTi", FontWeight.THIN, 17.0));
            text4.setFill(Color.valueOf("#0366D6"));
            text4.setCursor(Cursor.HAND);

            mb.getItems().addAll(m1, m2, m3);
            mb.setStyle(
                    "-fx-pref-width: 105;" +
                            "-fx-pref-height: 30;" +
                            "-fx-font-size: 13"
            );
            gridPane1.add(text2, 0, 0);
            gridPane1.add(mb, 0, 0);
            gridPane1.add(textField, 0, 1);
            gridPane1.add(text3, 0, 2);
            gridPane1.add(text4, 0, 2);
            gridPane1.add(passwordField, 0, 3);
            gridPane1.add(LaunchButton, 0, 4);
            gridPane1.add(RegisterButton, 0, 5);
            GridPane.setHalignment(text4, HPos.RIGHT);
            GridPane.setHalignment(mb, HPos.RIGHT);
            GridPane.setMargin(LaunchButton, new Insets(10, 0, 10, 0));
            gridPane1.setStyle(
                    "-fx-pref-height:320.0;" +
                            "-fx-pref-width:300.0;" +
                            "-fx-background-color:#F6F8FA;" +
                            "-fx-background-radius:10.0;" +
                            "-fx-border-radius: 10.0;" +
                            "-fx-border-color: #00000025;" +
                            "-fx-border-width: 1.0;" +
                            "-fx-padding: 20.0;" +
                            "-fx-vgap: 10.0"
            );
        }
        //事件和快捷键
        {
            m1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    mb.setText(((MenuItem) event.getSource()).getText().trim());
                }
            });
            m2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    mb.setText(((MenuItem) event.getSource()).getText().trim());
                }
            });
            m3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    mb.setText(((MenuItem) event.getSource()).getText().trim());
                }
            });
            textField.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (newValue.length() > 20) {
                        textField.setText(oldValue);
                    }
                }
            });
            passwordField.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (newValue.length() > 20) {
                        textField.setText(oldValue);
                    }
                }
            });
            LaunchButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    switch (mb.getText()) {
                        case "请选择身份":
                            myErrorText.setText("您还未选择身份");
                            closeAllText(gridPane);
                            myErrorText.setmanaged(true);
                            return;
                        case "超级管理员": {
                            user = new Super_Master();
                            break;
                        }
                        case "普通管理员": {
                            user = new Common_Master();
                            break;
                        }
                        case "普通员工": {
                            user = new Common_Member();
                            break;
                        }
                    }
                    user.setUserLaunchInfo(textField.getText(), passwordField.getText());
                    if (user.launch()) {
                        closeAllText(gridPane);
                        mySuccessText.setmanaged(true);
                        MyScheduledService myScheduledService = new MyScheduledService(launch, 2);
                        myScheduledService.setPeriod(Duration.millis(1000));
                        myScheduledService.start();
                        myScheduledService.stateProperty().addListener(new ChangeListener<Worker.State>() {
                            @Override
                            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                                if (newValue == Worker.State.CANCELLED && oldValue == Worker.State.RUNNING) {
                                    MainWindow();
                                }
                            }
                        });

                    } else {
                        myErrorText.setText("用户名或密码错误");
                        closeAllText(gridPane);
                        myErrorText.setmanaged(true);
                    }
                }
            });
            text4.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    closeAllText(gridPane);
                    myTipText.setmanaged(true);
                }
            });
            scene.getAccelerators().put(keyCombination, new Runnable() {
                @Override
                public void run() {
                    LaunchButton.getOnMouseClicked().handle(null);
                }
            });
            RegisterButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    MyScheduledService myScheduledService = new MyScheduledService(launch, 1);
                    myScheduledService.setPeriod(Duration.millis(1000));
                    myScheduledService.start();
                    myScheduledService.stateProperty().addListener(new ChangeListener<Worker.State>() {
                        @Override
                        public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                            if (newValue == Worker.State.CANCELLED && oldValue == Worker.State.RUNNING) {
                                Register();
                            }
                        }
                    });
                }
            });
        }
        //舞台初始化
        {
            launch.setScene(scene);
            launch.setHeight(700);
            launch.setWidth(800);
            launch.setX((rectangle2D.getWidth() - launch.getWidth()) / 2);
            launch.setY((rectangle2D.getHeight() - launch.getHeight()) / 2);
            launch.getIcons().add((new Image(ImagesPath.App_Icon)));
            launch.setResizable(false);
            launch.setTitle("员工工资管理系统 Written by OYJJ");
            launch.show();
        }
    }

    public void MainWindow() {
        Screen screen = Screen.getPrimary();
        Rectangle2D rectangle2D = screen.getVisualBounds();
        GridPane gridPane = new GridPane();
        ImageView imageView1 = new ImageView(ImagesPath.App_ID);
        ImageView imageView2 = new ImageView(ImagesPath.App_Money);
        ImageView imageView3 = new ImageView(ImagesPath.App_Manage);
        ImageView imageView4 = new ImageView(ImagesPath.App_User);
        ImageView imageView5 = new ImageView(ImagesPath.App_Pass);
        ImageView imageView6 = new ImageView(ImagesPath.App_Exit);
        MyButton2 topButton;
        MyButton2 individualMoney = new MyButton2("工资情况", imageView2);
        MyButton2 managedBoard = new MyButton2("管理面板", imageView3);
        MyButton2 userInfoBoard = new MyButton2("个人信息", imageView4);
        MyButton2 changeUserPass = new MyButton2("修改密码", imageView5);
        MyButton2 exit = new MyButton2("退出登录", imageView6);
        Separator separator1 = new Separator();
        Separator separator2 = new Separator();
        ToggleGroup toggleGroup = new ToggleGroup();
        Text text1 = new Text();
        Label label = new Label();
        BorderPane borderPane = new BorderPane();
        Scene manageWindow = new Scene(borderPane);
        Stage mainWindow = new Stage();

        this.mainWindow = mainWindow;
        if (user.getUser_type() == User.User_Type.common_member) {
            topButton = individualMoney;
        } else {
            topButton = managedBoard;
        }

        //图标设置
        {
            imageView1.setFitHeight(40);
            imageView1.setPreserveRatio(true);
            imageView2.setFitHeight(30);
            imageView2.setPreserveRatio(true);
            imageView3.setFitHeight(30);
            imageView3.setPreserveRatio(true);
            imageView4.setFitHeight(30);
            imageView4.setPreserveRatio(true);
            imageView5.setFitHeight(30);
            imageView5.setPreserveRatio(true);
            imageView6.setFitHeight(30);
            imageView6.setPreserveRatio(true);
        }
        //组件设置
        {
            text1.setText(user.getUser_type().getUserID());
            text1.setStyle(
                    "-fx-font-size: 25;" +
                            "-fx-font-family: SimSun-ExtB;" +
                            "-fx-fill: white;"
            );

            separator1.setStyle("-fx-pref-width: 200;");

            label.setText(user.getUserInfo("账号"));
            label.setStyle(
                    "-fx-text-fill: white;" +
                            "-fx-font-family: Consolas;" +
                            "-fx-font-size: 20;" +
                            "-fx-pref-width: 200;"
            );
            label.setCursor(Cursor.HAND);
            label.setAlignment(Pos.CENTER_LEFT);
            label.setGraphic(imageView1);
            label.setGraphicTextGap(20);

            topButton.setToggleGroup(toggleGroup);
            userInfoBoard.setToggleGroup(toggleGroup);
            changeUserPass.setToggleGroup(toggleGroup);
            exit.setToggleGroup(toggleGroup);
            topButton.setFocusTraversable(true);
        }
        //布局设置
        {
            gridPane.add(text1, 0, 0);
            gridPane.add(separator1, 0, 1);
            gridPane.add(label, 0, 2);
            gridPane.add(separator2, 0, 3);
            gridPane.add(topButton, 0, 4);
            gridPane.add(userInfoBoard, 0, 5);
            gridPane.add(changeUserPass, 0, 6);
            gridPane.add(exit, 0, 7);
            GridPane.setHalignment(text1, HPos.CENTER);
            GridPane.setMargin(text1, new Insets(20));
            GridPane.setMargin(topButton, new Insets(20, 0, 0, 0));
            gridPane.setAlignment(Pos.TOP_CENTER);
            gridPane.setStyle(
                    "-fx-background-color: #4F4F4F;" +
                            "-fx-padding: 20;" +
                            "-fx-vgap: 15"
            );
            borderPane.setLeft(gridPane);
            borderPane.setStyle("-fx-background-color: #6950a1");
        }
        //事件
        {
            individualMoney.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {
                        moneyPane(borderPane);
                    }
                }
            });
            managedBoard.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {
                        managedPane(borderPane);
                    }
                }
            });
            userInfoBoard.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {
                        userInfoPane(borderPane);
                    }
                }
            });
            changeUserPass.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {
                        passwordPane(borderPane);
                    }
                }
            });
            exit.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {
                        exitPane(borderPane);
                    }
                }
            });
            toggleGroup.selectToggle(topButton);
        }
        //舞台设置
        {
            mainWindow.setScene(manageWindow);
            mainWindow.setHeight(600);
            mainWindow.setWidth(850);
            mainWindow.setX((rectangle2D.getWidth() - mainWindow.getWidth()) / 2);
            mainWindow.setY((rectangle2D.getHeight() - mainWindow.getHeight()) / 2);
            mainWindow.getIcons().add((new Image(ImagesPath.App_Icon)));
            mainWindow.setResizable(false);
            mainWindow.setTitle("员工工资管理系统 Written by OYJJ");
            mainWindow.show();
        }
    }

    public void closeAllText(GridPane gridPane) {
        Object[] obs = gridPane.getChildren().toArray();
        for (Object ob : obs) {
            if (GridPane.getColumnIndex((Node) ob) == 0 && GridPane.getRowIndex((Node) ob) == 1) {
                ((MyText) ob).setmanaged(false);
            }
        }
    }

    public VBox titlePane(String text, String GraphicUrl) {
        VBox vBox = new VBox();
        Separator separator = new Separator();
        ImageView imageView = new ImageView(GraphicUrl);
        Label label = new Label(text, imageView);

        label.setGraphicTextGap(20);
        label.setAlignment(Pos.CENTER_LEFT);
        label.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-background-color:transparent;" +
                        "-fx-font-family: SimSun-ExtB;" +
                        "-fx-font-size: 25"
        );
        imageView.setFitHeight(30);
        imageView.setPreserveRatio(true);

        vBox.getChildren().addAll(label, separator);
        vBox.setStyle(
                "-fx-padding: 20;" +
                        "-fx-background-color: transparent;" +
                        "-fx-spacing: 20;"
        );
        return vBox;
    }

    public void managedPane(BorderPane Pane) {
        MyItemList myItemList = new MyItemList(ImagesPath.App_User);
        MyButton3 deleteButton = new MyButton3("删除", Color.RED, ImagesPath.App_Delete);
        MyButton3 addButton = new MyButton3("添加", Color.GREEN, ImagesPath.App_Add);
        MyButton3 changeButton = new MyButton3("修改", Color.BLUE, ImagesPath.App_Change);
        ImageView imageView = new ImageView(ImagesPath.App_Content);
        Label label = new Label("人员列表");
        HBox hBox = new HBox();
        VBox vBox = titlePane("管理面板", ImagesPath.App_Manage);
        Master master = (Master) user;
        ObservableList<String> observableList = myItemList.getItems();
        BorderPane borderPane = new BorderPane();
        //组件设置
        {
            imageView.setPreserveRatio(true);
            imageView.setFitHeight(20);
            label.setGraphicTextGap(15);
            label.setGraphic(imageView);
            label.setStyle(
                    "-fx-font-size: 20;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-family: SimSun-ExtB;"
            );
            vBox.getChildren().add(label);
            VBox.setMargin(label, new Insets(20, 0, 0, 0));

            setManagedList(master, "账号", observableList);
            myItemList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            myItemList.setStyle(
                    "-fx-pref-width: 450;" +
                            "-fx-pref-height: 350;" +
                            "-fx-background-color:transparent;" +
                            "-fx-border-color:#ffffff50;" +
                            "-fx-padding: 5"
            );
            myItemList.requestFocus();
            myItemList.getSelectionModel().select(0);

            hBox.getChildren().addAll(deleteButton, addButton, changeButton);
            hBox.setStyle(
                    "-fx-background-color: transparent;" +
                            "-fx-padding: 20;" +
                            "-fx-spacing: 20"
            );

            hBox.setAlignment(Pos.CENTER);
        }
        //事件处理
        {
            deleteButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (!myItemList.getSelectionModel().getSelectedIndices().isEmpty()) {
                        String Member_Id = observableList.get(myItemList.getSelectionModel().getSelectedIndex()).substring
                                (master.getManage_user_type().getUserID().length() + 1);
                        String Member_num = getManagedWordValue(master, Member_Id, "工号");
                        if (Member_num == null) return;
                        String ContentText = "您是否要删除账号为 " + Member_Id + " 的" + master.getManage_user_type().getUserID();
                        if (deleteDialogWindow(mainWindow, "删除操作", ContentText, (GridPane) Pane.getLeft(), 4) == ButtonType.OK) {
                            master.deleteManagedMember(Member_num);
                        }
                    }
                }
            });
            addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    addDialogWindow(mainWindow, "请输入您想添加的工号(至少6位):", master, (GridPane) Pane.getLeft(), 4);
                }
            });
            changeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    changeDialogWindow();
                }
            });

        }

        borderPane.setTop(vBox);
        borderPane.setCenter(myItemList);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.TOP_CENTER);
        BorderPane.setMargin(myItemList, new Insets(20));
        Pane.setCenter(borderPane);
    }

    public void moneyPane(BorderPane Pane) {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(titlePane("工资情况", ImagesPath.App_Money));
        Pane.setCenter(borderPane);
    }

    public void userInfoPane(BorderPane Pane) {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(titlePane("个人信息", ImagesPath.App_User));
        Pane.setCenter(borderPane);
    }

    public void passwordPane(BorderPane Pane) {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(titlePane("修改密码", ImagesPath.App_Pass));
        Pane.setCenter(borderPane);
    }

    public void exitPane(BorderPane Pane) {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(titlePane("退出登录", ImagesPath.App_Exit));
        Pane.setCenter(borderPane);
    }

    public void setManagedList(Master master, String Sheet_word, ObservableList<String> observableList) {
        ArrayList<String> result = new ArrayList<>();
        try {
            ResultSet resultSet = master.getManagedInfo();
            while (resultSet.next()) {
                result.add(resultSet.getString(Sheet_word));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        result.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                observableList.add(master.getManage_user_type().getUserID() + ":" + s);
            }
        });
    }

    public String getManagedWordValue(Master master, String Member_Id, String Sheet_word) {
        try {
            ResultSet resultSet = master.getSheet_managed().search("账号", Member_Id);
            if (resultSet.next()) {
                return resultSet.getString(Sheet_word);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ButtonType deleteDialogWindow(Stage MainWindow, String HeaderText, String ContentText, GridPane gridPane, int index) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(MainWindow);
        alert.initModality(Modality.APPLICATION_MODAL);
        ButtonType sure = ButtonType.OK;
        ButtonType cancel = ButtonType.CANCEL;
        alert.setHeaderText(HeaderText);
        alert.setContentText(ContentText);
        alert.getButtonTypes().setAll(sure, cancel);
        fresh(gridPane, index);
        Optional<ButtonType> result = alert.showAndWait();
        return result.orElse(null);
    }

    public void addDialogWindow(Stage MainWindow, String ContentText, Master master, GridPane gridPane, int index) {
        Screen screen = Screen.getPrimary();
        Rectangle2D rectangle2D = screen.getVisualBounds();
        DialogPane dialogPane = new DialogPane();
        HBox hBox = new HBox();
        Label label = new Label();
        Scene scene = new Scene(dialogPane);
        Stage stage = new Stage();
        MyTextField myTextField = new MyTextField();


        label.setText(ContentText);
        label.setStyle("-fx-font-size: 15");

        hBox.getChildren().addAll(label, myTextField);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setSpacing(20);

        dialogPane.setContent(hBox);
        dialogPane.getButtonTypes().add(ButtonType.CANCEL);
        dialogPane.getButtonTypes().add(ButtonType.OK);

        myTextField.setStyle(
                "-fx-background-color:white;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-color: #E1E4E8;" +
                        "-fx-pref-height: 15;" +
                        "-fx-pref-width: 200;" +
                        "-fx-font-size: 20;" +
                        "-fx-font-family: Consolas;"
        );
        myTextField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    myTextField.setStyle(
                            "-fx-background-color:white;" +
                                    "-fx-background-radius: 10;" +
                                    "-fx-border-radius: 5;" +
                                    "-fx-border-width: 2;" +
                                    "-fx-border-color: #0366D6;" +
                                    "-fx-pref-height: 15;" +
                                    "-fx-pref-width: 200;" +
                                    "-fx-font-size: 20;" +
                                    "-fx-font-family: Consolas;"
                    );
                } else {
                    myTextField.setStyle(
                            "-fx-background-color:white;" +
                                    "-fx-background-radius: 10;" +
                                    "-fx-border-radius: 5;" +
                                    "-fx-border-width: 2;" +
                                    "-fx-border-color: #E1E4E8;" +
                                    "-fx-pref-height: 15;" +
                                    "-fx-pref-width: 200;" +
                                    "-fx-font-size: 20;" +
                                    "-fx-font-family: Consolas;"
                    );
                }
            }
        });
        myTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > master.getSheet_managed().getMysql_sheet_word().get("工号")) {
                    myTextField.setText(oldValue);
                }
            }
        });

        dialogPane.lookupButton(ButtonType.OK).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (myTextField.getText().length() < 6) {
                    label.setText("工号长度小于6");
                } else {
                    if (!master.addManagedMember(myTextField.getText().trim())) {
                        label.setText("已有该工号");
                    } else {
                        dialogPane.lookupButton(ButtonType.CANCEL).getOnMouseClicked().handle(null);
                    }
                }
            }
        });
        dialogPane.lookupButton(ButtonType.CANCEL).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fresh(gridPane, index);
                stage.close();
            }
        });

        stage.initOwner(MainWindow);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.getIcons().add(new Image(ImagesPath.App_Icon));
        stage.setTitle("添加" + master.getManage_user_type().getUserID());
        stage.show();
        stage.setX((rectangle2D.getWidth() - stage.getWidth()) / 2);
        stage.setY((rectangle2D.getHeight() - stage.getHeight()) / 2);

    }

    public void changeDialogWindow() {
        Screen screen = Screen.getPrimary();
        Rectangle2D rectangle2D = screen.getVisualBounds();
        BorderPane borderPane = new BorderPane();
        Mylabel mylabel1 = new Mylabel();
        Mylabel mylabel2 = new Mylabel();
        Mylabel mylabel3 = new Mylabel();
        Mylabel mylabel4 = new Mylabel();
        Mylabel mylabel5 = new Mylabel();
        Mylabel mylabel6 = new Mylabel();
        Mylabel mylabel7 = new Mylabel();
        Mylabel mylabel8 = new Mylabel();
        Mylabel mylabel9 = new Mylabel();
        Mylabel mylabel10 = new Mylabel();
        Mylabel mylabel11 = new Mylabel();
        Mylabel mylabel12 = new Mylabel();
        Mylabel mylabel13 = new Mylabel();
//        Mylabel mylabel14 = new Mylabel();
        GridPane gridPane1 = new GridPane();
        GridPane gridPane2 = new GridPane();

        Scene scene = new Scene(borderPane);

        borderPane.setTop(titlePane("账号信息",ImagesPath.App_Data));





        Stage stage = new Stage();


        stage.setScene(scene);
    }

    public void fresh(GridPane gridPane, int row) {
        MyButton2 myButton2 = (MyButton2) gridPane.getChildren().get(row);
        myButton2.fire();
        myButton2.fire();//双击哈哈哈
    }


}

class MyScheduledService extends ScheduledService<Integer> {
    private Stage stage = null;
    private int i = 0;
    private final int seconds;

    public MyScheduledService(Stage stage, int seconds) {
        this.stage = stage;
        this.seconds = seconds;
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
                if (i == seconds) {
                    stage.hide();
                    MyScheduledService.this.cancel();
                }
            }
        };
    }
}
