package lib.UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.util.Callback;



public class MyItemList extends ListView<String> {
    public MyItemList(String GraphicUrl) {
        setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<String>() {
                    boolean isInit = false;
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!empty) {
                            if(!isInit){
                                ImageView imageView = new ImageView(GraphicUrl);
                                imageView.setPreserveRatio(true);
                                imageView.setFitHeight(20);
                                this.setGraphic(imageView);
                                this.setText(item);
                                this.setGraphicTextGap(10);
                                Style2();
                                isInit = true;
                                this.selectedProperty().addListener(new ChangeListener<Boolean>() {
                                    @Override
                                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                                        if(newValue){
                                            Style1();
                                        }else{
                                            Style2();
                                        }
                                    }
                                });
                            }


                        } else {
                            this.setStyle(
                                    "-fx-background-color: transparent;" +
                                            "-fx-pref-height: 40;"
                            );
                        }
                    }
                    public void Style1(){
                        setStyle(
                                "-fx-background-color:  #007BFF;" +
                                        "-fx-background-radius:5;" +
                                        "-fx-border-radius:5;" +
                                        "-fx-pref-height: 40;" +
                                        "-fx-border-color:transparent;" +
                                        "-fx-text-fill: white;" +
                                        "-fx-font-size: 15;" +
                                        "-fx-font-family: SongTi;" +
                                        "-fx-font-weight: 600"
                        );
                    }
                    public void Style2(){
                        setStyle(
                                "-fx-background-color:transparent;" +
                                        "-fx-background-radius:5;" +
                                        "-fx-pref-height: 40;" +
                                        "-fx-border-color:transparent;" +
                                        "-fx-border-radius:5;" +
                                        "-fx-text-fill: white;" +
                                        "-fx-font-size: 15;" +
                                        "-fx-font-family: SongTi;" +
                                        "-fx-font-weight: 600;"
                        );
                    }
                };
            }
        });
    }
}
