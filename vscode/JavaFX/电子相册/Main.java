import java.io.File;
import java.util.Random;
import java.util.function.ToLongBiFunction;
import javafx.beans.value.*;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    static String [] imagepathlists; //图片目录路径列表
    static int index;
    static boolean autoset = false;
    static String albumName = "时光相册-记录美好";
    boolean importsuccess = false;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage Menu = new Stage();
        Stage Play = new Stage();
        menu(Menu).setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if(importsuccess)//导入成功
                {
                    Menu.close();//关闭主界面
                    play(Play);//显示新界面
                }
            }
        });
    }
    public Button menu(Stage menu){
        Screen screen = Screen.getPrimary(); //屏幕
        Rectangle2D rec = screen.getVisualBounds(); //矩形
        Tooltip tooltip = new Tooltip("图片目录路径");//文本提示
        Button Sure = new Button(); //确定按钮
        Button Import = new Button();//导入按钮
        TextField textField = new TextField();//文本框
        Label  label1 = new Label();//标签
        Label  label2 = new Label();//标签
        HBox hBox = new HBox();//HBox布局
        FlowPane flowPane = new FlowPane();//FlowPane布局
        FlowPane flowPane1 = new FlowPane();
        StackPane stackPane = new StackPane();//StackPane布局
        Scene scene = new Scene(stackPane);//Scene场景
        Image image = new Image(imagePath.coverimagepath);//封皮容器
        ImageView imageView = new ImageView(image);//封皮
        Platform.runLater(new Runnable(){//置后运行
            @Override
            public void run() {
           //设置布局
           {
            hBox.getChildren().addAll(Import,Sure); //hbox 水平布局 导入和确定
            hBox.setAlignment(Pos.CENTER);
            hBox.setSpacing(300);
            
            flowPane1.getChildren().addAll(textField,label2);//流布局 
            flowPane1.setAlignment(Pos.CENTER_LEFT);

            flowPane.getChildren().addAll(imageView,label1,flowPane1,hBox);//getChildren().addAll()添加 mageView,label1,flowPane1,hBox添加的对象
            flowPane.setOrientation(Orientation.VERTICAL);//设置垂直方向的流布局
            flowPane.setAlignment(Pos.TOP_CENTER);
            flowPane.setVgap(60);
            flowPane.setStyle(
                "-fx-background-color:transparent;"+
                "-fx-border-width:1;"+
                "-fx-border-color:black;"
            );
            flowPane.setPadding(new Insets(60,0,0,0));

            stackPane.getChildren().addAll(imageView,flowPane);
           }

          //设置组件
           {
            imageView.setFitHeight(menu.getHeight());
            imageView.setFitWidth(menu.getWidth());
            imageView.setOpacity(0.6);//不透明度

            label1.setText("时光相册");//设置文本
            label1.setPrefHeight(20);
            label1.setPrefWidth(500);
            label1.setFont(Font.font(50));//设置字体大小
            label1.setAlignment(Pos.CENTER);
            label1.setStyle(
                "-fx-border-color:black;"+
                "-fx-border-width:2;"+
                "-fx-background-color:#ffffff50;"+
                "-fx-border-radius:5;"+
                "-fx-font-family:\"华文楷体\";"+
                "-fx-font-weight:bold"

            );
            
            textField.setStyle(
                "-fx-background-color:#ffffff50;"+
                "-fx-font-size:20;"+
                "-fx-font-family:Consolas;"+
                "-fx-text-fill:blue;"+
                "-fx-border-width:2;"+
                "-fx-border-color:#00000090;"+
                "-fx-pref-height:30;"+
                "-fx-pref-width:250;"+
                "-fx-border-radius:5;"
            );

            tooltip.setFont(Font.font(15));//工具提示
            textField.setTooltip(tooltip);

            
            label2.setText("请输入图片路径");
            label2.setAlignment(Pos.CENTER);
            label2.setStyle(
                "-fx-background-color:#ffffff50;"+
                "-fx-font-size:25;"+
                "-fx-border-width:2;"+
                "-fx-border-color:#00000090;"+
                "-fx-pref-height:41;"+
                "-fx-pref-width:249;"+
                "-fx-border-radius:5;"+
                "-fx-font-family:\"华文楷体\";"+
                "-fx-font-weight:bold"
            );

            Sure.setText("确定");
            Sure.setCursor(Cursor.HAND); //鼠标的样式
            Sure.setStyle(
                "-fx-background-color:#ffffff50;"+
                "-fx-pref-height:50;"+
                "-fx-pref-width:100;"+
                "-fx-text-fill:black;"+
                "-fx-border-width:2;"+
                "-fx-border-radius:30;"+
                "-fx-background-radius:30;"+
                "-fx-border-color:black;"+
                "-fx-font-size:25;"+
                "-fx-font-family:\"华文楷体\";"+
                "-fx-font-weight:bold"
            );
            Import.setText("导入");
            Import.setCursor(Cursor.HAND);    
            Import.setStyle(
                "-fx-background-color:#ffffff50;"+
                "-fx-pref-height:50;"+
                "-fx-pref-width:100;"+
                "-fx-text-fill:black;"+
                "-fx-border-width:2;"+
                "-fx-background-radius:30;"+
                "-fx-border-radius:30;"+
                "-fx-border-color:black;"+
                "-fx-font-size:25;"+
                "-fx-font-family:\"华文楷体\";"+
                "-fx-font-weight:bold"
            );
           }
          //设置监听
           {
              Sure.setOnMouseEntered(new EventHandler<MouseEvent>(){//设置进入样式
                  public void handle(MouseEvent event) {
                    Sure.setStyle(
                        "-fx-background-color:#AF66A6;"+
                        "-fx-pref-height:50;"+
                        "-fx-pref-width:100;"+
                        "-fx-text-fill:white;"+
                        "-fx-border-width:2;"+
                        "-fx-border-radius:30;"+
                        "-fx-background-radius:30;"+
                        "-fx-border-color:#AF66A6;"+
                        "-fx-font-size:25;"+
                        "-fx-font-family:\"华文楷体\";"+
                        "-fx-font-weight:bold"
                    );
                  };
              });
              Sure.setOnMouseExited(new EventHandler<MouseEvent>(){//还原按钮样式
                  public void handle(MouseEvent event) {
                    Sure.setStyle(
                        "-fx-background-color:#ffffff50;"+
                        "-fx-pref-height:50;"+
                        "-fx-pref-width:100;"+
                        "-fx-text-fill:black;"+
                        "-fx-border-width:2;"+
                        "-fx-border-radius:30;"+
                        "-fx-background-radius:30;"+
                        "-fx-border-color:black;"+
                        "-fx-font-size:25;"+
                        "-fx-font-family:\"华文楷体\";"+
                        "-fx-font-weight:bold"
                    );
                  };
              });
              Import.setOnMouseEntered(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event) {
                    Import.setStyle(
                        "-fx-background-color:#AF66A6;"+
                        "-fx-pref-height:50;"+
                        "-fx-pref-width:100;"+
                        "-fx-text-fill:white;"+
                        "-fx-border-width:2;"+
                        "-fx-border-radius:30;"+
                        "-fx-background-radius:30;"+
                        "-fx-border-color:#AF66A6;"+
                        "-fx-font-size:25;"+
                        "-fx-font-family:\"华文楷体\";"+
                        "-fx-font-weight:bold"
                  );
                };
              });
              Import.setOnMouseExited(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event) {
                    Import.setStyle(
                      "-fx-background-color:#ffffff50;"+
                      "-fx-pref-height:50;"+
                      "-fx-pref-width:100;"+
                      "-fx-text-fill:black;"+
                      "-fx-border-width:2;"+
                      "-fx-background-radius:30;"+
                      "-fx-border-radius:30;"+
                      "-fx-border-color:black;"+
                      "-fx-font-size:25;"+
                      "-fx-font-family:\"华文楷体\";"+
                      "-fx-font-weight:bold"
                  );
                };
              });
              textField.textProperty().addListener(new ChangeListener<String>(){
                  public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                      File file = new File(newValue);  //用来判断所在目录图片数,判断文本框是否有输入,路径是否错误
                      if(file.isDirectory())
                      {
                        Fileselect fileselect = new Fileselect();
                        label2.setText("当前目录图片数:"+fileselect.getpathlist(newValue, "png","jpg").length);
                      }
                      else if(newValue.length() == 0)
                      {
                        label2.setText("请输入图片路径");  
                        importsuccess = false;
                      }
                      else
                      {
                        label2.setText("目录路径错误");  
                        importsuccess = false;
                      }
                  };
              });
              Import.setOnMouseClicked(new EventHandler<MouseEvent>(){
                  public void handle(MouseEvent event) {
                      File file = new File(textField.getText());
                      Fileselect fileselect = new Fileselect();
                      if(file.isDirectory())
                      {
                          imagepathlists = fileselect.getpathlist(textField.getText(), "png","jpg");
                          label2.setText("导入成功,可以确定!");
                          importsuccess = true;
                      }
                      else 
                      {
                          label2.setText("目录路径错误");
                          importsuccess = false;
                      }
                  };
              });
          }
        }
        });
        
        menu.setScene(scene);
        menu.getIcons().add(new Image(imagePath.iconimagepath));
        menu.show();
        menu.setTitle("欢迎使用时光相册");
        menu.setHeight(500);
        menu.setWidth(menu.getHeight()*(image.getWidth()/image.getHeight()));
        menu.setX((rec.getWidth() - menu.getWidth()) / 2);// 正中央显示
        menu.setY((rec.getHeight() - menu.getHeight()) / 2);
        menu.setResizable(false);
        return Sure;
    }
    public void play(Stage play){
        AnchorPane anchorPane = new AnchorPane();//锚布局
        BorderPane borderPane = new BorderPane();//方位布局
        StackPane stackPane = new StackPane();//图层布局
        TilePane tilePane = new TilePane();//瓦片布局
        FlowPane flowPane = new FlowPane();
        Screen screen = Screen.getPrimary();
        Rectangle2D rec = screen.getVisualBounds();
        Scene scene = new Scene(anchorPane);
        Tooltip lefttooltip = new Tooltip();
        Tooltip rightooltip = new Tooltip();
        Tooltip playandstoptooltip = new Tooltip();
        Button auto = new Button();
        Button empty = new Button();
        Label left = new Label();
        Label right = new Label();
        Label playandstop = new Label();
        Label leftbutton = new Label();
        Label rightbutton = new Label();
        ImageView imageView = new ImageView();//自动播放图片
        ImageView leftImageView = new ImageView(imagePath.left1image);
        ImageView rightImageView = new ImageView(imagePath.right1image);
        ImageView playandstopImageView = new ImageView(imagePath.stop1image);
        ImageView leftbuttonImageView = new ImageView(imagePath.left1image);
        ImageView rightbuttonImageView = new ImageView(imagePath.right1image);
        PauseTransition idle = new PauseTransition(Duration.seconds(5)); //鼠标隐藏时间

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                // 初始化
                {
                    // 设置鼠标隐藏
                    idle.setOnFinished(e -> scene.setCursor(Cursor.NONE));
                    scene.addEventHandler(Event.ANY, e -> {
                    idle.playFromStart();
                    scene.setCursor(Cursor.DEFAULT);
                    });
                    // 初始化图片列表
                    index = 0;
                    imageView.setFitHeight(play.getHeight());
                    imageUpate(imageView);
                    titleUpdate(play);
                    // 初始化提示框
                    lefttooltip.setText("上一张");
                    rightooltip.setText("下一张");
                    playandstoptooltip.setText("暂停");
                    lefttooltip.setFont(Font.font("SongTi", FontWeight.BLACK, 20));
                    rightooltip.setFont(Font.font("SongTi", FontWeight.BLACK, 20));
                    playandstoptooltip.setFont(Font.font("SongTi", FontWeight.BLACK, 20));
                    // 初始化图片呈现动画
                    StyleLoadImage(imageView, playandstop);
                }

                // 布局设置
                {
                    anchorPane.getChildren().addAll(stackPane, borderPane, tilePane);
                    anchorPane.setTopAnchor(stackPane, 0.0);//设置组件的边距
                    anchorPane.setRightAnchor(stackPane, 0.0);
                    anchorPane.setLeftAnchor(stackPane, 0.0);
                    anchorPane.setBottomAnchor(stackPane, 50.0);
                    anchorPane.setTopAnchor(borderPane, 0.0);
                    anchorPane.setRightAnchor(borderPane, 0.0);
                    anchorPane.setLeftAnchor(borderPane, 0.0);
                    anchorPane.setBottomAnchor(borderPane, 0.0);
                    // anchorPane.setLeftAnchor(auto, 100.0);
                    // anchorPane.setBottomAnchor(auto, 5.0);
                    anchorPane.setStyle("-fx-background-color:black");

                    stackPane.getChildren().addAll(imageView);
                    stackPane.setAlignment(Pos.CENTER);

                    tilePane.getChildren().addAll(auto, left, playandstop, right, empty);
                    tilePane.setAlignment(Pos.CENTER);
                    tilePane.setAlignment(auto,Pos.CENTER_LEFT);
                    tilePane.setAlignment(left,Pos.CENTER_RIGHT);
                    tilePane.setAlignment(right,Pos.CENTER_LEFT);
                    tilePane.setOpacity(0.2);

                    borderPane.setLeft(leftbutton);
                    borderPane.setRight(rightbutton);
                    borderPane.setBottom(tilePane);
                    borderPane.setAlignment(leftbutton, Pos.CENTER_LEFT);
                    borderPane.setAlignment(rightbutton, Pos.CENTER_RIGHT);
                }

                // 调整图片和按钮属性
                {
                    //对齐用的空按钮
                    empty.setVisible(false);
                    empty.setStyle("-fx-pref-width:200");

                    auto.setText("自动播放");
                    auto.setFont(Font.font(20));
                    auto.setTextFill(Color.WHITE);
                    auto.setCursor(Cursor.HAND);
                    auto.setOpacity(0.2);
                    auto.setStyle(
                        "-fx-background-color:transparent;"+
                        "-fx-border-style:solid;"+
                        "-fx-border-radius:10;"+
                        "-fx-border-color:white;"+
                        "-fx-font-size:20"
                    );

                    leftImageView.setFitHeight(50);
                    leftImageView.setPreserveRatio(true);

                    rightImageView.setFitHeight(50);
                    rightImageView.setPreserveRatio(true);
                    rightImageView.setPickOnBounds(true);

                    playandstopImageView.setFitHeight(50);
                    playandstopImageView.setPreserveRatio(true);

                    leftbuttonImageView.setFitHeight(75);
                    leftbuttonImageView.setPreserveRatio(true);

                    rightbuttonImageView.setFitHeight(75);
                    rightbuttonImageView.setPreserveRatio(true);

                    right.setGraphic(rightImageView);
                    right.setCursor(Cursor.HAND);
                    right.setTooltip(rightooltip);

                    left.setGraphic(leftImageView);
                    left.setCursor(Cursor.HAND);
                    left.setTooltip(lefttooltip);

                    playandstop.setGraphic(playandstopImageView);
                    playandstop.setCursor(Cursor.HAND);
                    playandstop.setTooltip(playandstoptooltip);

                    rightbutton.setGraphic(rightbuttonImageView);
                    rightbutton.setOpacity(0.2);
                    rightbutton.setCursor(Cursor.HAND);
                    rightbutton.setTooltip(rightooltip);

                    leftbutton.setGraphic(leftbuttonImageView);
                    leftbutton.setOpacity(0.2);
                    leftbutton.setCursor(Cursor.HAND);
                    leftbutton.setTooltip(lefttooltip);

                }

                // 设置监听
                {
                    auto.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                                ButtonShowStyle.entershow(auto);
                        };
                    });
                    auto.setOnMouseExited(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                                ButtonShowStyle.exitshow(auto);
                        };
                    });
                    auto.setOnMouseClicked(new EventHandler<MouseEvent>(){
                        public void handle(MouseEvent event) {
                            if(!autoset)
                            {
                                autoset = true;
                                auto.setStyle(
                                "-fx-background-color:#1AFA29;"+
                                "-fx-text-fill:white;" +
                                "-fx-border-style:solid;"+
                                "-fx-border-radius:10;"+
                                "-fx-text-fill:black;"+
                                "-fx-background-radius:10;"+
                                "-fx-border-color:#1AFA29;"+
                                "-fx-font-size:20"
                                );
                            }
                            else
                            {
                                autoset = false;
                                auto.setStyle(
                                "-fx-background-color:transparent;"+
                                "-fx-border-style:solid;"+
                                "-fx-border-radius:10;"+
                                "-fx-text-fill:white;"+
                                "-fx-background-radius:10;"+
                                "-fx-border-color:white;"+
                                "-fx-font-size:20"
                                );
                            }
                        };
                    });

                    left.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                            ImageView image = (ImageView) left.getGraphic();
                            image.setImage(imagePath.left2image);
                        };
                    });

                    left.setOnMouseExited(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                            ImageView image = (ImageView) left.getGraphic();
                            image.setImage(imagePath.left1image);
                        };
                    });
                    
                    left.setOnMouseClicked(new EventHandler<MouseEvent>(){
                        public void handle(MouseEvent event) {
                            indexUpate(-1);
                            imageUpate(imageView);
                            titleUpdate(play);
                        };
                    });

                    right.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                            ImageView image = (ImageView) right.getGraphic();
                            image.setImage(imagePath.right2image);
                        };
                    });

                    right.setOnMouseExited(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                            ImageView image = (ImageView) right.getGraphic();
                            image.setImage(imagePath.right1image);
                        };
                    });

                    right.setOnMouseClicked(new EventHandler<MouseEvent>(){
                        public void handle(MouseEvent event) {
                            indexUpate(1);
                            imageUpate(imageView);
                            titleUpdate(play);
                        };
                    });

                    leftbutton.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            ButtonShowStyle.entershow(leftbutton);
                        }
                    });

                    leftbutton.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            ButtonShowStyle.exitshow(leftbutton);
                        }
                    });

                    leftbutton.setOnMouseClicked(new EventHandler<MouseEvent>(){
                        public void handle(MouseEvent event) {
                            indexUpate(-1);
                            imageUpate(imageView);
                            titleUpdate(play);
                        };
                    });

                    rightbutton.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            ButtonShowStyle.entershow(rightbutton);
                        }
                    });

                    rightbutton.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            ButtonShowStyle.exitshow(rightbutton);
                        }
                    });

                    rightbutton.setOnMouseClicked(new EventHandler<MouseEvent>(){
                        public void handle(MouseEvent event) {
                            indexUpate(1);
                            imageUpate(imageView);
                            titleUpdate(play);
                        };
                    });

                    stackPane.heightProperty().addListener(new ChangeListener<Number>() {
                        @Override
                        public void changed(ObservableValue<? extends Number> observable, Number oldValue,
                                Number newValue) {
                            imageView.setFitHeight(stackPane.getHeight());
                        }
                    });
                    stackPane.widthProperty().addListener(new ChangeListener<Number>() {
                        @Override
                        public void changed(ObservableValue<? extends Number> observable, Number oldValue,
                                Number newValue) {
                            imageView.setFitWidth(stackPane.getWidth());
                        }
                    });

                    flowPane.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                            ButtonShowStyle.entershow(flowPane);
                        };
                    });
                    flowPane.setOnMouseExited(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                            ButtonShowStyle.exitshow(flowPane);
                        };
                    });
                    
                    imageView.imageProperty().addListener(new ChangeListener<Image>(){
                        public void changed(ObservableValue<? extends Image> observable, Image oldValue, Image newValue) {
                            titleUpdate(play);
                        };
                    });
                }

                // 快捷键设置
                {
                    KeyCombination keyCombination = new KeyCodeCombination(KeyCode.F11);

                    scene.getAccelerators().put(keyCombination, new Runnable() {
                        @Override
                        public void run() {
                            play.setFullScreen(!play.isFullScreen());
                        }
                    });
                }

            }

        });

        // 舞台基本属性设置
        {
            play.setMinHeight(300);//最小高度
            play.setMinWidth(700);//最小宽度
            play.setScene(scene);
            play.setTitle(albumName);
            play.getIcons().add(new Image(imagePath.iconimagepath));
            play.setHeight(800);
            play.setWidth(play.getHeight() * (imagePath.image.getWidth() / imagePath.image.getHeight()));
            play.setX((rec.getWidth() - play.getWidth()) / 2);// 正中央显示
            play.setY((rec.getHeight() - play.getHeight()) / 2);
            play.setFullScreenExitHint("");// 可以删除弹出文本
            play.setFullScreen(true);
            play.show();
        }
    }
    public static void imageUpate(ImageView imageView)
    {
        imageView.setImage(new Image("file:"+imagepathlists[index]));
        imageView.setPreserveRatio(true);//固定横纵比
    }

    public static void indexUpate(int step)
    {
        index = (index + step + imagepathlists.length) % imagepathlists.length;
    }

    public static void titleUpdate(Stage stage)
    {
        stage.setTitle(albumName + " " + imagepathlists[index]);
    }

    public void StyleLoadImage(ImageView imageView, Node playandstop) {
        ShowStyle.show(imageView, playandstop);
    }

}
