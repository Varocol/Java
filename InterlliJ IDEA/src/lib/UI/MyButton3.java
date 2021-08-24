package lib.UI;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MyButton3 extends Button {
    private final Color color;

    public MyButton3(String text, Color color, String GraphicUrl) {
        setText(text);
        this.color = color;
        ImageView imageView = new ImageView(GraphicUrl);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(20);
        setAlignment(Pos.CENTER_LEFT);
        setCursor(Cursor.HAND);
        setGraphicTextGap(5);
        setGraphic(imageView);
        initStyle();
    }

    public void initStyle() {
        Style1();
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Style2();
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Style1();
            }
        });
    }

    public void Style1() {
        setStyle(
                "-fx-pref-height: 35;" +
                        "-fx-pref-width: 80;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-family: SonTi;" +
                        "-fx-font-size: 15;" +
                        "-fx-background-color:#" + color.toString().substring(2) + ";" +
                        "-fx-background-radius: 5;" +
                        "-fx-font-weight: 600"
        );
    }

    public void Style2() {
        setStyle(
                "-fx-pref-height: 35;" +
                        "-fx-pref-width: 80;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-family: SonTi;" +
                        "-fx-font-size: 15;" +
                        "-fx-background-color:#" + color.darker().toString().substring(2) + ";" +
                        "-fx-background-radius: 5;"+
                        "-fx-font-weight: 600"
        );
    }
}
