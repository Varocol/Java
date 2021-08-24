package lib.UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Mylabel extends Label {
    public String objectText;
    public String t;
    public Label label;
    public MyTextField myTextField;
    public  Mylabel(){

    }
    public Mylabel(String objectText,String t){
        this.objectText = objectText;
        this.t = t;
        initStyle();
    }
    public void setObjectText(String objectText){
        this.objectText = objectText;
        initStyle();
    }
    public void setT(String T){
        t = T;
        initStyle();
    }
    public void initStyle(){
        label = new Label(t);
        label.setStyle(
                "-fx-font-size: 15;" +
                        "-fx-font-family: SimSun-ExtB"
        );
        myTextField = new MyTextField(20,200);
        setText(objectText);
        setGraphic(label);
        setGraphicTextGap(50);
        setAlignment(Pos.CENTER_LEFT);
        setStyle(
                "-fx-font-family: SongTi;" +
                        "-fx-font-size: 18;" +
                        "-fx-font-weight: 700;" +
                        "-fx-pref-height: 30;" +
                        "-fx-pref-width: 200;"
        );
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount() == 2){
                    myTextField.setText(label.getText());
                    setGraphic(myTextField);
                }
            }
        });
        myTextField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    label.setText(myTextField.getText());
                    setGraphic(label);
                }
            }
        });

    }

}
