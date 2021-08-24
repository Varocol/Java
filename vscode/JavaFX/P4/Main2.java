import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
//模态化窗口
public class Main2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
     
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage s1 =new Stage();
        s1.initModality(Modality.NONE);
        s1.setTitle("s1");
        s1.show();

        Stage s2 =new Stage();
        s2.initModality(Modality.WINDOW_MODAL);//s1是s2的父级窗口,必须关闭s2才能操作s1,即一个应用不同窗口之间的模态
        s2.setTitle("s2");
        s2.initOwner(s1);//s2是从s1弹出的窗口,关闭s1就会关闭s2,但关闭s2不会关闭s1
        s2.show();

        // Stage s3 =new Stage();
        // s3.initModality(Modality.APPLICATION_MODAL);//相当于单独的一个应用,与其他窗口处于模态状态
        // s3.setTitle("s3");
        // s3.show();


    }
}
