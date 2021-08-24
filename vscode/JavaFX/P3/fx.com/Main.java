import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
        // Stage ss = new Stage();
        // ss.show();
    }

    @Override
    public void init() throws Exception {
        // Stage ss = new Stage();
        // ss.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Stage cc = new Stage();
        primaryStage.show();
        primaryStage.setTitle("laal");
        //primaryStage.close();
        //cc.show();
    }

    @Override
    public void stop() throws Exception {
        // Stage ss = new Stage();
        // ss.show();
        System.out.println("stop()");
    }
}

/*
第一点：
  不在java UI 线程里面的函数不能用Stage
第二点：
  在start()方法里的Stage对象可以暂停,其他方法内的Stage对象会自动关闭,也就是说其他的方法使用Stage对象需要用到showAndwait方法
第三点：
  要结束start()这个方法可以通过先显示窗口,再手动关闭窗口(或者用close方法)来达到结束的目的,其实就是触发了结束方法的调用
  只要有开启窗口这个动作并且关闭这个窗口就能触发结束方法,也就是说随便开一个Stage都行,不一定要他给的
第四点：
  start()方法要完全结束后才能进入stop()方法
*/
