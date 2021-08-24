import javafx.event.ActionEvent;
import javafx.event.Event;

import javax.tools.Tool;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Animation.Status;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;


public class ShowStyle{
    public static Tooltip tooltip = new Tooltip();
    public ShowStyle() {
        tooltip.setFont(Font.font("SongTi",FontWeight.BLACK,20));
    }


    public static void show(Node node, Node reflectNode) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), node);// 3秒闪烁，时间长了就是淡入淡出，如4秒
        fadeTransition.setFromValue(0);// 起始透明度为0
        fadeTransition.setToValue(1);// 终止透明度为1
        fadeTransition.setCycleCount(2);// 无限期动画
        fadeTransition.setAutoReverse(true);// 开启自动反转
        fadeTransition.play();
        fadeTransition.statusProperty().addListener(new ChangeListener<Status>(){
            @Override
            public void changed(ObservableValue<? extends Status> observable, Status oldValue, Status newValue) {
                if(fadeTransition.getStatus() == Status.STOPPED)
                {
                    if(Main.autoset)
                    {
                        Main.indexUpate(1);
                        Main.imageUpate((ImageView)node);
                        fadeTransition.play();//自动播放更新模块
                    }
                    else 
                    {
                        fadeTransition.play();
                    }
                }
            }
        });
        reflectNode.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ImageView playandstop = (ImageView) ((Label) reflectNode).getGraphic();
                if (fadeTransition.getStatus() == Status.RUNNING) {
                    fadeTransition.pause();
                    playandstop.setImage(imagePath.play2image);
                    tooltip.setText("播放");
                    ((Label) reflectNode).setTooltip(tooltip);
                    
                } else {
                    fadeTransition.play();
                    playandstop.setImage(imagePath.stop2image);
                    tooltip.setText("暂停");
                    ((Label) reflectNode).setTooltip(tooltip);
                }
            }
        });
        reflectNode.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ImageView playandstop = (ImageView) ((Label) reflectNode).getGraphic();
                Image image = playandstop.getImage();
                if (image == imagePath.play1image) {
                    playandstop.setImage(imagePath.play2image);
                } else if (image == imagePath.stop1image) {
                    playandstop.setImage(imagePath.stop2image);
                }
            }
        });
        reflectNode.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ImageView playandstop = (ImageView) ((Label) reflectNode).getGraphic();
                Image image = playandstop.getImage();
                if (image == imagePath.play2image) {
                    playandstop.setImage(imagePath.play1image);
                } else if (image == imagePath.stop2image) {
                    playandstop.setImage(imagePath.stop1image);
                }
            }
        });
    }
}
class ButtonShowStyle {
    public ButtonShowStyle() {

    }

    public static void entershow(Node node) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.1), node);// 1秒闪烁，时间长了就是淡入淡出，如4秒
        fadeTransition.setFromValue(0.1);// 起始透明度为0.3
        fadeTransition.setToValue(1);// 终止透明度为1
        fadeTransition.setCycleCount(1);// 一次
        // fadeTransition.setAutoReverse(true);//开启自动反转
        fadeTransition.play();
    }

    public static void exitshow(Node node) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.1), node);// 1秒闪烁，时间长了就是淡入淡出，如4秒
        fadeTransition.setFromValue(1);// 起始透明度为1
        fadeTransition.setToValue(0.1);// 终止透明度为0.3
        fadeTransition.setCycleCount(1);// 一次
        // fadeTransition.setAutoReverse(true);//开启自动反转
        fadeTransition.play();
    }
}