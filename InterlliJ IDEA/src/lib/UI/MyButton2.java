package lib.UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

public class MyButton2 extends ToggleButton {

    public MyButton2() {
        initStyle();
    }

    public MyButton2(String text, Node Graphic) {
        setText(text);
        setGraphic(Graphic);
        setGraphicTextGap(20);
        setAlignment(Pos.CENTER_LEFT);
        initStyle();
    }

    public void Style1() {
        setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-pref-width: 200;" +
                        "-fx-pref-height: 50;" +
                        "-fx-font-family: Consolas;" +
                        "-fx-font-size: 20;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 5;"
        );
    }

    public void Style2() {
        setStyle(
                "-fx-background-color: #5c5a5a80;" +
                        "-fx-pref-width: 200;" +
                        "-fx-pref-height: 50;" +
                        "-fx-font-family: SimSun-ExtB;" +
                        "-fx-font-size: 20;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 5;"
        );
    }

    public void Style3() {
        setStyle(
                "-fx-background-color: #007BFF;" +
                        "-fx-pref-width: 200;" +
                        "-fx-pref-height: 50;" +
                        "-fx-font-family: SimSun-ExtB;" +
                        "-fx-font-size: 20;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 5;"
        );
    }

    public void initStyle() {
        setCursor(Cursor.HAND);
        Style1();
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!isSelected()) {
                    Style2();
                }
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!isSelected()) {
                    Style1();
                }
            }
        });
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setSelected(true);
            }
        });

        selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue){
                    Style3();
                }
                else{
                    Style1();
                }
            }
        });
    }

}
