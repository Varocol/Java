package lib.UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class MyTextField extends TextField {
    private final int height;
    private final int width;

    public MyTextField() {
        height = 35;
        width = 300;
        initStyle1();
        addListener();
    }

    public  MyTextField(int height, int width){
        this.height = height;
        this.width = width;
        initStyle1();
        addListener();
    }

    public MyTextField(String text,int height, int width) {
        setText(text);
        this.height = height;
        this.width = width;
        initStyle1();
        addListener();
    }

    public MyTextField(String text) {
        setText(text);
        height = 35;
        width = 300;
        initStyle1();
        addListener();
    }

    public void initStyle1() {
        setStyle(
                "-fx-background-color:white;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-color: #E1E4E8;" +
                        "-fx-pref-height: "+height+";" +
                        "-fx-pref-width: "+width+";" +
                        "-fx-font-size: 20;" +
                        "-fx-font-family: Consolas;"
        );
    }

    public void initStyle2() {
        setStyle(
                "-fx-background-color:white;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-color: #0366D6;" +
                        "-fx-pref-height: "+height+";" +
                        "-fx-pref-width: "+width+";" +
                        "-fx-font-size: 20;" +
                        "-fx-font-family: Consolas;"
        );
    }

    public void addListener() {
        focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    initStyle2();
                } else {
                    initStyle1();
                }
            }
        });
    }
}
