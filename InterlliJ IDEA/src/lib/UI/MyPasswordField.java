package lib.UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.PasswordField;

public class MyPasswordField extends PasswordField {
    public MyPasswordField() {
        initStyle1();
        addListener();
    }
    public MyPasswordField(String text){
        setText(text);
        initStyle1();
        addListener();
    }
    public void initStyle1(){
        setStyle(
                "-fx-background-color:white;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-color: #E1E4E8;" +
                        "-fx-pref-height: 35;" +
                        "-fx-pref-width: 300;"+
                        "-fx-font-size: 20;" +
                        "-fx-font-family: Consolas;"
        );
    }
    public void initStyle2(){
        setStyle(
                "-fx-background-color:white;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-color: #0366D6;" +
                        "-fx-pref-height: 35;" +
                        "-fx-pref-width: 300;"+
                        "-fx-font-size: 20;" +
                        "-fx-font-family: Consolas;"
        );
    }
    public void addListener(){
        focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue){
                    initStyle2();
                }
                else{
                    initStyle1();
                }
            }
        });
    }
}
