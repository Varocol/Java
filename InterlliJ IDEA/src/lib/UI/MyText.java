package lib.UI;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public abstract class MyText extends BorderPane {
    Text text = new Text();
    Button button = new Button();
    ImageView imageView;

    public void setText(String text) {
        this.text.setText(text);
    }

    public abstract void initStyle();

    public void setmanaged(boolean bool){
        super.setManaged(bool);
        super.setVisible(bool);
    }
}
