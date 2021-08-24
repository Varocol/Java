package lib.UI;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MyButton1 extends Button {
    public MyButton1() {
        initStyle1();
        addListener();
        setCursor(Cursor.HAND);
    }

    public MyButton1(String text) {
        setText(text);
        initStyle1();
        addListener();
        setCursor(Cursor.HAND);
    }

    public void initStyle1() {
        setStyle(
                "-fx-background-color:#2EA44F;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-color: #2B9148;" +
                        "-fx-pref-height: 20;" +
                        "-fx-pref-width: 300;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size:17;" +
                        "-fx-font-family: SongTi;" +
                        "-fx-font-weight: 600"
        );
    }

    public void initStyle2() {
        setStyle(
                "-fx-background-color:#2C974B;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-color: #298545;" +
                        "-fx-pref-height: 20;" +
                        "-fx-pref-width: 300;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size:17;" +
                        "-fx-font-family: SongTi;" +
                        "-fx-font-weight: 600"
        );
    }

    public void addListener() {
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                initStyle1();
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                initStyle2();
            }
        });
    }
}
