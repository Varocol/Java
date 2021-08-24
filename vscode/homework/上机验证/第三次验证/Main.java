import java.util.*;
public class Main {
    public static void main(String args[])
    {
        Point point;
        Scanner r=new Scanner(System.in);
        System.out.println("请输入点的坐标:");
        while(r.hasNextDouble())
        {
            point=new Point(r.nextDouble(),r.nextDouble());
            point.output1();
            Point.output2();
            System.out.println("请输入点的坐标:");
        }
    }
}
